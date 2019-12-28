package com.vsu.by.app.common.config.servlet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
        "com.vsu.by.app.education",
        "com.vsu.by.app.people",
        "com.vsu.by.app.role",
})
public class ServletConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }

    @Bean
    public InternalResourceViewResolver setupViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("WEB-INF/view");
        resolver.setSuffix(".jsp");
        resolver.setContentType("text/html; charset-UTF-8");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    /**@Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .maxAge(3600);
    }*/

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("login");
    }
}
