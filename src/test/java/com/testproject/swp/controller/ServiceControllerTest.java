package com.testproject.swp.controller;

import com.testproject.swp.entity.Service;
import com.testproject.swp.service.ServiceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ServiceControllerTest {

    @Mock
    private ServiceService serviceService;

    @InjectMocks
    private ServiceController serviceController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createService_shouldReturnCreatedService() {
        Service inputService = new Service();
        Service createdService = new Service();
        when(serviceService.createService(inputService)).thenReturn(createdService);

        ResponseEntity<Service> response = serviceController.createService(inputService);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdService, response.getBody());
        verify(serviceService, times(1)).createService(inputService);
    }

    @Test
    void getAllServices_shouldReturnAllServices() {
        List<Service> services = Arrays.asList(new Service(), new Service());
        when(serviceService.getAllServices()).thenReturn(services);

        ResponseEntity<List<Service>> response = serviceController.getAllServices();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(services, response.getBody());
        verify(serviceService, times(1)).getAllServices();
    }

    @Test
    void getServiceById_existingServiceId_shouldReturnService() {
        int serviceId = 1;
        Service service = new Service();
        when(serviceService.getServiceById(serviceId)).thenReturn(Optional.of(service));

        ResponseEntity<Service> response = serviceController.getServiceById(serviceId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(service, response.getBody());
        verify(serviceService, times(1)).getServiceById(serviceId);
    }

    @Test
    void updateService_existingServiceId_shouldReturnUpdatedService() {
        int serviceId = 1;
        Service inputService = new Service();
        Service updatedService = new Service();
        when(serviceService.updateService(serviceId, inputService)).thenReturn(updatedService);

        ResponseEntity<Service> response = serviceController.updateService(serviceId, inputService);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedService, response.getBody());
        verify(serviceService, times(1)).updateService(serviceId, inputService);
    }

    

    @Test
    void deleteService_existingServiceId_shouldReturnSuccessMessage() {
        int serviceId = 1;
        when(serviceService.deleteService(serviceId)).thenReturn(true);

        ResponseEntity<String> response = serviceController.deleteService(serviceId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Service deleted successfully", response.getBody());
        verify(serviceService, times(1)).deleteService(serviceId);
    }

   
}
