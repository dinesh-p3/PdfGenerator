package com.generator.PdfGenerator.util;

import lombok.extern.slf4j.Slf4j;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.constant.HorizontalImageAlignment;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;
import org.springframework.stereotype.Component;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;


@Component
@Slf4j
public class DRPdfUtil {

    private static final Path BASE_DIR = Path.of("/home/dk/Documents/R&D/PdfGenerator/temp/");
    private static final String TIER_REPORT = "TIER_REPORT";
    private static final String PDF_EXTENSION = ".pdf";
    private static final String IMAGE_PATH = "src/main/resources/logo_1.png";

    public static void build() {
        try {
            if (!Files.exists(BASE_DIR)) {
                Files.createDirectories(BASE_DIR);
            }
            Path filePath = Path.of(BASE_DIR + "/" + TIER_REPORT +"_"+ new Date().getTime() + PDF_EXTENSION);
            Files.createFile(filePath);
            File file = filePath.toFile();
            File imageFile = new File(IMAGE_PATH);
            FileInputStream imageInputStream = new FileInputStream(imageFile);
            log.error("filePath :: {}", filePath);
            OutputStream outputStream = new FileOutputStream(file);

            //1
            JasperReportBuilder report = DynamicReports.report();
            addImage(report, imageInputStream);
//          report.setBackgroundBackgroundComponent(cmp.image(imageInputStream));
            report.setPageFormat(PageType.A4, PageOrientation.PORTRAIT);
            report.addPageHeader(cmp.text("Tier Plan Summary Report"));
            report.toPdf(outputStream);

            //2
          /* report()
                    .columns(col.column("Item", "item", type.stringType()),
                            col.column("Quantity", "quantity", type.integerType()),
                            col.column("Unit price", "unitprice", type.bigDecimalType()))
                    .title(cmp.text("Getting started"))
                    .pageFooter(cmp.pageXofY())
                    .setDataSource(createDataSource())
                    .toPdf(outputStream); */
        } catch (DRException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void addImage(JasperReportBuilder report, FileInputStream imageInputStream) {
        report.addTitle(cmp.image(imageInputStream).setHorizontalImageAlignment(HorizontalImageAlignment.RIGHT));
    }

    private static JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("item", "quantity", "unitprice");
        dataSource.add("Notebook", 1, new BigDecimal(500));
        dataSource.add("DVD", 5, new BigDecimal(30));
        dataSource.add("DVD", 1, new BigDecimal(28));
        dataSource.add("DVD", 5, new BigDecimal(32));
        dataSource.add("Book", 3, new BigDecimal(11));
        dataSource.add("Book", 1, new BigDecimal(15));
        dataSource.add("Book", 5, new BigDecimal(10));
        dataSource.add("Book", 8, new BigDecimal(9));
        return dataSource;
    }

}
