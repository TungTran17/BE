// package com.testproject.swp.controller;

// import com.testproject.swp.entity.MyService;
// import com.testproject.swp.exception.custom.CustomBadReqEx;
// import com.testproject.swp.exception.custom.CustomNotFoundEx;
// import com.testproject.swp.model.service.dto.GetMyService;
// import com.testproject.swp.model.service.dto.ServiceDTO;
// import com.testproject.swp.service.MyserviceService;

// import lombok.RequiredArgsConstructor;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @CrossOrigin
// @RequiredArgsConstructor
// @RequestMapping("/api/Service")
// public class MyServiceController {

//     private final MyserviceService myserviceService;

//     @GetMapping("/Service/listservices/{status}/{title}/{bi}/{indexPage}/{sizePage}")
//     public ServiceDTO getServices(@PathVariable int status, @PathVariable String title, @PathVariable String bi,
//             @PathVariable int indexPage, @PathVariable int sizePage) throws CustomNotFoundEx {

//         ServiceDTO serviceDTO = new ServiceDTO();
//         try {
//             serviceDTO.setListServices(myserviceService.getServiceListPage(status, title, bi, indexPage, sizePage));
//             int count = myserviceService.getServiceList().size();
//             int countPage = count / sizePage;
//             if (count % sizePage != 0) {
//                 countPage++;
//             }
//             serviceDTO.contPage = countPage;
//         } catch (Exception ex) {
//             serviceDTO.setStatus(404);
//         }
//         if (serviceDTO.getListServices().size() == 0) {
//             serviceDTO.setStatus(200);
//         } else {
//             serviceDTO.setStatus(202);
//         }
//         return serviceDTO;
//     }

//     @PostMapping("/Service/listservices/addservice")
//     public ServiceDTO addservice(@RequestBody MyService myServiceMap)
//             throws CustomBadReqEx, CustomNotFoundEx {
//         ServiceDTO serviceDTO = new ServiceDTO();

//         if (myserviceService.addnewservice(myServiceMap) == true) {
//             serviceDTO.status = 202;
//         } else {
//             serviceDTO.status = 200;
//         }
//         return serviceDTO;
//     }

//     @PostMapping("/Service/listservice/deletService/{id}")
//     public ServiceDTO DeletServiceById(@PathVariable int id) throws CustomNotFoundEx {
//         ServiceDTO serviceDTO = new ServiceDTO();
//         if (myserviceService.DeleteServiceByID(id) == true) {
//             serviceDTO.status = 202;
//         } else {
//             serviceDTO.status = 200;
//         }
//         return serviceDTO;
//     }

//     @PostMapping("/Service/listservices/updateservice")
//     public ServiceDTO updateservice(@RequestBody MyService myServiceMap)
//             throws CustomBadReqEx, CustomNotFoundEx {
//         ServiceDTO serviceDTO = new ServiceDTO();
//         MyService myService = myserviceService.FindServiceByID(myServiceMap.getId());
//         if (myService == null) {
//             serviceDTO.setStatus(200);
//             return serviceDTO;
//         }
//         myService = myServiceMap;
//         if (myserviceService.updateservice(myServiceMap) == true) {
//             serviceDTO.status = 202;
//         } else {
//             serviceDTO.status = 200;
//         }
//         return serviceDTO;
//     }

//     @GetMapping("/Service/listservice")
//     public List<GetMyService> getServiceList() throws CustomNotFoundEx {
//         return myserviceService.getServiceList();
//     }

//     @GetMapping("/Service/listservice/{title}")
//     public List<GetMyService> getServiceBytitle(@PathVariable String title) throws CustomNotFoundEx {
//         return myserviceService.getServiceListbyname(title);
//     }

//     @GetMapping("/Service/listservice/bi/{bi}")
//     public List<GetMyService> getServiceBybi(@PathVariable String bi) throws CustomNotFoundEx {
//         return myserviceService.getServiceListbyBI(bi);
//     }

//     @GetMapping("/Service/listservice/status/{status}")
//     public List<GetMyService> getServiceBytitle(@PathVariable int status) throws CustomNotFoundEx {
//         return myserviceService.getServiceListbystatus(status);
//     }

//     @GetMapping("/Service/listservice/titleAsc")
//     public List<GetMyService> getServiceBytitleAsc() throws CustomNotFoundEx {
//         return myserviceService.getServiceListSortbynameASC();
//     }

//     @GetMapping("/Service/listservice/titledesc")
//     public List<GetMyService> getServiceBytitledesc() throws CustomNotFoundEx {
//         return myserviceService.getServiceListSortbynameDESC();
//     }

//     @GetMapping("/Service/listservice/priceasc")
//     public List<GetMyService> getServiceBypricasc() throws CustomNotFoundEx {
//         return myserviceService.getServiceListSortbypriceASC();
//     }

//     @GetMapping("/Service/listservice/pricedesc")
//     public List<GetMyService> getServiceBypricdesc() throws CustomNotFoundEx {
//         return myserviceService.getServiceListSortbypriceDESC();
//     }

//     @GetMapping("/Service/listservice/statussasc")
//     public List<GetMyService> getServiceBystatusasc() throws CustomNotFoundEx {
//         return myserviceService.getServiceListSortbystatusASC();
//     }

//     @GetMapping("/Service/listservice/statusdesc")
//     public List<GetMyService> getServiceBystatusdesc() throws CustomNotFoundEx {
//         return myserviceService.getServiceListSortbystatusDESC();
//     }

//     @GetMapping("/Service/listservice/categorysasc")
//     public List<GetMyService> getServiceBycategorysasc() throws CustomNotFoundEx {
//         return myserviceService.getServiceListSortbycategoryASC();
//     }

//     @GetMapping("/Service/listservice/categorydesc")
//     public List<GetMyService> getServiceBycategorysdesc() throws CustomNotFoundEx {
//         return myserviceService.getServiceListSortbycategoryDESC();
//     }
// }
