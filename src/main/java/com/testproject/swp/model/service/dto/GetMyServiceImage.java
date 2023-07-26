package com.testproject.swp.model.service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetMyServiceImage {
    private int imageid;
    private String serviceid;
    private String imagelink;
}
