package com.testproject.swp.model.service;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
public class ServiceDTO {

    public ServiceDTO() {
        
    }

    public int contPage; 
    public List<GetMyService> listServices; 

   
    public int status;

}
