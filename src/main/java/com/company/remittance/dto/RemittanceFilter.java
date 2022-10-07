package com.company.remittance.dto;

import com.company.remittance.enums.RemittanceStatus;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class RemittanceFilter {
    private RemittanceStatus status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date from;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date to;

    public String toQueryString() {
        StringBuilder builder = new StringBuilder();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (status != null) {
            builder.append("status=");
            builder.append(status);
            builder.append("&");
        }
        if (from != null) {
            builder.append("dateFrom=");
            builder.append(dateFormat.format(from));
            builder.append("&");
        }
        if (to != null) {
            builder.append("dateTo=");
            builder.append(dateFormat.format(to));
            builder.append("&");
        }
        return builder.toString();
    }
}
