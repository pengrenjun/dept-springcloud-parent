package com.RibbonRule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: 自定义轮询算法 实现轮询 每个服务服务2次之后 才轮询到下个服务
 * @Author：pengrj
 * @Date : 2018/12/30 0030 12:34
 * @version:1.0
 */
@Configuration
public class SRRoundRobinRule extends AbstractLoadBalancerRule {

    //当前服务坐标的计数
    private AtomicInteger nextServerCyclicCounter;

    /*定义的每个服务的服务次数*/
    private final int count=2;

    /*服务的次数*/
    private int serviceTotal;


    private static Logger log = LoggerFactory.getLogger(RoundRobinRule.class);

    public SRRoundRobinRule() {
        nextServerCyclicCounter = new AtomicInteger(0);
        serviceTotal=0;
    }

    public SRRoundRobinRule(ILoadBalancer lb) {
        this();
        setLoadBalancer(lb);
    }

    /*主要修改这部分的服务查找返回算法*/
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            log.warn("no load balancer");
            return null;
        }

        Server server = null;
        int count = 0;
        while (server == null && count++ < 10) {
            List<Server> reachableServers = lb.getReachableServers();
            List<Server> allServers = lb.getAllServers();
            int upCount = reachableServers.size();
            //所有可用服务的数量
            int serverCount = allServers.size();

            if ((upCount == 0) || (serverCount == 0)) {
                log.warn("No up servers available from load balancer: " + lb);
                return null;
            }

            int nextServerIndex = incrementAndGetModulo(serverCount);
            if(serviceTotal<count){
                //如果当前的服务次数小于规定的服务次数，返回当前的服务
                server=allServers.get(nextServerIndex);
                decrementAndGetModulo(serverCount);
                //服务次数累加
                serviceTotal++;
            }
            else {
                //如果当前的服务次数达到了规定的服务次数，查找下一个服务
                //获取到下次服务在list集合中的坐标位置

                server = allServers.get(nextServerIndex);
                serviceTotal=0;
            }

            if (server == null) {
                /* Transient. */
                Thread.yield();
                continue;
            }

            if (server.isAlive() && (server.isReadyToServe())) {
                return (server);
            }

            // Next.
            server = null;
        }

        if (count >= 10) {
            log.warn("No available alive servers after 10 tries from load balancer: "
                    + lb);
        }
        return server;
    }

    /**
     * Inspired by the implementation of {@link AtomicInteger#incrementAndGet()}.
     *
     * @param modulo 可用服务的总数.
     * @return The next value.
     */
    private int incrementAndGetModulo(int modulo) {
            for (;;) {
                //当前服务的坐标位置
                int current = nextServerCyclicCounter.get();
                //下一个服务的坐标位置
                int next = (current + 1) % modulo;
                if (nextServerCyclicCounter.compareAndSet(current, next)){
                    return next;
                }

            }
    }

    private int decrementAndGetModulo(int modulo) {
        for (;;) {
            //当前服务的坐标位置
            int current = nextServerCyclicCounter.get();
            //上一个服务的坐标位置
            int prev = (current - 1) % modulo;
            if (nextServerCyclicCounter.compareAndSet(current, prev)){
                return prev;
            }

        }
    }
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        return null;
    }


}


