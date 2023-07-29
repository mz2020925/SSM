package com.itheima.config;

import com.itheima.controller.interceptor.ProjectInterceptor1;
import com.itheima.controller.interceptor.ProjectInterceptor2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan({"com.itheima.controller"})
@EnableWebMvc
public class SpringMvcConfig implements WebMvcConfigurer {
    // 用SpringMvcConfig继承WebMvcConfigurer，然后实现addInterceptors拦截器方法，
    // 实现addResourceHandlers资源过滤器方法(这个是把html不给springMVC处理，过滤给tomcat处理),
    // 上述这种做法就代替SpringMvcSupport.java文件的作用了，此时这个文件没有用的，也无需扫描它。从而实现简化开发了，但不推荐。
    // 因为这个时候，拦截器通过SpringMvcConfig配置文件实现，绑定性较强，如果后面不用SpringMvcConfig配置文件，拦截器也会没有。
    @Autowired
    private ProjectInterceptor1 projectInterceptor1;
    @Autowired
    private ProjectInterceptor2 projectInterceptor2;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 配置拦截器链，下面拦截器的顺序是按照添加顺序进行的：先1后2。拦截器里面的方法执行顺序想象运维人员进去的一道一道门，和出来的一道一道门。
        registry.addInterceptor(projectInterceptor1).addPathPatterns("/books", "/books/*");
        registry.addInterceptor(projectInterceptor2).addPathPatterns("/books", "/books/*");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
        registry.addResourceHandler("/plugins/**").addResourceLocations("/plugins/");
    }
}
