# [2m
# [32m
# [35m
# [36m
# [0;39m
# ------------------------------------------------------------------------------------
# 2025-02-25 오후 8:00:18 eclipse console log 의 경고 
[WARNING] The requested profile "pom.xml" could not be activated because it does not exist.
# 작동하는데 문제 없고, 검색해봐도 특별한 해결책을 찾지 못함.

# ------------------------------------------------------------------------------------
# 2025-02-25 오후 8:05:49 eclipse console log 의 오류 - boot 시, SecurityConfig.java 생성 후
Error starting ApplicationContext. To display the condition evaluation report re-run your application with 'debug' enabled.
2025-02-25T19:54:41.795+09:00 ERROR 1804 --- [makefw] o.s.boot.SpringApplication : Application run failed

org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration': Unsatisfied dependency expressed through method 'setFilterChains' parameter 0: Error creating bean with name 'filterChain' defined in class path resource [egovframework/com/daim/fw/security/SecurityConfig.class]: Failed to instantiate [org.springframework.security.web.SecurityFilterChain]: Factory method 'filterChain' threw exception with message: ROLE_USER should not start with ROLE_ since ROLE_ is automatically prepended when using hasAnyRole. Consider using hasAnyAuthority instead.
	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredMethodElement.resolveMethodArguments(AutowiredAnnotationBeanPostProcessor.java:896) ~[spring-beans-6.2.3.jar:6.2.3]
	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredMethodElement.inject(AutowiredAnnotationBeanPostProcessor.java:849) ~[spring-beans-6.2.3.jar:6.2.3]
	
	at egovframework.com.daim.BootDaimApplication.main(BootDaimApplication.java:10) ~[classes/:na]
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'filterChain' defined in class path resource [egovframework/com/daim/fw/security/SecurityConfig.class]: Failed to instantiate [org.springframework.security.web.SecurityFilterChain]: Factory method 'filterChain' threw exception with message: ROLE_USER should not start with ROLE_ since ROLE_ is automatically prepended when using hasAnyRole. Consider using hasAnyAuthority instead.
	at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:657) ~[spring-beans-6.2.3.jar:6.2.3]	
	
	... 22 common frames omitted
Caused by: org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.security.web.SecurityFilterChain]: Factory method 'filterChain' threw exception with message: ROLE_USER should not start with ROLE_ since ROLE_ is automatically prepended when using hasAnyRole. Consider using hasAnyAuthority instead.
	at org.springframework.beans.factory.support.SimpleInstantiationStrategy.lambda$instantiate$0(SimpleInstantiationStrategy.java:199) ~[spring-beans-6.2.3.jar:6.2.3]

	... 39 common frames omitted
Caused by: java.lang.IllegalArgumentException: ROLE_USER should not start with ROLE_ since ROLE_ is automatically prepended when using hasAnyRole. Consider using hasAnyAuthority instead.
	at org.springframework.util.Assert.isTrue(Assert.java:135) ~[spring-core-6.2.3.jar:6.2.3]

# 팩토리 메서드 'filterChain'이 다음 메시지와 함께 예외를 발생시켰습니다: ROLE_USER는 ROLE_로 시작하면 안 됩니다. hasAnyRole을 사용할 때 ROLE_가 자동으로 앞에 붙기 때문입니다. 대신 hasAnyAuthority를 ​​사용하는 것을 고려하세요.
# 그래서, ROLE_USER, ROLE_ADMIN을 변경했다.  # .hasRole("ROLE_USER") -> .hasRole("IS_AUTHENTICATED_ANONYMOUSLY")

