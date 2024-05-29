package javaeatsong.goteat.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javaeatsong.goteat.model.Messages;

@Mapper
public interface MessagesMapper {
	List<Messages> selectList() throws Exception;

	Messages select(int id) throws Exception;

	void insert(@Param("pid") int pid,
				@Param("uid") int uid,
				@Param("receiverId") int receiverId,
				@Param("content") String content) throws Exception;

	void update(Messages param) throws Exception;

	void delete(Messages param) throws Exception;
}
