package javaeatsong.goteat.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javaeatsong.goteat.model.Users;
import javaeatsong.goteat.repository.UsersMapper;

@Service
public class AuthService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UsersMapper usersMapper;

	public void postAuthJoin(Users users) throws Exception {
		users.setPassword(passwordEncoder.encode(users.getPassword()));
		usersMapper.insert(users);
	}

	public HashMap<String, Object> postAuthLogin(String email, String rawPassword) throws Exception {
		Users users = usersMapper.selectByEmail(email);

		if (passwordEncoder.matches(rawPassword, users.getPassword())) {
			HashMap<String, Object> response = new HashMap<>();
			response.put("uid", users.getId());
			response.put("preferred_latitude", users.getPreferredLatitude());
			response.put("preferred_longitude", users.getPreferredLongitude());
			return response;
		} else {
			return null;
		}
	}

	public boolean getAuthJoinExist(String email) throws Exception {
		Users users = usersMapper.selectByEmail(email);
		if (users != null) {
			return true;
		} else {
			return false;
		}
	}

}
