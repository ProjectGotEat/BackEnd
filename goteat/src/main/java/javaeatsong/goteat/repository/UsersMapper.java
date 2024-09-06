package javaeatsong.goteat.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javaeatsong.goteat.model.Users;

@Mapper
public interface UsersMapper {
	Users selectByEmail(@Param("email") String email) throws Exception;

	Users selectByUid(@Param("uid") String uid) throws Exception;

	void insert(Users param) throws Exception;

	int update(Users param) throws Exception;

	void delete(Users param) throws Exception;
}
