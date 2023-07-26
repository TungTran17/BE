package com.testproject.swp.model.service.mapper;

import com.testproject.swp.entity.MyServiceCategory;
import com.testproject.swp.model.service.dto.GetMyServiceCategory; 

public class MyServiceCategoryMapper {
    public static GetMyServiceCategory toGetMedecine(MyServiceCategory service) {
        return GetMyServiceCategory.builder()
                .categoryname(service.getCategoryname())
                .categoryid(service.getCategoryid())
                .icon(service.getIcon())
                .build();
    }

}
