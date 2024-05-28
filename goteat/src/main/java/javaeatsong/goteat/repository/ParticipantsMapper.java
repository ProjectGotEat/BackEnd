package javaeatsong.goteat.repository;

import java.util.List;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javaeatsong.goteat.model.Participants;

@Mapper
public interface ParticipantsMapper {
	List<HashMap<String, Object>> selectListByOrganizerId(@Param("uid") int uid) throws Exception;

	List<HashMap<String, Object>> selectListByUserId(@Param("uid") int uid) throws Exception;

	List<HashMap<String, Object>> selectListEndedByOrganizerUserId(@Param("uid") int uid) throws Exception;
	
	List<HashMap<String, Object>> selectListMessages(@Param("id") int pid, @Param("uid") int uid) throws Exception;

	Participants select(int id) throws Exception;
	
	int insert(Participants param) throws Exception;

}
