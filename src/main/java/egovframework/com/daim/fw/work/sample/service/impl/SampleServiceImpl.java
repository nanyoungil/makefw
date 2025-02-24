package egovframework.com.daim.fw.work.sample.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.com.daim.fw.work.sample.mapper.SampleMapper;
import egovframework.com.daim.fw.work.sample.service.SampleService;

@Service(value = "SampleService")
public class SampleServiceImpl implements SampleService {

	@Autowired
	SampleMapper sampleMapper;

	@Override
	public Map<String, Object> selectSample(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> selectSampleList(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertSample(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateSample(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
