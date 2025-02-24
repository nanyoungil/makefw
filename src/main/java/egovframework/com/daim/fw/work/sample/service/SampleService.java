package egovframework.com.daim.fw.work.sample.service;

import java.util.List;
import java.util.Map;

public interface SampleService {
	

	/**
	 * 샘플조회(단건)
	 * @param param
	 * @return <strong>map</strong>
	 */
	public Map<String, Object> selectSample(Map<String, Object> param);
	
	/**
	 * 샘플 조회(다건)
	 * @param param
	 * @return <strong>list</strong>
	 */
	public List<Map<String, Object>> selectSampleList(Map<String, Object> param);
	
	/**
	 * 샘플 입력(단건)
	 * @param param
	 * @return <strong>int</strong> 값은 영향을 받은 행(row)의 수.
	 */
	public int insertSample(Map<String, Object> param);
	
	/**
	 * 샘플 수정(다~다건)
	 * @param param
	 * @return <strong>int</strong> 값은 영향을 받은 행(row)의 수.
	 */
	public int updateSample(Map<String, Object> param);

}
