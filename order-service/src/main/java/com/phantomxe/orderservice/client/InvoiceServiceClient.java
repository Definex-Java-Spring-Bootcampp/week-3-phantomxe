package com.phantomxe.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.phantomxe.orderservice.client.dto.InvoiceRequest;
import com.phantomxe.orderservice.client.dto.InvoiceResponse;

@FeignClient("invoice-service")
public interface InvoiceServiceClient {

    @PostMapping("api/invoices")
    public InvoiceResponse createInvoice(@RequestBody InvoiceRequest invoiceRequest);
}
