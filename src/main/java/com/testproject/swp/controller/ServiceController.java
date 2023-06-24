package com.testproject.swp.controller;

import com.testproject.swp.entity.Service;
import com.testproject.swp.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/services")
public class ServiceController {

    private final ServiceService serviceService;

    @Autowired
    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @PostMapping
    public ResponseEntity<Service> createService(@RequestBody Service service) {
        Service createdService = serviceService.createService(service);
        return new ResponseEntity<>(createdService, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Service>> getAllServices() {
        List<Service> services = serviceService.getAllServices();
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Service> getServiceById(@PathVariable("id") int serviceId) {
        Optional<Service> service = serviceService.getServiceById(serviceId);
        if (service.isPresent()) {
            return new ResponseEntity<>(service.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Service> updateService(@PathVariable("id") int serviceId, @RequestBody Service updatedService) {
        Service service = serviceService.updateService(serviceId, updatedService);
        if (service != null) {
            return new ResponseEntity<>(service, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteService(@PathVariable("id") int serviceId) {
        boolean deleted = serviceService.deleteService(serviceId);
        if (deleted) {
            return new ResponseEntity<>("Service deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Service not found", HttpStatus.NOT_FOUND);
    }
}
