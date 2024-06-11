package javaeatsong.goteat.repository;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javaeatsong.goteat.model.PointHistories;

@Mapper
public interface PointHistoriesMapper {
	List<HashMap<String, Object>> selectListByUid(@Param("uid") String uid) throws Exception;

	void update(PointHistories param) throws Exception;

	void delete(PointHistories param) throws Exception;
}
