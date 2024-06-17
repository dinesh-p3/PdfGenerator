package com.generator.PdfGenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PdfGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PdfGeneratorApplication.class, args);
		//Flying saucer
/*		Map<String, String> valueMap = new HashMap<>();
		valueMap.put("employeeId", "20240200001");
		valueMap.put("employeeName", "Harish Jay Raj");
		valueMap.put("startDate", "25-03-2024");
		String inputFile = "src/main/resources/test.html"; // Path to your XHTML/XML file
		String outputFile = "src/main/resources/output.pdf"; // Path to the output PDF file
		FlyingSaucerPdfUtil.convertToPdf(valueMap, inputFile, outputFile);*/
	}

}
