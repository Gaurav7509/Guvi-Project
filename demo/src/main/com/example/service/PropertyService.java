package com.example.service;

import com.example.dao.PropertyDAO;
import com.example.model.Property;

public class PropertyService {
    private PropertyDAO propertyDAO;

    public PropertyService(PropertyDAO propertyDAO) {
        this.propertyDAO = propertyDAO;
    }

    public String createProperty(Property property) {
        return propertyDAO.createProperty(property);
    }

    public String approveProperty(int propertyId) {
        return propertyDAO.approveProperty(propertyId);
    }

    public String rejectProperty(int propertyId) {
        return propertyDAO.rejectProperty(propertyId);
    }
}