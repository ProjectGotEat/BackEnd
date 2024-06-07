package javaeatsong.goteat.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api")
public class FileUploadController {

    @Value("${file.upload-dir}")
    private String uploadDir;

    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is empty");
        }

        try {
            // 저장 경로를 설정합니다.
            Path path = Paths.get(uploadDir + File.separator + file.getOriginalFilename());
            Files.write(path, file.getBytes());
            String fileUrl = "http://goteat-project-goteat-fbd23032.koyeb.app/uploads/" + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.CREATED).body("File uploaded successfully: " + fileUrl);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file");
        }
    }
}
