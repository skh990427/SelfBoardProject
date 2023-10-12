package company.cslee.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // 허용할 오리진을 지정합니다.
                registry.addMapping("/user/signup") // 원하는 엔드포인트를 지정
                        .allowedOrigins("http://localhost:8081"); // 클라이언트 도메인
            }
        };
    }
}