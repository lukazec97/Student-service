package lms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
 
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
        .allowedMethods("DELETE","GET","POST","PUT","OPTION","PATCH")
        .allowedHeaders("header1", "header2", "header3", "content-type", "auth-token", "Authorization")
		.exposedHeaders("header1", "header2", "Authorization", "auth-token")
		.allowCredentials(true).maxAge(3600);
    }
}