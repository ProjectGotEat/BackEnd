package javaeatsong.goteat.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import javaeatsong.goteat.model.Users;
import javaeatsong.goteat.service.AuthService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

	@Value("${file.upload-dir}")
	private String uploadDir;
	
	private final AuthService authService;

	public AuthController(AuthService authService) {
		this.authService = authService;
	}

	@PostMapping(value = "/auth/join", consumes = "multipart/form-data")
	public ResponseEntity<String> postAuthJoin(@RequestPart("profile_image") MultipartFile profileImage, @RequestPart("user") String userJson) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		Users user = objectMapper.readValue(userJson, Users.class);
		user.setRank("씨앗");
		user.setPoint(0);
		
		// 파일 처리
		if (!profileImage.isEmpty()) {
			try {
				Path path = Paths.get(uploadDir + File.separator + profileImage.getOriginalFilename());
				Files.write(path, profileImage.getBytes());
				String fileUrl = "http://goteat-project-goteat-fbd23032.koyeb.app/uploads/"
						+ profileImage.getOriginalFilename();
				user.setImage(fileUrl);
			} catch (IOException e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload item_image1");
			}
		}

		authService.postAuthJoin(user);

		return ResponseEntity.status(HttpStatus.CREATED).body("requested successfully");
	}

	@PostMapping("/auth/log-in")
	public ResponseEntity<HashMap<String, Object>> postAuthLogin(@RequestBody Map<String, ?> requestBody)
			throws Exception {
		if (requestBody.get("email") == null || requestBody.get("password") == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new HashMap<>());
		}

		String email = requestBody.get("email").toString();
		String password = requestBody.get("password").toString();

		HashMap<String, Object> response = authService.postAuthLogin(email, password);
		if (response != null) {
			Integer uid = (Integer) response.get("uid");
			response.put("uid", uid);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new HashMap<>());
		}
	}

	@GetMapping("/auth/join/exist")
	public ResponseEntity<HashMap<String, Object>> getAuthJoinExist(@RequestParam("email") String email)
			throws Exception {
		HashMap<String, Object> response = new HashMap<>();

		if (authService.getAuthJoinExist(email)) {
			response.put("isExist", true);
		} else {
			response.put("isExist", false);
		}

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}