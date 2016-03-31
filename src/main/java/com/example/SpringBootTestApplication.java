package com.example;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@SpringBootApplication
@EnableSwagger2
//http://springfox.github.io/springfox/docs/current/

//http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#howto-create-a-deployable-war-file 
public class SpringBootTestApplication extends SpringBootServletInitializer{

    public static void main(String[] args) {
        //ApplicationContext ctx =(ApplicationContext) SpringApplication.run(Application.class, args);

        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = SpringApplication.run(SpringBootTestApplication.class, args).getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println("Bean NAme:- "+beanName);
        }
    }
    /**
     * To make this application deloyable in external tomcat we need to extends SpringBootServletInitializer and override below method but if
     * you are just using in IDE then dont extends.
     * When you run on external tomcat , it will be accessible via http://localhost:8080/SpringBootTest/swagger-ui.html and http://localhost:8080/SpringBootTest/lighting/getAllSLCs/28 
     * WithSpringBoot IDE it will be http://localhost:8080/swagger-ui.html and http://localhost:8080/lighting/getAllSLCs/28
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootTestApplication.class);
    }
    
    //Enable Swagger
    
    /*@Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(or(
                                regex("^/ids/v1/(.*)"),
                                regex("^/services/ids/(.*)")
                        ))
                .build()
                .apiInfo(new ApiInfo(
                                "IoT Developer Services",
                                null,
                                "1.0",
                                null,
                                "Verizon",
                                "Verizon",
                                "http://www.verizon.com/about/terms/"
                        ));
    }*/
    
    /*@Bean
    public Docket api() {                
        return new Docket(DocumentationType.SWAGGER_2)          
          .select()                                       
          .apis(RequestHandlerSelectors.basePackage("com.example.controller"))
          .paths(PathSelectors.ant("/hello/*"))                     
          .build();
    }*/
}