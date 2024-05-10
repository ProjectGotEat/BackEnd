package javaeatsong.goteat.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import javaeatsong.goteat.model.Scraps;

@Mapper
public interface ScrapsMapper {
	List<Scraps> selectAll() throws Exception;

	Scraps selectOne(int id) throws Exception;

	void insert(Scraps param) throws Exception;

	void update(Scraps param) throws Exception;

	void delete(Scraps param) throws Exception;
}
