package com.patika.akbankservice.service;

import com.patika.akbankservice.converter.ApplicationConverter;
import com.patika.akbankservice.dto.request.ApplicationRequest;
import com.patika.akbankservice.dto.response.ApplicationResponse;
import com.patika.akbankservice.entity.Application;
import com.patika.akbankservice.entity.Loan;
import com.patika.akbankservice.factory.LoanFactory;
import com.patika.akbankservice.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ApplicationService {

    private LoanFactory loanFactory = new LoanFactory();
    private ApplicationRepository applicationRepository = new ApplicationRepository();

    private final ApplicationConverter applicationConverter;

    /*
    public ApplicationService(ApplicationConverter applicationConverter) {
        this.applicationConverter = applicationConverter;
    }*/

    public ApplicationResponse createApplication(ApplicationRequest request) {
        Application application = applicationConverter.toApplication(request);
        Loan loan = loanFactory.generateLoan(request.getLoanType(), request.getAmount(), request.getInstallment());
        log.info("Loan created." + loan.toString());
        application.setLoan(loan);

        applicationRepository.save(application);

        return applicationConverter.toResponse(application);
    }


    public List<ApplicationResponse> getAll() {
        List<Application> applications = applicationRepository.getAll();

        return applicationConverter.toResponseList(applications);
    }


    public List<ApplicationResponse> getByUserId(Long userId) {
        List<Application> applications = applicationRepository.getByUserId(userId); 

        return applicationConverter.toResponseList(applications);
    }
}
