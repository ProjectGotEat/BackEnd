package javaeatsong.goteat.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import javaeatsong.goteat.model.Reviews;

@Mapper
public interface ReviewsMapper {
	List<Reviews> selectAll() throws Exception;

	Reviews selectOne(int id) throws Exception;

	void insert(Reviews param) throws Exception;

	void update(Reviews param) throws Exception;

	void delete(Reviews param) throws Exception;
}
