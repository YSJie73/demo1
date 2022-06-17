package com.example.config;

import org.springframework.boot.system.ApplicationHome;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.io.File;
import java.net.URL;

@Configuration
public class FileHandlerConfig extends WebMvcConfigurationSupport {

    @Bean
    LoginInterceptor myLoginInterceptor(){
        return new LoginInterceptor();
    }



    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        File path= null;
        URL url = FileHandlerConfig.class.getResource("");
        String protocol = url.getProtocol();
        ApplicationHome h = new ApplicationHome(getClass());
        path = h.getSource();

        String staticPath="";
        if(protocol.equals("jar")){    //被打成jar包运行
            System.out.println("jar---------------");
            staticPath=path.getParentFile().toString();
        }else{
            System.out.println("class-------------");
            staticPath=path.getParentFile().getParentFile().toString();
        }

        System.out.println(staticPath);
        File f=new File(staticPath+"/upload");
        if(!f.exists()){
            f.mkdirs();
        }

        MiniAppConfig.setUploadPath(staticPath+"/upload");
        registry.addResourceHandler("/**").addResourceLocations("file:"+staticPath+"/","classpath:/admin1/");

        super.addResourceHandlers(registry);
    }
}
