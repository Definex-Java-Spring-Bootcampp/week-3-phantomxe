package com.phantomxe.invoiceservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.phantomxe.invoiceservice.dto.InvoiceRequest;
import com.phantomxe.invoiceservice.dto.InvoiceResponse;
import com.phantomxe.invoiceservice.entity.Invoice;
import com.phantomxe.invoiceservice.repository.InvoiceRepository;

@Service
public class InvoiceService {

    private InvoiceRepository invoiceRepository = new InvoiceRepository(); 

    public InvoiceResponse createInvoice(InvoiceRequest invoiceRequest) {
        Invoice newInvoice = new Invoice(invoiceRepository.generateInvoiceNumber(), invoiceRequest.getProducts(), invoiceRequest.getCustomer());
        invoiceRepository.save(newInvoice);
        return new InvoiceResponse(newInvoice.getInvoiceNumber());
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.getAll();
    }

    public List<Invoice> getInvoicesByEmail(String email) {
        return invoiceRepository.getInvoicesByEmail(email);
    }
    
}
