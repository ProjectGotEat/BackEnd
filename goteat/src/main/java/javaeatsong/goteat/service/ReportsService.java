package javaeatsong.goteat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaeatsong.goteat.repository.ReportsMapper;
import javaeatsong.goteat.model.Reports;

@Service
public class ReportsService {

	@Autowired
	private ReportsMapper reportsMapper;

	public void postReport(Reports report) throws Exception {
		reportsMapper.insert(report);
	}
}
