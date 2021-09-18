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

    //后端拦截器，登出登录界面不需拦截
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(getLoginIntercepter())
                .addPathPatterns("/**")
                .excludePathPatterns("/index.html")
                .excludePathPatterns("/WJ-LUO/login")
                .excludePathPatterns("/WJ-LUO/logout")
                //swagger不拦截
                .excludePathPatterns("/rest/login.do/info")
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
    }

    // 在每个接口前加@CrossOrigin 注解，或者把下面这段代码放开20210915
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //所有请求都允许跨域，使用这种配置方法就不能在 interceptor 中再配置 header 了
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedOrigins("http://localhost:8080")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .allowedHeaders("*")
                .maxAge(3600);
    }

    //将URL 的前缀跟我们设置的图片资源文件夹，即 f:/gitdownloads/wj-luo/wj-vue/src/assets/coverimg 对应起来。
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //加载图片
        registry.addResourceHandler("/WJ-LUO/file/**").addResourceLocations("file:f:/gitdownloads/wj-luo/wj-vue/src/assets/coverimg/");

        //swagger不拦截，swagger增加url映射
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
