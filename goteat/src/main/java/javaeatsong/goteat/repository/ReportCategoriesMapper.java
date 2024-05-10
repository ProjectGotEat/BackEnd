package javaeatsong.goteat.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import javaeatsong.goteat.model.ReportCategories;

@Mapper
public interface ReportCategoriesMapper {
	List<ReportCategories> selectAll() throws Exception;

	ReportCategories selectOne(int id) throws Exception;

	void insert(ReportCategories param) throws Exception;

	void update(ReportCategories param) throws Exception;

	void delete(ReportCategories param) throws Exception;
}
