package com.example.service;

import com.example.dao.PropertyDAO;
import com.example.model.Property;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PropertyServiceTest {

    @Mock
    private PropertyDAO propertyDAO;

    private PropertyService propertyService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        propertyService = new PropertyService(propertyDAO);
 }

    @Test
    void testCreateProperty() {
        Property property = new Property("House", "123 Main St", 250000);
        when(propertyDAO.createProperty(property)).thenReturn("Property created successfully: House");

        String result = propertyService.createProperty(property);

        assertEquals("Property created successfully: House", result);
        verify(propertyDAO, times(1)).createProperty(property);
    }

    @Test
    void testApproveProperty() {
        int propertyId = 1;
        when(propertyDAO.approveProperty(propertyId)).thenReturn("Property approved successfully: 1");

        String result = propertyService.approveProperty(propertyId);

        assertEquals("Property approved successfully: 1", result);
        verify(propertyDAO, times(1)).approveProperty(propertyId);
    }

    @Test
    void testRejectProperty() {
        int propertyId = 1;
        when(propertyDAO.rejectProperty(propertyId)).thenReturn("Property rejected successfully: 1");

        String result = propertyService.rejectProperty(propertyId);

        assertEquals("Property rejected successfully: 1", result);
        verify(propertyDAO, times(1)).rejectProperty(propertyId);
    }
}