package com.testproject.swp.service;

import com.testproject.swp.entity.Service;
import com.testproject.swp.repository.ServiceRepository;

import lombok.RequiredArgsConstructor;


import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ServiceService {

    private final ServiceRepository serviceRepository;
    
    public Service createService(Service service) {
        return serviceRepository.save(service);
    }

    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    public Optional<Service> getServiceById(int serviceId) {
        return serviceRepository.findById(serviceId);
    }

    public Service updateService(int serviceId, Service updatedService) {
        Optional<Service> existingService = serviceRepository.findById(serviceId);
        if (existingService.isPresent()) {
            Service service = existingService.get();
            service.setService_title(updatedService.getService_title());
            service.setService_bi(updatedService.getService_bi());
            service.setService_created_date(updatedService.getService_created_date());
            service.setCategory_id(updatedService.getCategory_id());
            service.setService_price(updatedService.getService_price());
            service.setService_discount(updatedService.getService_discount());
            service.setService_detail(updatedService.getService_detail());
            service.setService_rateStar(updatedService.getService_rateStar());
            service.setService_vote(updatedService.getService_vote());
            return serviceRepository.save(service);
        }
        return null;
    }

    public boolean deleteService(int serviceId) {
        Optional<Service> existingService = serviceRepository.findById(serviceId);
        if (existingService.isPresent()) {
            serviceRepository.delete(existingService.get());
            return true;
        }
        return false;
    }
}
