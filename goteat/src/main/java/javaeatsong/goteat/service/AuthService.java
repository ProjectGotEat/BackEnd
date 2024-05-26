package javaeatsong.goteat.service;

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

	public boolean postAuthLogin(String email, String rawPassword) throws Exception {
		Users users = usersMapper.selectByEmail(email);
		if (passwordEncoder.matches(rawPassword, users.getPassword())) {
			return true;
		} else {
			return false;
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
