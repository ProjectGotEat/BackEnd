package javaeatsong.goteat.repository;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javaeatsong.goteat.model.Scraps;

@Mapper
public interface ScrapsMapper {
	List<HashMap<String, Object>> selectList(@Param("uid") String uid) throws Exception;

	Scraps select(int id) throws Exception;

	void insert(Scraps param) throws Exception;

	void update(Scraps param) throws Exception;

	void delete(Scraps param) throws Exception;
}
