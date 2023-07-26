package com.testproject.swp.service.impl;

import com.testproject.swp.entity.*;
import com.testproject.swp.exception.custom.CustomNotFoundEx;
import com.testproject.swp.model.service.dto.GetMyService;
import com.testproject.swp.model.service.mapper.MyServiceMapper;
import com.testproject.swp.repository.*;
import com.testproject.swp.service.MyserviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class myserviceServiceImpl implements MyserviceService {

    private final MyServiceRepository myServiceRepository;
    private final MyServiceImageRepository myServiceImageRepository;
    private final MyServiceStatusRepository myServiceStatusRepository;

    @Override
    public List<GetMyService> getServiceList() throws CustomNotFoundEx {
        List<GetMyService> myServiceList = new ArrayList<>();
        List<MyService> myServices = myServiceRepository.findAll();

        for (MyService myService : myServices) {
            myServiceList.add(MyServiceMapper.toGetMedecine(myService));
        }
        return myServiceList;
    }

    @Override
    public boolean addnewservice(MyService myService) throws CustomNotFoundEx {
        return false;
    }

    @Override
    public boolean updateservice(MyService myService) throws CustomNotFoundEx {
        MyService savedService = myServiceRepository.save(myService);
        return savedService != null;
    }

    @Override
    public MyService FindServiceByID(int id) throws CustomNotFoundEx {
        MyService myService = myServiceRepository.findById(id);
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
    public List<GetMyService> getServiceListPage(int status, String title, String bi, int cateid, int orderid,
            int index, int pageSize) throws CustomNotFoundEx {
        Pageable pageable;
        if (orderid == -1) {
            pageable = PageRequest.of(index - 1, pageSize, Sort.by("id").ascending());
        } else if (orderid == 0) {
            pageable = PageRequest.of(index - 1, pageSize, Sort.by("title").ascending());
        } else if (orderid == 1) {
            pageable = PageRequest.of(index - 1, pageSize, Sort.by("price").ascending());
        } else if (orderid == 2) {
            pageable = PageRequest.of(index - 1, pageSize, Sort.by("price").descending());
        } else if (orderid == 3) {
            pageable = PageRequest.of(index - 1, pageSize, Sort.by("serviceCategory.categoryname").ascending());
        } else if (orderid == 4) {
            pageable = PageRequest.of(index - 1, pageSize, Sort.by("serviceCategory.categoryname").descending());
        } else {
            pageable = PageRequest.of(index - 1, pageSize);
        }
        Page<MyService> page = myServiceRepository.findAllByStatusAndTitle(status, title, bi, cateid, pageable);

        List<GetMyService> myServiceList = new ArrayList<>();
        for (MyService myService : page) {
            myServiceList.add(MyServiceMapper.toGetMedecine(myService));
        }
        return myServiceList;
    }

    @Override
    public List<GetMyService> getServiceList(int cateid) throws CustomNotFoundEx {
        Pageable pageable;
        List<MyService> page = new ArrayList<>();
        page = myServiceRepository.findAllByCategory(cateid);
        List<GetMyService> myServiceList = new ArrayList<>();
        for (MyService myService : page) {
            myServiceList.add(MyServiceMapper.toGetMedecine(myService));
        }
        return myServiceList;
    }

    @Override
    public List<GetMyService> getServiceListbyname(String title) throws CustomNotFoundEx {
        List<GetMyService> myServiceList = new ArrayList<>();
        List<MyService> myServices = myServiceRepository.findByTitleContainingIgnoreCase(title);

        for (MyService myService : myServices) {
            myServiceList.add(MyServiceMapper.toGetMedecine(myService));
        }

        return myServiceList;
    }

    @Override
    public List<GetMyService> getServiceListbyBI(String bi) throws CustomNotFoundEx {
        List<GetMyService> myServiceList = new ArrayList<>();
        List<MyService> myServices = myServiceRepository.findByBiContainingIgnoreCase(bi);

        for (MyService myService : myServices) {
            myServiceList.add(MyServiceMapper.toGetMedecine(myService));
        }
        return myServiceList;
    }

    @Override
    public List<GetMyService> getServiceListbystatus(int status) throws CustomNotFoundEx {
        List<GetMyService> myServiceList = new ArrayList<>();
        List<MyService> myServices = myServiceRepository.findByMyServiceStatus_Servicestatus(status);

        for (MyService myService : myServices) {
            myServiceList.add(MyServiceMapper.toGetMedecine(myService));
        }
        return myServiceList;
    }

    @Override
    public List<GetMyService> getServiceListSortbynameASC() throws CustomNotFoundEx {
        List<GetMyService> myServiceList = new ArrayList<>();
        List<MyService> myServices = myServiceRepository.findAllByOrderByTitleAsc();

        for (MyService myService : myServices) {
            myServiceList.add(MyServiceMapper.toGetMedecine(myService));
        }
        return myServiceList;
    }

    @Override
    public List<GetMyService> getServiceListSortbynameDESC() throws CustomNotFoundEx {
        List<GetMyService> myServiceList = new ArrayList<>();
        List<MyService> myServices = myServiceRepository.findAllByOrderByTitleDesc();

        for (MyService myService : myServices) {
            myServiceList.add(MyServiceMapper.toGetMedecine(myService));
        }
        return myServiceList;
    }

    @Override
    public List<GetMyService> getServiceListSortbypriceASC() throws CustomNotFoundEx {
        List<GetMyService> myServiceList = new ArrayList<>();
        List<MyService> myServices = myServiceRepository.findAllByOrderByPriceAsc();

        for (MyService myService : myServices) {
            myServiceList.add(MyServiceMapper.toGetMedecine(myService));
        }
        return myServiceList;
    }

    @Override
    public List<GetMyService> getServiceListSortbypriceDESC() throws CustomNotFoundEx {
        List<GetMyService> myServiceList = new ArrayList<>();
        List<MyService> myServices = myServiceRepository.findAllByOrderByPriceDesc();

        for (MyService myService : myServices) {
            myServiceList.add(MyServiceMapper.toGetMedecine(myService));
        }
        return myServiceList;
    }

    @Override
    public List<GetMyService> getServiceListSortbystatusASC() throws CustomNotFoundEx {
        List<GetMyService> myServiceList = new ArrayList<>();
        List<MyService> myServices = myServiceRepository.findAllByOrderByMyServiceStatus_ServicestatusAsc();

        for (MyService myService : myServices) {
            myServiceList.add(MyServiceMapper.toGetMedecine(myService));
        }
        return myServiceList;
    }

    @Override
    public List<GetMyService> getServiceListSortbystatusDESC() throws CustomNotFoundEx {
        List<GetMyService> myServiceList = new ArrayList<>();
        List<MyService> myServices = myServiceRepository.findAllByOrderByMyServiceStatus_ServicestatusDesc();

        for (MyService myService : myServices) {
            myServiceList.add(MyServiceMapper.toGetMedecine(myService));
        }
        return myServiceList;
    }

    @Override
    public List<GetMyService> getServiceListSortbycategoryASC() throws CustomNotFoundEx {
        List<GetMyService> myServiceList = new ArrayList<>();
        List<MyService> myServices = myServiceRepository.findAllByOrderByServiceCategory_CategorynameAsc();

        for (MyService myService : myServices) {
            myServiceList.add(MyServiceMapper.toGetMedecine(myService));
        }
        return myServiceList;
    }

    @Override
    public List<GetMyService> getServiceListSortbycategoryDESC() throws CustomNotFoundEx {
        List<GetMyService> myServiceList = new ArrayList<>();
        List<MyService> myServices = myServiceRepository.findAllByOrderByServiceCategory_CategorynameDesc();

        for (MyService myService : myServices) {
            myServiceList.add(MyServiceMapper.toGetMedecine(myService));
        }
        return myServiceList;
    }

    @Override
    public boolean createMyService(MyService myServiceMap) {
        MyService myService = MyService.builder()
                .title(myServiceMap.getTitle())
                .bi(myServiceMap.getBi())
                .createddate(myServiceMap.getCreateddate())
                .categoryid(myServiceMap.getCategoryid())
                .price(myServiceMap.getPrice())
                .discount(myServiceMap.getDiscount())
                .detail(myServiceMap.getDetail())
                .vote(myServiceMap.getVote())
                .build();

        System.out.println(myService.getBi() + "a");
        MyService savedService = myServiceRepository.save(myService);
        MyServiceImage myServiceImage = MyServiceImage.builder()
                .imageid(savedService.getId())
                .serviceid(String.valueOf(savedService.getId()))
                .imagelink(myServiceMap.getImagelink())
                .build();
        MyServiceImage savedImage = myServiceImageRepository.save(myServiceImage);
        // savedService.setMyServiceImage(savedImage);
        MyServiceStatus myServiceStatus = MyServiceStatus.builder()
                .statusid(savedService.getId())
                .serviceid(savedService.getId())
                .servicestatus(myServiceMap.getStatus())
                .build();
        MyServiceStatus savedStatus = myServiceStatusRepository.save(myServiceStatus);
        savedStatus.setStatusid(savedService.getId());
        myServiceStatusRepository.save(myServiceStatus);
        savedService.setMyServiceStatus(savedStatus);

        MyService finalSavedService = myServiceRepository.save(savedService);

        if (finalSavedService == null) {
            return false;
        } else {
            return true;
        }

    }

    @Override
    public boolean UpdateMyService(MyService myServiceMap) {
        MyService myService = MyService.builder()
                .id(myServiceMap.getId())
                .title(myServiceMap.getTitle())
                .bi(myServiceMap.getBi())
                .createddate(myServiceMap.getCreateddate())
                .categoryid(myServiceMap.getCategoryid())
                .price(myServiceMap.getPrice())
                .discount(myServiceMap.getDiscount())
                .detail(myServiceMap.getDetail())
                .vote(myServiceMap.getVote())
                .build();
        MyService savedService = myServiceRepository.save(myService);
        System.out.println(savedService);
        MyServiceImage myServiceImage = MyServiceImage.builder()
                .imageid(savedService.getId())
                .serviceid(String.valueOf(savedService.getId()))
                .imagelink(myServiceMap.getImagelink())
                .build();
        System.out.println(myServiceImage);
        MyServiceImage savedImage = myServiceImageRepository.save(myServiceImage);
        savedImage.setImageid(savedService.getId());
        // savedService.setMyServiceImage(savedImage);
        MyServiceStatus myServiceStatus = MyServiceStatus.builder()
                .statusid(savedService.getId())
                .serviceid(savedService.getId())
                .servicestatus(myServiceMap.getStatus())
                .build();
        MyServiceStatus savedStatus = myServiceStatusRepository.save(myServiceStatus);
        savedStatus.setStatusid(savedService.getId());
        savedStatus.setStatusid(savedService.getId());
        myServiceStatusRepository.save(myServiceStatus);
        savedService.setMyServiceStatus(savedStatus);

        MyService finalSavedService = myServiceRepository.save(savedService);

        if (finalSavedService == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    @Transactional
    public boolean deletService(int id) {

        List<MyServiceStatus> myServiceStatus = myServiceStatusRepository.findByServiceid(id);
        for (MyServiceStatus myServiceStatus2 : myServiceStatus) {
            myServiceStatus2.setServicestatus(0);
            myServiceStatusRepository.save(myServiceStatus2);
        }
        // MyService service = myServiceRepository.findById(id);
        // if (service != null) {
        // service.setStatus(0);
        // myServiceRepository.save(service);
        // return true;
        // }

        // myServiceImageRepository.deleteByServiceid(String.valueOf(id) );
        // myServiceStatusRepository.deleteByServiceid(id);
        // if (myServiceRepository.existsById(id)) {
        // myServiceRepository.deleteById(id);
        // return true;
        // }
        return false;
        // if (!myServiceRepository.existsById(id)) {
        // return true;
        // } else {
        // return false;
        // }
    }

}
