package com.generator.PdfGenerator.beans;

import lombok.*;
import net.sf.dynamicreports.report.builder.datatype.StringType;

@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ColumBean {
    private String columTitle;
    private String fieldName;
    private StringType type;
}
