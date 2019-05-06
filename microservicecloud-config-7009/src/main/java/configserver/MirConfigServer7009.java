package configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Description: 微服务配置中心主启动类
 * @Author：pengrj
 * @Date : 2019/1/5 0005 11:02
 * @version:1.0
 */
@SpringBootApplication
@EnableConfigServer
public class MirConfigServer7009 {

    public static void main(String[] args) {
        SpringApplication.run(MirConfigServer7009.class, args);
    }
}
