package com.sea.config;

import com.sea.interceptor.ResourcesInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

@Configuration
@PropertySource("classpath:ignoreUrl.properties")
// 等同于<context:component-scan base-package="com.sea.controller"/>
@ComponentScan({"com.sea.controller"})
@EnableWebMvc
public class SpringMvcConfig implements WebMvcConfigurer {
    /*
    开启静态资源的访问
    类似在Spring MVC的配置文件中设置<mvc:default-servlet-handler/>元素
     */
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer
    ){
        configurer.enable();
    }

    public void configureViewResolvers(ViewResolverRegistry registry){
        registry.jsp("/admin/",".jsp");
    }

    @Value("#{'${ignoreUrl}'.split(',')}")
    private List<String> ignoreUrl;
    @Bean
    public ResourcesInterceptor resourcesInterceptor(){
        return new ResourcesInterceptor(ignoreUrl);
    }

    /*
    在拦截器注册类中添加自定义拦截器
    addPathPatterns()方法设置拦截器路径
    excludePathPatterns()方法设置不拦截路径
     */

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(resourcesInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**","/js/**","/img/**");
    }
}
