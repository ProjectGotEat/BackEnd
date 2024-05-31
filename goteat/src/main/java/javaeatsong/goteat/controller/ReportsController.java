package javaeatsong.goteat.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import javaeatsong.goteat.service.ReportsService;
import javaeatsong.goteat.model.Reports;

import java.util.HashMap;
import java.util.List;

@RestController
@MapperScan(basePackages = "javaeatsong.goteat.repository") // 탐색할 패키지 설정
public class ReportsController {

	private final ReportsService reportsService;

	public ReportsController(ReportsService reportsService) {
		this.reportsService = reportsService;
	}
	
	@PostMapping("/participant/{id}/report")
	   public ResponseEntity<String> postReport(@RequestBody Reports report, @RequestHeader("uid") int uid, @PathVariable("id") int pid)
			   throws Exception {
		report.setReporterId(uid); //신고하는 사람 ID 세팅
		report.setParticipantId(pid);
		reportsService.postReport(report);
	    return ResponseEntity.status(HttpStatus.CREATED).body("Report created successfully");
    }
}