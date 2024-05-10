package javaeatsong.goteat.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import javaeatsong.goteat.model.Notifications;

@Mapper
public interface NotificationsMapper {
	List<Notifications> selectAll() throws Exception;

	Notifications selectOne(int id) throws Exception;

	void insert(Notifications param) throws Exception;

	void update(Notifications param) throws Exception;

	void delete(Notifications param) throws Exception;
}
