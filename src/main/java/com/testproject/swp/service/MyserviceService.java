package com.testproject.swp.service;

import com.testproject.swp.entity.MyService;
import com.testproject.swp.exception.custom.CustomNotFoundEx;
import com.testproject.swp.model.service.dto.GetMyService;

import java.util.List;

public interface MyserviceService {

    public List<GetMyService> getServiceList() throws CustomNotFoundEx;

    public boolean addnewservice(MyService myService) throws CustomNotFoundEx;

    public boolean updateservice(MyService myService) throws CustomNotFoundEx;

    public MyService FindServiceByID(int id) throws CustomNotFoundEx;

    public boolean DeleteServiceByID(int id) throws CustomNotFoundEx;

    public List<GetMyService> getServiceListPage(int status,String title,String bi,int cateid,int orderid, int index, int pageSize) throws CustomNotFoundEx;
    
    public List<GetMyService> getServiceList(int cateid) throws CustomNotFoundEx ;



    public List<GetMyService> getServiceListbyname(String title) throws CustomNotFoundEx;

    public List<GetMyService> getServiceListbyBI(String bi) throws CustomNotFoundEx;

    public List<GetMyService> getServiceListbystatus(int status) throws CustomNotFoundEx;

    public List<GetMyService> getServiceListSortbynameASC() throws CustomNotFoundEx;

    public List<GetMyService> getServiceListSortbynameDESC() throws CustomNotFoundEx;

    public List<GetMyService> getServiceListSortbypriceASC() throws CustomNotFoundEx;

    public List<GetMyService> getServiceListSortbypriceDESC() throws CustomNotFoundEx;

    public List<GetMyService> getServiceListSortbystatusASC() throws CustomNotFoundEx;

    public List<GetMyService> getServiceListSortbystatusDESC() throws CustomNotFoundEx;

    public List<GetMyService> getServiceListSortbycategoryASC() throws CustomNotFoundEx;

    public List<GetMyService> getServiceListSortbycategoryDESC() throws CustomNotFoundEx;

    public boolean createMyService(MyService myServiceMap);

    public boolean UpdateMyService(MyService myServiceMap);

    public boolean deletService(int id);

}