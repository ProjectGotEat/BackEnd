package javaeatsong.goteat.repository;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javaeatsong.goteat.model.Reviews;

@Mapper
public interface ReviewsMapper {
	List<HashMap<String, Object>> selectList(@Param("uid") String uid) throws Exception;

	Reviews select(int id) throws Exception;

	void insert(Reviews param) throws Exception;

	void update(Reviews param) throws Exception;

	void delete(Reviews param) throws Exception;
}
