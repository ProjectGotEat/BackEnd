package javaeatsong.goteat.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import javaeatsong.goteat.model.Messages;

@Mapper
public interface MessagesMapper {
	List<Messages> selectAll() throws Exception;

	Messages selectOne(int id) throws Exception;

	void insert(Messages param) throws Exception;

	void update(Messages param) throws Exception;

	void delete(Messages param) throws Exception;
}
