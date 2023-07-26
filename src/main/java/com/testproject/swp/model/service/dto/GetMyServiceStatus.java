package com.testproject.swp.model.service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetMyServiceStatus {
    private int statusid;
    private int serviceid;
    private int servicestatus;
}
