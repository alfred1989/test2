package com.example.demo.services;

import com.example.demo.models.Business;

import com.example.demo.repositories.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusinessService {

    @Autowired
    private BusinessRepository businessRepository;

    public List<Business> getAll() {
        return (List<Business>) businessRepository.findAll();
    }

    public Optional<Business> getOne(Integer Id) {
        return businessRepository.findById(Id);
    }

    public void addNew(Business business) {
        businessRepository.save(business);
    }

    public void registrationBusiness(Business business) { businessRepository.save(business); }

    public void update(Business business) {
        businessRepository.save(business);
    }

    public void delete(Integer Id) {
        businessRepository.deleteById(Id);
    }
}
