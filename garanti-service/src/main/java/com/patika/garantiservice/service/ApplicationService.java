package com.patika.garantiservice.service;

import com.patika.garantiservice.converter.ApplicationConverter;
import com.patika.garantiservice.dto.request.ApplicationRequest;
import com.patika.garantiservice.dto.response.ApplicationResponse;
import com.patika.garantiservice.entity.Application;
import com.patika.garantiservice.entity.Loan;
import com.patika.garantiservice.factory.LoanFactory;
import com.patika.garantiservice.repository.ApplicationRepository;
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
