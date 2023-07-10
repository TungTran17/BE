package com.testproject.swp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testproject.swp.entity.MyService;
import com.testproject.swp.entity.MyServiceImage;
import com.testproject.swp.exception.custom.CustomBadReqEx;
import com.testproject.swp.exception.custom.CustomNotFoundEx;
import com.testproject.swp.model.service.dto.GetMyService;
import com.testproject.swp.model.service.dto.ServiceDTO;
import com.testproject.swp.service.MyserviceService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/Service")
@CrossOrigin(origins = "*")
public class MyServiceController {

    private final MyserviceService myserviceService;

    /*dw
     * Lấy danh sách theo title, status, bi và phân bố theo page ( phân trang )
     * status = -1 lấy hết
     * title = '' lấy hết
     * bi = '' lấy hết
     * 
     * indexPage = 1 và sizePage = 10 thì trả về 10 bản ghi đầu
     * 
     * Lọc theo điều kiện VD:
     * /-1/''/'a' => trả về danh sách service có startsWith 'a' của {bi}
     * /1/''/'a' => trả về danh sách service có {bi} startsWith 'a' VÀ {status}
     * = 1
     * /1/'b'/'a' => trả về danh sách service có {bi} startsWith 'a' của VÀ
     * {status} = 1 VÀ {title} startWith 'b'
     * 
     * Giải thích:
     * sizePage: số lượng service xuất hiện
     * indexPage: index trang hiện thị
     * 
     */
    @GetMapping("/Service/listservices/{status}/{title}/{bi}/{cateid}/{sortfield}/{indexPage}/{sizePage}")
    public ServiceDTO getServices(@PathVariable int status, @PathVariable String title, @PathVariable String bi,@PathVariable int cateid,@PathVariable int sortfield,
            @PathVariable int indexPage, @PathVariable int sizePage) throws CustomNotFoundEx, JsonProcessingException {

        ServiceDTO serviceDTO = new ServiceDTO();
        try{
            serviceDTO.setListServices(myserviceService.getServiceListPage(status,title,bi,cateid,sortfield,indexPage,sizePage));
        }catch (Exception ex){
            serviceDTO.setStatus(404);
        }
        if(serviceDTO.getListServices().size()==0){
            serviceDTO.setStatus(200);
        }else{
            serviceDTO.setStatus(202);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(serviceDTO);
        return serviceDTO;
    }

    /*CASE 2
     *
     * Tạo API tạo mới service đầu vào nhận GetMyService trả về serviceDTO ( status thôi)
     * Note: Có thể sửa GetMyService cho phù hợp
     */
    @PostMapping("/Service/listservices/addservice")
    public ServiceDTO addservice(@RequestBody MyService myServiceMap)
            throws CustomBadReqEx, CustomNotFoundEx {
        ServiceDTO serviceDTO = new ServiceDTO();
        //demodata
//        {
//            "title": "tieu de2",
//                "bi": "moi nhe",
//                "createddate": "2000/02/02",
//                "categoryid":1,
//                "price": "1",
//                "discount": "1",
//                "detail": "chi tiet",
//                "vote": "999",
//                "imagelink": "anh ne",
//                "status":0
//        }
        //
        try{
            if(myserviceService.createMyService(myServiceMap)==true){
                serviceDTO.status=202;
            }else{
                serviceDTO.status=200;
            }
        }catch(Exception ex){
            serviceDTO.status=200;
        }


        return serviceDTO;
    }

    @PostMapping("/Service/listservices/updatervice")
    public ServiceDTO Updateservice(@RequestBody MyService myServiceMap)
            throws CustomBadReqEx, CustomNotFoundEx {
        ServiceDTO serviceDTO = new ServiceDTO();
        System.out.println("Hello World");
        try{
            if(myserviceService.UpdateMyService(myServiceMap)==true){
                serviceDTO.status=202;
            }else{
                serviceDTO.status=200;
            }
        }catch(Exception ex){
            serviceDTO.status=200;
        }


        return serviceDTO;
    }

    @GetMapping("/Service/listservices/deleteservice/{id}")
    public ServiceDTO deleteservice(@PathVariable int id)
            throws CustomBadReqEx, CustomNotFoundEx {
        ServiceDTO serviceDTO = new ServiceDTO();
        try{
            if(myserviceService.deletService(id)==true){
                serviceDTO.status=202;
            }else{
                serviceDTO.status=200;
            }
        }catch(Exception ex){
            System.out.println(ex);
            serviceDTO.status=200;
        }
        return serviceDTO;
    }


    /*CASE 3
     *
     * Tạo API xóa  service theo id trả về serviceDTO ( status thôi)
     * Note: Kiêm tra có hay ko trước khi xóa --> hạn chế lỗi hệ thông
     */
    @PostMapping("/Service/listservice/deletService/{id}")
    public ServiceDTO DeletServiceById(@PathVariable int id) throws CustomNotFoundEx {
        ServiceDTO serviceDTO = new ServiceDTO();
        if(myserviceService.DeleteServiceByID(id)==true){
            serviceDTO.status=202;
        }else{
            serviceDTO.status=200;
        }
        return serviceDTO;
    }

    /*CASE 4
     *
     * Tạo API update  service theo GetMyService trả về serviceDTO ( status thôi)
     * Note: Có thể sửa GetMyService cho phù hợp
     */
    @PostMapping("/Service/listservices/updateservice")
    public ServiceDTO updateservice(@RequestBody MyService myServiceMap)
            throws CustomBadReqEx, CustomNotFoundEx {
        ServiceDTO serviceDTO = new ServiceDTO();
        MyService myService = myserviceService.FindServiceByID(myServiceMap.getId());
        if(myService==null){
            serviceDTO.setStatus(200);
            return  serviceDTO;
        }
        myService=myServiceMap;
        if(myserviceService.updateservice(myServiceMap)==true){
            serviceDTO.status=202;
        }else{
            serviceDTO.status=200;
        }
        return serviceDTO;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////

    // hiện thị tất cả
    @GetMapping("/Service/listservice")
    public List<GetMyService> getServiceList() throws CustomNotFoundEx {
        return myserviceService.getServiceList();
    }
//    @GetMapping("/Service/listservicepage/{status}/{title}/{bi}/{index}/{pageSize}")
//    public List<GetMyService> getServiceListPage(@PathVariable int status,@PathVariable String title,@PathVariable String bi,@PathVariable int index, @PathVariable int pageSize ) throws CustomNotFoundEx {
//        return myserviceService.getServiceListPage(status,title,bi,index,  pageSize);
//    }

    // trả về danh sách theo title
    @GetMapping("/Service/listservice/{title}")
    public List<GetMyService> getServiceBytitle(@PathVariable String title) throws CustomNotFoundEx {
        return myserviceService.getServiceListbyname(title);
    }

    // trả về danh sách theo bi
    @GetMapping("/Service/listservice/bi/{bi}")
    public List<GetMyService> getServiceBybi(@PathVariable String bi) throws CustomNotFoundEx {
        return myserviceService.getServiceListbyBI(bi);
    }

    // trả về danh sách theo status
    @GetMapping("/Service/listservice/status/{status}")
    public List<GetMyService> getServiceBytitle(@PathVariable int status) throws CustomNotFoundEx {
        return myserviceService.getServiceListbystatus(status);
    }

    // sắp xếp theo title
    @GetMapping("/Service/listservice/titleAsc")
    public List<GetMyService> getServiceBytitleAsc() throws CustomNotFoundEx {
        return myserviceService.getServiceListSortbynameASC();
    }

    //
    @GetMapping("/Service/listservice/titledesc")
    public List<GetMyService> getServiceBytitledesc() throws CustomNotFoundEx {
        return myserviceService.getServiceListSortbynameDESC();
    }

    @GetMapping("/Service/listservice/priceasc")
    public List<GetMyService> getServiceBypricasc() throws CustomNotFoundEx {
        return myserviceService.getServiceListSortbypriceASC();
    }

    @GetMapping("/Service/listservice/pricedesc")
    public List<GetMyService> getServiceBypricdesc() throws CustomNotFoundEx {
        return myserviceService.getServiceListSortbypriceDESC();
    }

    @GetMapping("/Service/listservice/statussasc")
    public List<GetMyService> getServiceBystatusasc() throws CustomNotFoundEx {
        return myserviceService.getServiceListSortbystatusASC();
    }

    @GetMapping("/Service/listservice/statusdesc")
    public List<GetMyService> getServiceBystatusdesc() throws CustomNotFoundEx {
        return myserviceService.getServiceListSortbystatusDESC();
    }

    @GetMapping("/Service/listservice/categorysasc")
    public List<GetMyService> getServiceBycategorysasc() throws CustomNotFoundEx {
        return myserviceService.getServiceListSortbycategoryASC();
    }

    @GetMapping("/Service/listservice/categorydesc")
    public List<GetMyService> getServiceBycategorysdesc() throws CustomNotFoundEx {
        return myserviceService.getServiceListSortbycategoryDESC();
    }
}
