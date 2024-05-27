package javaeatsong.goteat.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaeatsong.goteat.model.Users;
import javaeatsong.goteat.repository.PointHistoriesMapper;
import javaeatsong.goteat.repository.UsersMapper;

@Service
public class UserService {

	@Autowired
	private UsersMapper usersMapper;

	@Autowired
	private PointHistoriesMapper pointHistoriesMapper;

	public HashMap<String, Object> getUser(String uid) throws Exception {
		Users users = usersMapper.selectByUid(uid);
		HashMap<String, Object> responseMap = new HashMap<>();

		if (users != null) {
			responseMap.put("profile_name", users.getProfileName());
			responseMap.put("image", users.getImage());
			responseMap.put("rank", users.getRank());
			responseMap.put("point", users.getPoint());
			responseMap.put("suspension_date", users.getSuspensionDate());
		}

		return responseMap;
	}

	public List<HashMap<String, Object>> getUserPoint(String uid) throws Exception {
		return pointHistoriesMapper.selectListByUid(uid);
	}

}
