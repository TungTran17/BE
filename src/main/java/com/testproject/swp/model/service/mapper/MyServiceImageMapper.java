package com.testproject.swp.model.service.mapper;

import com.testproject.swp.entity.MyServiceCategory;
import com.testproject.swp.entity.MyServiceImage;
import com.testproject.swp.model.service.dto.GetMyServiceImage;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class MyServiceImageMapper {
    public static GetMyServiceImage toGetMedecine(MyServiceImage service) {
        return GetMyServiceImage.builder()
                .imageid(service.getImageid())
                .serviceid(service.getServiceid())
                .imagelink(service.getImagelink())
                .build();
    }

}
