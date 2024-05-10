package javaeatsong.goteat.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import javaeatsong.goteat.model.Boards;

@Mapper
public interface BoardsMapper {
	List<Boards> selectAll() throws Exception;

	Boards selectOne(int id) throws Exception;

	void insert(Boards param) throws Exception;

	void update(Boards param) throws Exception;

	void delete(Boards param) throws Exception;
}
