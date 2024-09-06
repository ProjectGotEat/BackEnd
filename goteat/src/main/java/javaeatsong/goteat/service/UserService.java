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
			responseMap.put("preferred_location", users.getPreferredLocation());
		}

		return responseMap;
	}

	public List<HashMap<String, Object>> getUserPoint(String uid) throws Exception {
		return pointHistoriesMapper.selectListByUid(uid);
	}
	
	public int putUserLocation(int uid, String preferredLocation, double preferredLatitude, double preferredLongitude) throws Exception {
		Users users = new Users();
		users.setId(uid);
		users.setPreferredLocation(preferredLocation);
		users.setPreferredLatitude(preferredLatitude);
		users.setPreferredLongitude(preferredLongitude);
		
		if (usersMapper.update(users) == 1) {
			return 1;
		} else {
			return 0;
		}
	}

}
