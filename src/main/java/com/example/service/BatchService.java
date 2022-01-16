package com.example.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.entity.SpendingEntity;
import com.example.repository.BatchRepository;

@Service
@Transactional
public class BatchService {
	@Autowired
	private BatchRepository batchRepository;
	
	
	public void upload(MultipartFile uploadFile) {
		// ファイル読み込みで利用
		InputStream stream;
		Reader reader;
		BufferedReader br;

		try {

			stream = uploadFile.getInputStream();
			reader = new InputStreamReader(stream, "Shift-JIS");
			br = new BufferedReader(reader);

			String line;

			SpendingEntity spendingEntity = new SpendingEntity();
			while ((line = br.readLine()) != null) {
				String[] arr = line.split(",");
				System.out.println("arr:" + arr[0]);
				System.out.println("arr:" + arr[1]);

				spendingEntity.setSpending(arr[0]);
				spendingEntity.setMemo(arr[1]);

				batchRepository.insertCsv(spendingEntity);

//				int i=0;
//				for(String colum:arr) {
//					System.out.println("sm:"+arr[i]);
//					i++;
//				}
//				String[]arr=line.split(",");
//				spendingEntity.setSpending(arr[0]);
//				spendingEntity.setMemo(arr[1]);
//				System.out.println("memo:"+spendingEntity.getMemo());
			}

		} catch (IOException e) {
			System.out.println("失敗");
			e.printStackTrace();
		}

	}
	
	 public void upload2(){
		 FileInputStream fi;
		try {
			fi = new FileInputStream("C:\\Users\\龍二\\Desktop\\batchUpload\\batch.csv");
			InputStreamReader is = new InputStreamReader(fi);
			BufferedReader br = new BufferedReader(is);
			
			String line;
			
			SpendingEntity spendingEntity=new SpendingEntity();
			while((line=br.readLine())!=null) {
				String[]arr=line.split(",");
				spendingEntity.setSpending(arr[0]);
				spendingEntity.setMemo(arr[1]);
				batchRepository.insertCsv(spendingEntity);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	 }
}











