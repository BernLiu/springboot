package springboot.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import springboot.dubbo.consumer.CityDubboConsumerService;

@SpringBootApplication
public class DubboClientApplication {

	// 程序启动入口
	// 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(DubboClientApplication.class, args);
		CityDubboConsumerService cityService = run.getBean(CityDubboConsumerService.class);
		cityService.printCity();
	}
}
