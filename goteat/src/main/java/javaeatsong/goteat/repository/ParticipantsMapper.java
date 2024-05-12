package javaeatsong.goteat.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import javaeatsong.goteat.model.Participants;

@Mapper
public interface ParticipantsMapper {
	List<Participants> selectList() throws Exception;

	Participants select(int id) throws Exception;

	void insert(Participants param) throws Exception;

	void update(Participants param) throws Exception;

	void delete(Participants param) throws Exception;
}
