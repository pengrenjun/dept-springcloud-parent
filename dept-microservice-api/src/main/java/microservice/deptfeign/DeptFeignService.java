package microservice.deptfeign;

import entity.Dept;
import microservice.fallbackfactory.DeptClientServiceFallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//部门微服务接口 具有客户端 微服务调用异常服务降级的处理
//客户端服务降级：在注解@FeignClient中添加 fallbackFactory 属性值
@FeignClient(value = "DEPT-COM.DEPT.SERVICE",fallback = DeptClientServiceFallbackFactory.class)
public interface DeptFeignService {

    @RequestMapping(value = "/deptManage/add", method = RequestMethod.POST)
     boolean add(Dept dept);

    @RequestMapping(value = "/deptManage/get/{id}", method = RequestMethod.GET)
     Dept get(String id);

    @RequestMapping(value = "/deptManage/list", method = RequestMethod.GET)
     List<Dept> list();
}
