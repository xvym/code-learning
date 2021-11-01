package cn.com.xvym.action;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @Author: Xv
 * @Date: 2021/8/22 11:13
 * @Description:
 */
@SpringBootApplication
public class XvActionApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(XvActionApplication.class, args);
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(XvActionApplication.class);
    }

}
