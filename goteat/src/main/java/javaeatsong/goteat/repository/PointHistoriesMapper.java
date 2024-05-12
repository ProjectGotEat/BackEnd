package javaeatsong.goteat.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import javaeatsong.goteat.model.PointHistories;

@Mapper
public interface PointHistoriesMapper {
	List<PointHistories> selectList() throws Exception;

	PointHistories select(int id) throws Exception;

	void insert(PointHistories param) throws Exception;

	void update(PointHistories param) throws Exception;

	void delete(PointHistories param) throws Exception;
}
