package javaeatsong.goteat.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import javaeatsong.goteat.model.Users;

@Mapper
public interface UsersMapper {
	List<Users> selectList() throws Exception;

	Users select(String email) throws Exception;

	void insert(Users param) throws Exception;

	void update(Users param) throws Exception;

	void delete(Users param) throws Exception;
}
