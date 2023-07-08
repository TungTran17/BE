package com.testproject.swp.service.impl;

import com.testproject.swp.entity.MyService;
import com.testproject.swp.exception.custom.CustomNotFoundEx;
import com.testproject.swp.model.service.dto.GetMyService;
import com.testproject.swp.model.service.mapper.MyServiceMapper;
import com.testproject.swp.repository.MyServiceRepository; 
import com.testproject.swp.service.MyserviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class myserviceServiceImpl implements MyserviceService {

    private final MyServiceRepository myServiceRepository;


    @Override
    public List<GetMyService> getServiceList() throws CustomNotFoundEx {
        List<GetMyService> myServiceList = new ArrayList<>();
        List<MyService>  myServices = myServiceRepository.findAll();

        for (MyService myService : myServices) {
            myServiceList.add(MyServiceMapper.toGetMedecine(myService));
        }
        return myServiceList;
    }

    @Override
    public boolean addnewservice(MyService myService) throws CustomNotFoundEx {
        MyService savedService = myServiceRepository.save(myService);
        return savedService != null;
    }

    @Override
    public boolean updateservice(MyService myService) throws CustomNotFoundEx {
        MyService savedService = myServiceRepository.save(myService);
        return savedService != null;
    }

    @Override
    public MyService FindServiceByID(int id) throws CustomNotFoundEx {
        return myServiceRepository.findById(id);
    }

    @Override
    public boolean DeleteServiceByID(int id) throws CustomNotFoundEx {
        if (myServiceRepository.existsById(id)) {
            myServiceRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<GetMyService> getServiceListPage(int status,String title,String bi,int index, int pageSize) throws CustomNotFoundEx {

        Pageable pageable = PageRequest.of(index - 1, pageSize);

        Page<MyService> page = myServiceRepository.findAllByStatusAndTitle(status,title,bi,pageable);
        

        List<GetMyService> myServiceList = new ArrayList<>();
        for (MyService myService : page) {
            myServiceList.add(MyServiceMapper.toGetMedecine(myService));
        }
        
        return myServiceList;
    }

    @Override
    public List<GetMyService> getServiceListbyname(String title) throws CustomNotFoundEx {
        List<GetMyService> myServiceList = new ArrayList<>();
        List<MyService>  myServices = myServiceRepository.findByTitleContainingIgnoreCase(title);

        for (MyService myService : myServices) {
            myServiceList.add(MyServiceMapper.toGetMedecine(myService));
        }



        return myServiceList;
    }

    @Override
    public List<GetMyService> getServiceListbyBI(String bi) throws CustomNotFoundEx {
        List<GetMyService> myServiceList = new ArrayList<>();
        List<MyService>  myServices = myServiceRepository.findByBiContainingIgnoreCase(bi);

        for (MyService myService : myServices) {
            myServiceList.add(MyServiceMapper.toGetMedecine(myService));
        }
        return myServiceList;
    }

    @Override
    public List<GetMyService> getServiceListbystatus(int status) throws CustomNotFoundEx {
        List<GetMyService> myServiceList = new ArrayList<>();
        List<MyService>  myServices = myServiceRepository.findByMyServiceStatus_Servicestatus(status);

        for (MyService myService : myServices) {
            myServiceList.add(MyServiceMapper.toGetMedecine(myService));
        }
        return myServiceList;
    }

    @Override
    public List<GetMyService> getServiceListSortbynameASC() throws CustomNotFoundEx {
        List<GetMyService> myServiceList = new ArrayList<>();
        List<MyService>  myServices = myServiceRepository.findAllByOrderByTitleAsc();

        for (MyService myService : myServices) {
            myServiceList.add(MyServiceMapper.toGetMedecine(myService));
        }
        return myServiceList;
    }

    @Override
    public List<GetMyService> getServiceListSortbynameDESC() throws CustomNotFoundEx {
        List<GetMyService> myServiceList = new ArrayList<>();
        List<MyService>  myServices = myServiceRepository.findAllByOrderByTitleDesc();

        for (MyService myService : myServices) {
            myServiceList.add(MyServiceMapper.toGetMedecine(myService));
        }
        return myServiceList;
    }

    @Override
    public List<GetMyService> getServiceListSortbypriceASC() throws CustomNotFoundEx {
        List<GetMyService> myServiceList = new ArrayList<>();
        List<MyService>  myServices = myServiceRepository.findAllByOrderByPriceAsc();

        for (MyService myService : myServices) {
            myServiceList.add(MyServiceMapper.toGetMedecine(myService));
        }
        return myServiceList;
    }

    @Override
    public List<GetMyService> getServiceListSortbypriceDESC() throws CustomNotFoundEx {
        List<GetMyService> myServiceList = new ArrayList<>();
        List<MyService>  myServices = myServiceRepository.findAllByOrderByPriceDesc();

        for (MyService myService : myServices) {
            myServiceList.add(MyServiceMapper.toGetMedecine(myService));
        }
        return myServiceList;
    }

    @Override
    public List<GetMyService> getServiceListSortbystatusASC() throws CustomNotFoundEx {
        List<GetMyService> myServiceList = new ArrayList<>();
        List<MyService>  myServices = myServiceRepository.findAllByOrderByMyServiceStatus_ServicestatusAsc();

        for (MyService myService : myServices) {
            myServiceList.add(MyServiceMapper.toGetMedecine(myService));
        }
        return myServiceList;
    }

    @Override
    public List<GetMyService> getServiceListSortbystatusDESC() throws CustomNotFoundEx {
        List<GetMyService> myServiceList = new ArrayList<>();
        List<MyService>  myServices = myServiceRepository.findAllByOrderByMyServiceStatus_ServicestatusDesc();

        for (MyService myService : myServices) {
            myServiceList.add(MyServiceMapper.toGetMedecine(myService));
        }
        return myServiceList;
    }

    @Override
    public List<GetMyService> getServiceListSortbycategoryASC() throws CustomNotFoundEx {
        List<GetMyService> myServiceList = new ArrayList<>();
        List<MyService>  myServices = myServiceRepository.findAllByOrderByServiceCategory_CategorynameAsc();

        for (MyService myService : myServices) {
            myServiceList.add(MyServiceMapper.toGetMedecine(myService));
        }
        return myServiceList;
    }

    @Override
    public List<GetMyService> getServiceListSortbycategoryDESC() throws CustomNotFoundEx {
        List<GetMyService> myServiceList = new ArrayList<>();
        List<MyService>  myServices = myServiceRepository.findAllByOrderByServiceCategory_CategorynameDesc();

        for (MyService myService : myServices) {
            myServiceList.add(MyServiceMapper.toGetMedecine(myService));
        }
        return myServiceList;
    }


}
