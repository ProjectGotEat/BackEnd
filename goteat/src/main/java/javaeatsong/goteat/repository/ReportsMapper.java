package javaeatsong.goteat.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import javaeatsong.goteat.model.Reports;

@Mapper
public interface ReportsMapper {
	List<Reports> selectAll() throws Exception;

	Reports selectOne(int id) throws Exception;

	void insert(Reports param) throws Exception;

	void update(Reports param) throws Exception;

	void delete(Reports param) throws Exception;
}
