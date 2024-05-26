package javaeatsong.goteat.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javaeatsong.goteat.model.Users;
import javaeatsong.goteat.service.AuthService;

import java.util.HashMap;
import java.util.Map;

@RestController
@MapperScan(basePackages = "javaeatsong.goteat.repository") // 탐색할 패키지 설정
public class AuthController {

	private final AuthService authService;

	public AuthController(AuthService authService) {
		this.authService = authService;
	}

	@PostMapping("/auth/join")
	public ResponseEntity<String> postAuthJoin(@RequestBody Map<String, ?> requestBody) throws Exception {
		if (requestBody.get("name") == null || requestBody.get("profile_name") == null
				|| requestBody.get("image") == null || requestBody.get("email") == null
				|| requestBody.get("password") == null || requestBody.get("noti_allow") == null) {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("request faild");
		}

		Users user = new Users();
		user.setName(requestBody.get("name").toString());
		user.setProfileName(requestBody.get("profile_name").toString());
		user.setImage(requestBody.get("image").toString());
		user.setEmail(requestBody.get("email").toString());
		user.setPassword(requestBody.get("password").toString());
		user.setRank("씨앗");
		user.setPoint(0);
		user.setNotiAllow((Integer) requestBody.get("noti_allow"));

		authService.postAuthJoin(user);

		return ResponseEntity.status(HttpStatus.CREATED).body("requested successfully");
	}

	@PostMapping("/auth/log-in")
	public ResponseEntity<String> postAuthLogin(@RequestBody Map<String, ?> requestBody) throws Exception {
		if (requestBody.get("email") == null || requestBody.get("password") == null) {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("login faild");
		}

		String email = requestBody.get("email").toString();
		String password = requestBody.get("password").toString();

		if (authService.postAuthLogin(email, password)) {
			return ResponseEntity.status(HttpStatus.OK).body("login successfully");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("login faild");
		}
	}

	@GetMapping("/auth/join/exist")
	public ResponseEntity<Map<String, Object>> getBoard(@RequestParam("email") String email) throws Exception {
		Map<String, Object> response = new HashMap<>();

		if (authService.getAuthJoinExist(email)) {
			response.put("isExist", true);
		} else {
			response.put("isExist", false);
		}

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}