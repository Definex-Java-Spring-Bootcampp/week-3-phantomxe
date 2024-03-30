package com.patika.akbankservice.repository;

import com.patika.akbankservice.dto.response.ApplicationResponse;
import com.patika.akbankservice.entity.Application;

import java.util.ArrayList;
import java.util.List;

public class ApplicationRepository {

    private List<Application> applicationList = new ArrayList<>();

    public Application save(Application application) {
        applicationList.add(application);
        return application;
    }

    public List<Application> getAll() {
        return applicationList;
    }

    public List<Application> getByUserId(Long userId) { 
        return applicationList.stream().filter(app -> app.getUserId().equals(userId)).toList();
    }
}
