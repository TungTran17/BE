package com.testproject.swp.model.service.dto;

import java.util.List;

import lombok.Data;

@Data
public class ServiceDTO {

    public ServiceDTO() {

    }

    public int contPage;
    public List<GetMyService> listServices;

    public int status;

}
