package com.testproject.swp.model.service.mapper;

import com.testproject.swp.entity.MyService;
import com.testproject.swp.model.service.dto.GetMyService;

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
        .rateStar(service.getRateStar())
        .build();
    }
}
