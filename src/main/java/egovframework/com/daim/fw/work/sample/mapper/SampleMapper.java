package egovframework.com.daim.fw.work.sample.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 2025-02-23T16:53:58.375+09:00 WARN 19708 --- [makefw] [main]   o.m.s.mapper.ClassPathMapperScanner     :No MyBatis mapper was found in '[com.daim.makefw]' package. Please check your configuration.
 * 오류에 대한 해결책 @Mapper 의 선언이 하나도 없어서 그런 것이다.
 * 
 */

@Mapper
public interface SampleMapper {
	
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
