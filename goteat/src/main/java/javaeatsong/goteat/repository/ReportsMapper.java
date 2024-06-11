package javaeatsong.goteat.repository;

import org.apache.ibatis.annotations.Mapper;

import javaeatsong.goteat.model.Reports;

@Mapper
public interface ReportsMapper {
	void insert(Reports param) throws Exception;

	void update(Reports param) throws Exception;

	void delete(Reports param) throws Exception;
}
