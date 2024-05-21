package javaeatsong.goteat.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import javaeatsong.goteat.model.Participants;

@Mapper
public interface ParticipantsMapper {
	List<HaschMap<String, Object>> selectList(@Param("uid") int uid) throws Exception;

	Participants select(int id) throws Exception;

}
