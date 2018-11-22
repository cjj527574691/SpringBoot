package com.cui.config;

import com.cui.view.HtmlResourceView;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * springmvc 配置信息
 *
 * @EnableWebMvc 开启springmvc 功能
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.cui.controller"})
public class WebConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/WEB-INF/**").addResourceLocations("/WEB-INF/");
        registry.addResourceHandler("/views/**").addResourceLocations("/views/");
    }

    // springboot 整合jsp 最好是war
    // 需要配置视图转换器
    // 创建SpringMVC视图解析器
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        //FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
        viewResolver.setViewClass(HtmlResourceView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".html");
        viewResolver.setOrder(0);
        //viewResolver.setContentType("text/html");
        // 可以在JSP页面中通过${}访问beans
        //viewResolver.setExposeContextBeansAsAttributes(true);

        return viewResolver;
    }

}
