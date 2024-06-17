package com.generator.PdfGenerator.util;

import lombok.extern.slf4j.Slf4j;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;
import org.springframework.stereotype.Component;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;


@Component
@Slf4j
public class DRPdfUtil {

    private static final String BASE_DIR = "/home/dk/Documents/R&D/PdfGenerator/temp";
    private static final String TIER_REPORT = "TIER_REPORT";
    private static final String EXTENTION = ".pdf";

    public static void build() {
        try {

            File file = new File(BASE_DIR);
            boolean isFileCreated = file.createNewFile();
            log.error("isFileCreated :: {}", isFileCreated);
            OutputStream outputStream  = new FileOutputStream(file);
            //
            report()
                    .columns(col.column("Item", "item", type.stringType()),
                            col.column("Quantity", "quantity", type.integerType()),
                            col.column("Unit price", "unitprice", type.bigDecimalType()))
                    .title(cmp.text("Getting started"))//shows report title
                    .pageFooter(cmp.pageXofY())//shows number of page at page footer
                    .setDataSource(createDataSource())//set datasource
                    .toPdf(outputStream);//create and show report
        } catch (DRException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
