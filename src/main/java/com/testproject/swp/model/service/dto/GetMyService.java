package com.testproject.swp.model.service.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class GetMyService {
    private int service_id;
    private String title;
    private String bi;
    private String createddate;
    private int categoryid;
    private String price;
    private String discount;
    private String detail;
    private String rateStar;
    private String vote;
    private String imagelink;
    private int status;
    private String categoryname;


}
