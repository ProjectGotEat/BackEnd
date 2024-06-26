package javaeatsong.goteat.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javaeatsong.goteat.model.Messages;

@Mapper
public interface MessagesMapper {
	int insert(@Param("pid") int pid, @Param("uid") int uid, @Param("receiverId") int receiverId,
			@Param("content") String content) throws Exception;

	void update(Messages param) throws Exception;

	void delete(Messages param) throws Exception;
}
