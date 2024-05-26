package javaeatsong.goteat.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javaeatsong.goteat.service.UserService;

import java.util.HashMap;

@RestController
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/user")
	public ResponseEntity<HashMap<String, Object>> getUser(@RequestHeader HttpHeaders header) throws Exception {
		String uid = header.getFirst("uid");

		if (uid == null || uid.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new HashMap<>());
		}

		HashMap<String, Object> responseMap = userService.getUser(uid);

		if (responseMap.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseMap);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(responseMap);
		}
	}
}