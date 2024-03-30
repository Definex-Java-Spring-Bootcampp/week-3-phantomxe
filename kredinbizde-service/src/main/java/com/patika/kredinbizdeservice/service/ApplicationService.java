package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.client.AkbankServiceClient;
import com.patika.kredinbizdeservice.client.dto.request.AkbankApplicationRequest;
import com.patika.kredinbizdeservice.client.dto.response.ApplicationListResponse;
import com.patika.kredinbizdeservice.client.dto.response.ApplicationResponse;
import com.patika.kredinbizdeservice.converter.ApplicationConverter;
import com.patika.kredinbizdeservice.dto.request.ApplicationRequest;
import com.patika.kredinbizdeservice.model.Application;
import com.patika.kredinbizdeservice.model.Loan;
import com.patika.kredinbizdeservice.model.User;
import com.patika.kredinbizdeservice.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApplicationService {

    private final ApplicationRepository applicationRepository = new ApplicationRepository();
    private final ApplicationConverter applicationConverter;
    private final UserService userService;
    private final AkbankServiceClient akbankServiceClient;

    public Application createApplication(ApplicationRequest request) {

        User user = userService.getByEmail(request.getEmail());
        log.info("user bulundu");

        Application application = applicationConverter.toApplication(request, user); 

        ApplicationResponse akbankApplicationResponse = akbankServiceClient.createApplication(prepareAkbankApplicationRequest(user, request));
        
        application.setLoan(akbankApplicationResponse.getLoan());

        return application;
    }

    private AkbankApplicationRequest prepareAkbankApplicationRequest(User user, ApplicationRequest request) {
        AkbankApplicationRequest applicationRequest = new AkbankApplicationRequest();

        applicationRequest.setUserId(1L);
        applicationRequest.setAmount(request.getAmount());
        applicationRequest.setInstallment(request.getInstallment());
        applicationRequest.setLoanType(request.getLoanType());

        return applicationRequest;
    }

    public List<ApplicationResponse> getAllByEmail(String email) {
        User user = userService.getByEmail(email);
        log.info("user bulundu");

        List<ApplicationResponse> akbankApps = akbankServiceClient.getApplicationsByUserId(prepareAkbankFindallRequest(user));
        //TODO get garanti bank and combine them

        return akbankApps;
    }

    private Long prepareAkbankFindallRequest(User user) {
        return 1L;
    }
}
