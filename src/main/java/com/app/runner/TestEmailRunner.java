package com.app.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;

import com.app.mailService.AppMailSender;

@Component
public class TestEmailRunner implements CommandLineRunner {

	@Autowired
	private AppMailSender sender;

	public void run(String... args) throws Exception {
		
		FileSystemResource file1 = new FileSystemResource("C:\\Users\\Sreenivas Bandaru\\Downloads\\mailtest.png");
		UrlResource file2 = new UrlResource("https://img.jagranjosh.com/imported/images/E/GK/sachin-records.png");

		boolean sent = sender.sendMail(
				"praveendasar****@gmail.com", //to
				new String[] {
				"bobbara****@gmail.com"	//cc
				},
                new String[] {     //bcc
				 "rameshpodugu@gmail.com"		
				}, 
				"God of cricket", // subject
				"Hello User How Are You", // text
				new Resource[] {  //files
						file1,file2
				});
		if(sent)
			System.out.println("EMAIL IS SENT");
		else
			System.out.println("SENDING FAILED");
	}

}
