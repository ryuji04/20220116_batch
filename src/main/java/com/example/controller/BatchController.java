package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.service.BatchService;

@SpringBootApplication
@Controller
@RequestMapping("/batchController")
@EnableScheduling

public class BatchController {
	@Autowired
	public BatchService batchService;
	
	
@RequestMapping("")
public String index() {
	return "batch_upload.html";
}


@RequestMapping("/upload")
	public String upload(MultipartFile uploadFile) {

	batchService.upload(uploadFile);
	System.out.println("実行しました");
	return "batch_upload.html";
}

@RequestMapping("/upload2")
//@Scheduled(cron="0 * * * * *",zone="Asia/Tokyo")
	public String upload2() {
	
	
	batchService.upload2();
	System.out.println("実行しました");
	return "batch_upload.html";
}


}
