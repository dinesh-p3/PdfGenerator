/*
package com.generator.PdfGenerator.util;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;

@Component
public class FlyingSaucerPdfUtil {

    private static String htmlToXhtml(String html) {
        // Convert HTML to XHTML
        Document document = Jsoup.parse(html);
        document.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
        return document.html();
    }

    public static void convertToPdf(Map<String, String> valueMap, String inputFile, String outputFile) {
        try {
            // Create an ITextRenderer instance
            ITextRenderer renderer = new ITextRenderer();

            // Read HTML content from file
            String content = FileUtils.readFileToString(Paths.get(inputFile).toFile(), StandardCharsets.UTF_8);

            Set<Map.Entry<String, String>> entrySet = valueMap.entrySet();
            for (Map.Entry<String, String> es : entrySet) {
                content = content.replace("@{" + es.getKey() + "}", es.getValue());
            }

            // Convert HTML to XHTML
            String htmlToXhtml = FlyingSaucerPdfUtil.htmlToXhtml(content);
            renderer.setDocumentFromString(htmlToXhtml);

            // Render the document to PDF
            renderer.layout();
            FileOutputStream fos = new FileOutputStream(outputFile);
            renderer.createPDF(fos);
            fos.close();

            System.out.println("PDF generated successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/
