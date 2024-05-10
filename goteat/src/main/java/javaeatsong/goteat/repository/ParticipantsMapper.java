package javaeatsong.goteat.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import javaeatsong.goteat.model.Participants;

@Mapper
public interface ParticipantsMapper {
	List<Participants> selectAll() throws Exception;

	Participants selectOne(int id) throws Exception;

	void insert(Participants param) throws Exception;

	void update(Participants param) throws Exception;

	void delete(Participants param) throws Exception;
}
