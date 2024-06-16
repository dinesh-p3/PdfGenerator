package com.generator.PdfGenerator;

import com.generator.PdfGenerator.util.PdfUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PdfGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PdfGeneratorApplication.class, args);
		PdfUtil.testPdf();
	}

}
