package mesh.sample.dao;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("awdaw")
public interface sampleMapper {
	
	public Map<String, Object> selectBoardList(Map<String, Object> dto) throws Exception;

}
