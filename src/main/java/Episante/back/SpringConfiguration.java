package Episante.back;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootConfiguration
public class SpringConfiguration implements WebMvcConfigurer {
    @Override   
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(
                        "http://localhost:5174",
                        "http://localhost:5173",
                        "http://172.31.249.181:3000"
                )
                .allowedMethods("*");
    }
}








