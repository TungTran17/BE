package com.testproject.swp.model.service.mapper;

import com.testproject.swp.entity.MyServiceStatus;
import com.testproject.swp.model.service.dto.GetMyServiceStatus;


public class MyServiceStatusMapper {
    public static GetMyServiceStatus toGetMedecine(MyServiceStatus service) {
        return GetMyServiceStatus.builder()
                .statusid(service.getStatusid())
                .serviceid(service.getServiceid())
                .servicestatus(service.getServicestatus())
                .build();
    }

}
