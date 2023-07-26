package com.testproject.swp.model.service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetMyServiceCategory {
    private int categoryid;
    private String categoryname;
    private String icon;

}
