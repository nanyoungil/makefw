/**
 * 
 */
package egovframework.com.daim.fw.security;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

/**
 * 
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	WebSecurityCustomizer webSecurityCustomizer() {
		// 정적 리소스들이 보안필터를 거치지 않게끔
		return (web) -> web.ignoring().requestMatchers("/css/**", "/js/**", "/img/**", "/font/**");
		// return (web) -> web.ignoring().antMatchers("/css/**", "/js/**", "/img/**",
		// "/font/**");
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//		http.cors().disable()                               // cors 방지
//                .csrf().disable()                           // csrf 방지
//                .headers().frameOptions().disable();        // x frame 방어 해제
//
//        http.authorizeRequests()
//                // 페이지 권한 설정
//                .antMatchers("/member/**").hasRole("USER")
//                .antMatchers("/board/**").hasRole("USER")
//                .anyRequest().permitAll();
//
//        http.formLogin()
//                    .loginPage("/loginForm")
//                    .loginProcessingUrl("/login")
//                    .defaultSuccessUrl("/")
//                    .failureUrl("/login?error=true")
//                    .usernameParameter("email")
//                    .passwordParameter("password")
//                .and()
//                    .logout()
//                    .logoutSuccessUrl("/?logout=true")
//                    .invalidateHttpSession(true)
//                    .deleteCookies("JSESSIONID");
//
//        // status code 핸들링
//        http.exceptionHandling().accessDeniedPage("/denied");

		// spring boot 2.7.14에서 spring boot 3.2.3로 프로젝트 마이그레이션 진행 중
		// SecurityConfiguration에서
		// Spring 3.1.0 이상의 환경에서는 Spring Security 6.1.0 버전을 따라야

		// 따라서 Security version 6.1이후 버전에서 지원하는 Lambda DSL 방식으로 Migration 한다면 해당 에러를 해결할
		// 수 있습니다.

		http.cors((corsConfig) -> 
						corsConfig.disable()
				)
			.csrf((csrfConfig) -> 
						csrfConfig.disable()
				)
			.headers((headerConfig) -> 
						headerConfig.frameOptions((frameOptionsConfig -> 
													frameOptionsConfig.sameOrigin()
												)
						)
				)
			.formLogin((formLoginConfig) -> 
							formLoginConfig.loginPage("/login").disable()
				)
			.authorizeHttpRequests((authorizeRequests) -> 
										authorizeRequests
											//.requestMatchers(PathRequest.toH2Console()).permitAll()
											.requestMatchers("/", "/css/**", "/img/**", "/js/**", "/font/**").permitAll()
											.requestMatchers("/", "/login/**").permitAll()
											.requestMatchers("/posts/**", "/api/v1/posts/**").hasRole("IS_AUTHENTICATED_ANONYMOUSLY")
											.requestMatchers("/admins/**", "/api/v1/admins/**").hasRole("IS_AUTHENTICATED_REMEMBERED")
											.requestMatchers(HttpMethod.GET, "/**").permitAll()
											.anyRequest().authenticated())
			.logout((logout) -> 
						logout.logoutSuccessUrl("/")
				);

		return http.build();
	}

}
