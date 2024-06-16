package com.generator.PdfGenerator;

import com.generator.PdfGenerator.util.PdfUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class PdfGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PdfGeneratorApplication.class, args);
		// Perform replacements
		Map<String, String> valueMap = new HashMap<>();
		valueMap.put("employeeId", "20240200001");
		valueMap.put("employeeName", "Harish Jay Raj");
		valueMap.put("startDate", "25-03-2024");
		String inputFile = "src/main/resources/test.html"; // Path to your XHTML/XML file
		String outputFile = "src/main/resources/output.pdf"; // Path to the output PDF file
		PdfUtil.convertToPdf(valueMap, inputFile, outputFile);
	}

}
