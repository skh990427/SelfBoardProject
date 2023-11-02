package company.cslee.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception {
        http
                .csrf().disable();
                /**
                 * csrf 메소드와 disable 메소드는 CSRF(크로스 사이트 요청 위조)라는 인증된 사용자를
                 * 이용해 서버에 위험을 끼치는 요청들을 보내는 공격을 방어하기 위해
                 * POST 요청마다 token이 필요한 과정을 생략하겠음을 의미
                 */
        return http.build();
    }
}
