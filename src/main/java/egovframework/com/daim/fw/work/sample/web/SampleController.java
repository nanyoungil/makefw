package egovframework.com.daim.fw.work.sample.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import egovframework.com.daim.fw.work.sample.service.SampleService;
import egovframework.com.utl.fcc.service.EgovStringUtil;

@Controller(value = "/sample")
public class SampleController {

	@Autowired(required = true)
	private SampleService sampleService;

	/**
	 * 
	 * @param str
	 * @return <strong>ModelAndView</strong>
	 */
	@GetMapping(value = "/selectSample.do", headers = "content-type=text/*")
	public ModelAndView selectSample(@RequestParam String str) {

		ModelAndView mav = new ModelAndView();

		Map<String, Object> param = new HashMap<String, Object>();

		param.put("WORD_ID", EgovStringUtil.isEmpty(str, "123"));

		mav.addObject("list", sampleService.selectSample(param));
		
		mav.setViewName("page/sample/Sample");

		return mav;

	}

}
