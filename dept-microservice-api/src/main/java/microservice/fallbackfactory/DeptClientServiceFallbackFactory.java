package microservice.fallbackfactory;

import entity.Dept;
import feign.hystrix.FallbackFactory;
import microservice.deptfeign.DeptFeignService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description: 客户端调用部门微服务接口异常统一处理 实现服务降级处理
 * 替换在微服务的controller进行熔断处理 @HystrixCommand(fallbackMethod = "deptGetHystrixCommand")
 * @Author：pengrj
 * @Date : 2018/12/30 0030 18:13
 * @version:1.0
 */
@Component//需要添加这个注解
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptFeignService> {
    @Override
    //客户端调用微服务接口的异常统一处理
    public DeptFeignService create(Throwable throwable) {
        return new DeptFeignService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(String id) {
                Dept dept=new Dept();
                dept.setDeptno(Long.valueOf(id));
                return dept;
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}
