package javaeatsong.goteat.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javaeatsong.goteat.service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@GetMapping("/user/point")
	public ResponseEntity<List<HashMap<String, Object>>> getUserPoint(@RequestHeader HttpHeaders header)
			throws Exception {
		String uid = header.getFirst("uid");

		if (uid == null || uid.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ArrayList<>());
		}

		List<HashMap<String, Object>> responseMapList = userService.getUserPoint(uid);

		return ResponseEntity.status(HttpStatus.OK).body(responseMapList);
	}
	
	@PutMapping("/user/location")
	public ResponseEntity<String> putUserLocation(@RequestHeader("uid") int uid, @RequestBody Map<String, ?> requestBody)
			throws Exception {
		String preferredLocation = requestBody.get("preferred_location").toString();
		double preferredLatitude = (double) requestBody.get("preferred_latitude");
		double preferredLongitude = (double) requestBody.get("preferred_longitude");

		if (userService.putUserLocation(uid, preferredLocation, preferredLatitude, preferredLongitude) == 1) {
			return ResponseEntity.status(HttpStatus.OK).body("successfully updated");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no matching user");
		}
	}
}