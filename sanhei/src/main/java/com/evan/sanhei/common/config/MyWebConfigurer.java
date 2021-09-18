package com.evan.sanhei.common.config;

import com.evan.sanhei.common.interceptor.LoginInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: WJ-LUO
 * @description: 通过这个配置类，我们添加了之前写好的拦截器。
 * @author: Jimu.Luo
 * @create: 2021-09-15 10:05
 **/

@SpringBootConfiguration
public class MyWebConfigurer implements WebMvcConfigurer {

    @Bean
    public LoginInterceptor getLoginIntercepter() {
        return new LoginInterceptor();
    }

    //后端拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(getLoginIntercepter()).addPathPatterns("/**").excludePathPatterns("/index.html");
    }

    // 在每个接口前加@CrossOrigin 注解，或者把下面这段代码放开20210915
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //所有请求都允许跨域
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*");
    }

    //将URL 的前缀跟我们设置的图片资源文件夹，即 f:/gitdownloads/wj-luo/wj-vue/src/assets/coverimg 对应起来。
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/WJ-LUO/file/**").addResourceLocations("file:f:/gitdownloads/wj-luo/wj-vue/src/assets/coverimg/");
    }
}
