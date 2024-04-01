package com.phantomxe.invoiceservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phantomxe.invoiceservice.dto.InvoiceRequest;
import com.phantomxe.invoiceservice.dto.InvoiceResponse;
import com.phantomxe.invoiceservice.entity.Invoice;
import com.phantomxe.invoiceservice.service.InvoiceService;

@RestController
@RequestMapping("api/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping
    public List<Invoice> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    @GetMapping("/{email}")
    public List<Invoice> getInvoicesByEmail(@PathVariable String email) {
        return invoiceService.getInvoicesByEmail(email);
    }

    @PostMapping()
    public ResponseEntity<InvoiceResponse> createInvoice(@RequestBody InvoiceRequest invoiceRequest) {
        return ResponseEntity.ok().body(invoiceService.createInvoice(invoiceRequest));
    }
}
