package com.testproject.swp.model.service;

import com.testproject.swp.entity.MyService;

public class MyServiceMapper {
    public static GetMyService toGetMedecine(MyService service) {
        return GetMyService.builder()
                //.password(user.getPassword())
                .service_id(service.getId())
                .title(service.getTitle())
                .bi(service.getBi())
                .createddate(service.getCreateddate())
                .categoryid(service.getCategoryid())
                .price(service.getPrice())
                .discount(service.getDiscount())
                .detail (service.getDetail())
                .imagelink (service.getImagelink())
                .status (service.getStatus())
                .categoryname(service.getCategoryname())
                .build();
    }
}
