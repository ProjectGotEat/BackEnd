package javaeatsong.goteat.repository;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javaeatsong.goteat.model.Boards;

@Mapper
public interface BoardsMapper {
	List<HashMap<String, Object>> selectList(@Param("uid") String uid, @Param("keyword") String keyword,
			@Param("categories") List<String> categories) throws Exception;

	HashMap<String, Object> selectDetail(@Param("uid") String uid, @Param("id") int bid) throws Exception;
	
	Boards select(int id) throws Exception;

	void insert(Boards param) throws Exception;

	void update(Boards param) throws Exception;

	void delete(Boards param) throws Exception;
}
