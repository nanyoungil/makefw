package egovframework.com.cmm.config;


//import java.util.EnumSet;

import jakarta.servlet.FilterRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;

//import jakarta.servlet.DispatcherType;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

/**
 * EgovWebApplicationInitializer 클래스 <Notice> 사용자 인증 권한처리를 분리(session, spring
 * security) 하기 위해서 web.xml의 기능을 Servlet3.x WebApplicationInitializer 기능으로 처리
 * <Disclaimer> N/A
 *
 * @author 장동한
 * @since 2016.06.23
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일        수정자           수정내용
 *  -------      -------------  ----------------------
 *   2016.06.23  장동한           최초 생성
 *   2018.10.02  신용호           Facebook 관련 HiddenHttpMethodFilter 추가
 *   2018.10.26  신용호           EgovLoginPolicyFilter 추가 (IP접근처리)
 *   2018.12.03  신용호           springMultipartFilter,HTMLTagFilter 추가 (XSS방지처리)
 *      </pre>
 */


public class DaimWebApplicationInitializer implements WebApplicationInitializer {

	private static final Logger LOGGER = LoggerFactory.getLogger(DaimWebApplicationInitializer.class);

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		LOGGER.info("DaimWebApplicationInitializer START-============================================");
		
		
		//-------------------------------------------------------------
		// Egov Web ServletContextListener 설정
		//-------------------------------------------------------------
		servletContext.addListener(new egovframework.com.cmm.context.EgovWebServletContextListener());
		
		
		//-------------------------------------------------------------
		// Spring CharacterEncodingFilter 설정
		//-------------------------------------------------------------
		FilterRegistration.Dynamic characterEncoding = servletContext.addFilter("encodingFilter", new org.springframework.web.filter.CharacterEncodingFilter());
		characterEncoding.setInitParameter("encoding", "UTF-8");
		characterEncoding.setInitParameter("forceEncoding", "true");
		characterEncoding.addMappingForUrlPatterns(null, false, "*.do");
		//characterEncoding.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "*.do");
		
		//-------------------------------------------------------------
		// Spring ServletContextListener 설정
		//-------------------------------------------------------------
		XmlWebApplicationContext rootContext = new XmlWebApplicationContext();
		rootContext.setConfigLocations(new String[] { "classpath*:egovframework/spring/com/**/context-*.xml" });
		//rootContext.setConfigLocations(new String[] { "classpath*:egovframework/spring/com/context-*.xml","classpath*:egovframework/spring/com/*/context-*.xml" });
		rootContext.refresh();
		rootContext.start();
		
		servletContext.addListener(new ContextLoaderListener(rootContext));
		
		LOGGER.info("DaimWebApplicationInitializer END  -============================================");
	}
}
