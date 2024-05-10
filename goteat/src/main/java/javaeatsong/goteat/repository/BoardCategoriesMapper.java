package javaeatsong.goteat.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import javaeatsong.goteat.model.BoardCategories;

@Mapper
public interface BoardCategoriesMapper {
	List<BoardCategories> selectAll() throws Exception;

	BoardCategories selectOne(int id) throws Exception;

	void insert(BoardCategories param) throws Exception;

	void update(BoardCategories param) throws Exception;

	void delete(BoardCategories param) throws Exception;
}