# ------------------------------------------------------------------------------------
# 2025-02-25 오후 8:49:06 http://localhost:8081/makefw 페이지 오픈시, console.log 오류
2025-02-25T20:46:32.476+09:00  INFO 13464 --- [makefw] [nio-8081-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2025-02-25T20:46:32.476+09:00  INFO 13464 --- [makefw] [nio-8081-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2025-02-25T20:46:32.477+09:00 DEBUG 13464 --- [makefw] [nio-8081-exec-1] o.s.web.servlet.DispatcherServlet        : Detected StandardServletMultipartResolver
2025-02-25T20:46:32.477+09:00 DEBUG 13464 --- [makefw] [nio-8081-exec-1] o.s.web.servlet.DispatcherServlet        : Detected AcceptHeaderLocaleResolver
2025-02-25T20:46:32.477+09:00 DEBUG 13464 --- [makefw] [nio-8081-exec-1] o.s.web.servlet.DispatcherServlet        : Detected FixedThemeResolver
2025-02-25T20:46:32.478+09:00 DEBUG 13464 --- [makefw] [nio-8081-exec-1] o.s.web.servlet.DispatcherServlet        : Detected org.springframework.web.servlet.view.DefaultRequestToViewNameTranslator@a2915f1
2025-02-25T20:46:32.478+09:00 DEBUG 13464 --- [makefw] [nio-8081-exec-1] o.s.web.servlet.DispatcherServlet        : Detected org.springframework.web.servlet.support.SessionFlashMapManager@4954ba27
2025-02-25T20:46:32.478+09:00 DEBUG 13464 --- [makefw] [nio-8081-exec-1] o.s.web.servlet.DispatcherServlet        : enableLoggingRequestDetails='false': request parameters and headers will be masked to prevent unsafe logging of potentially sensitive data
2025-02-25T20:46:32.479+09:00  INFO 13464 --- [makefw] [nio-8081-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 3 ms
2025-02-25T20:46:32.498+09:00 ERROR 13464 --- [makefw] [nio-8081-exec-1] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception

org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'org.springframework.boot.autoconfigure.h2.H2ConsoleProperties' available
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBean(DefaultListableBeanFactory.java:373) ~[spring-beans-6.2.3.jar:6.2.3]

# SecurityConfig.java 파일 내용. authorizeRequests.requestMatchers(PathRequest.toH2Console()).permitAll() 에 대한 설정(?) 또는 제거(주석처리) - 주석처리함.

# ------------------------------------------------------------------------------------
# 2025-02-25 오후 8:52:36 url 오류에 대한 메시지 페이지
Whitelabel Error Page
This application has no explicit mapping for /error, so you are seeing this as a fallback.

Tue Feb 25 20:51:57 KST 2025
There was an unexpected error (type=Not Found, status=404).
# ------------------
2025-02-25T20:55:18.816+09:00 DEBUG 10224 --- [makefw] [nio-8081-exec-3] o.s.web.servlet.DispatcherServlet        : GET "/makefw", parameters={}
2025-02-25T20:55:18.818+09:00 DEBUG 10224 --- [makefw] [nio-8081-exec-3] o.s.web.servlet.DispatcherServlet        : "ERROR" dispatch for GET "/error", parameters={}
# Controller 를 생성하고 해당 url 에 대한 메소드를 작성해준다. /makefw/src/main/resources/templates 하위에 url 에 맞게 작성한다.

# ------------------------------------------------------------------------------------
# 2025-02-25 오후 9:22:19 
# /makefw/src/main/resources/templates 하위가 작성되고 난 후에 SecurityConfig.java 에 작성된 내용에대한 다른 경로에 대한 오류발생.  /img 는 의외였다.
2025-02-25T21:15:33.156+09:00 [33m WARN 8900 --- [makefw] [           main] o.s.s.c.a.web.builders.WebSecurity       : You are asking Spring Security to ignore Deferred [Mvc [pattern='/css/**'], Ant [pattern='/css/**']]. This is not recommended -- please use permitAll via HttpSecurity#authorizeHttpRequests instead.
2025-02-25T21:15:33.156+09:00 [33m WARN 8900 --- [makefw] [           main] o.s.s.c.a.web.builders.WebSecurity       : You are asking Spring Security to ignore Deferred [Mvc [pattern='/js/**'], Ant [pattern='/js/**']]. This is not recommended -- please use permitAll via HttpSecurity#authorizeHttpRequests instead.
2025-02-25T21:15:33.156+09:00 [33m WARN 8900 --- [makefw] [           main] o.s.s.c.a.web.builders.WebSecurity       : You are asking Spring Security to ignore Deferred [Mvc [pattern='/img/**'], Ant [pattern='/img/**']]. This is not recommended -- please use permitAll via HttpSecurity#authorizeHttpRequests instead.
2025-02-25T21:15:33.156+09:00 [33m WARN 8900 --- [makefw] [           main] o.s.s.c.a.web.builders.WebSecurity       : You are asking Spring Security to ignore Deferred [Mvc [pattern='/font/**'], Ant [pattern='/font/**']]. This is not recommended -- please use permitAll via HttpSecurity#authorizeHttpRequests instead.

# ------------------------------------------------------------------------------------
# 2025-02-25 오후 11:28:40 
# 페이지에 대한 정의 설정 ?? 
2025-02-25T23:25:54.317+09:00 DEBUG 18944 --- [makefw] [nio-8081-exec-3] o.s.web.servlet.DispatcherServlet        : GET "/", parameters={}
2025-02-25T23:25:54.318+09:00 DEBUG 18944 --- [makefw] [nio-8081-exec-3] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped to egovframework.com.daim.fw.work.base.BaseController#def()
2025-02-25T23:25:54.318+09:00 DEBUG 18944 --- [makefw] [nio-8081-exec-3] o.s.w.s.v.ContentNegotiatingViewResolver : Selected 'text/html' given [text/html, application/xhtml+xml, image/avif, image/webp, image/apng, application/xml;q=0.9, */*;q=0.8, application/signed-exchange;v=b3;q=0.7]
2025-02-25T23:25:54.318+09:00 DEBUG 18944 --- [makefw] [nio-8081-exec-3] o.s.w.servlet.view.InternalResourceView  : View name [home], model {}
2025-02-25T23:25:54.318+09:00 DEBUG 18944 --- [makefw] [nio-8081-exec-3] o.s.w.servlet.view.InternalResourceView  : Forwarding to [home]
2025-02-25T23:25:54.318+09:00 DEBUG 18944 --- [makefw] [nio-8081-exec-3] o.s.web.servlet.DispatcherServlet        : "FORWARD" dispatch for GET "/home", parameters={}
2025-02-25T23:25:54.320+09:00 DEBUG 18944 --- [makefw] [nio-8081-exec-3] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped to ResourceHttpRequestHandler [classpath [META-INF/resources/], classpath [resources/], classpath [static/], classpath [public/], ServletContext [/]]
2025-02-25T23:25:54.321+09:00 DEBUG 18944 --- [makefw] [nio-8081-exec-3] o.s.w.s.r.ResourceHttpRequestHandler     : Resource not found
2025-02-25T23:25:54.322+09:00 DEBUG 18944 --- [makefw] [nio-8081-exec-3] .w.s.m.s.DefaultHandlerExceptionResolver : Resolved [org.springframework.web.servlet.resource.NoResourceFoundException: No static resource home.]
2025-02-25T23:25:54.322+09:00 DEBUG 18944 --- [makefw] [nio-8081-exec-3] o.s.web.servlet.DispatcherServlet        : Exiting from "FORWARD" dispatch, status 404
2025-02-25T23:25:54.323+09:00 DEBUG 18944 --- [makefw] [nio-8081-exec-3] o.s.web.servlet.DispatcherServlet        : Completed 404 NOT_FOUND
2025-02-25T23:25:54.324+09:00 DEBUG 18944 --- [makefw] [nio-8081-exec-3] o.s.web.servlet.DispatcherServlet        : "ERROR" dispatch for GET "/error", parameters={}
2025-02-25T23:25:54.325+09:00 DEBUG 18944 --- [makefw] [nio-8081-exec-3] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped to org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController#errorHtml(HttpServletRequest, HttpServletResponse)
2025-02-25T23:25:54.326+09:00 DEBUG 18944 --- [makefw] [nio-8081-exec-3] o.s.w.s.v.ContentNegotiatingViewResolver : Selected 'text/html' given [text/html, text/html;q=0.8]
2025-02-25T23:25:54.326+09:00 DEBUG 18944 --- [makefw] [nio-8081-exec-3] o.s.web.servlet.DispatcherServlet        : Exiting from "ERROR" dispatch, status 404
2025-02-25T23:26:02.003+09:00 DEBUG 18944 --- [makefw] [nio-8081-exec-2] o.s.web.servlet.DispatcherServlet        : GET "/error", parameters={}
2025-02-25T23:26:02.003+09:00 DEBUG 18944 --- [makefw] [nio-8081-exec-2] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped to org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController#errorHtml(HttpServletRequest, HttpServletResponse)
2025-02-25T23:26:02.006+09:00 DEBUG 18944 --- [makefw] [nio-8081-exec-2] o.s.w.s.v.ContentNegotiatingViewResolver : Selected 'text/html' given [text/html, text/html;q=0.8]
2025-02-25T23:26:02.006+09:00 DEBUG 18944 --- [makefw] [nio-8081-exec-2] o.s.web.servlet.DispatcherServlet        : Completed 500 INTERNAL_SERVER_ERROR
