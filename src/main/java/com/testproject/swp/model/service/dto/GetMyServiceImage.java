package com.testproject.swp.model.service.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
public class GetMyServiceImage {
    private int imageid;
    private String serviceid;
    private String imagelink;
}
