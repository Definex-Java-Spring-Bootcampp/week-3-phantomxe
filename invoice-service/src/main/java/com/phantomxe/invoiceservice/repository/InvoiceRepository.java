package com.phantomxe.invoiceservice.repository;

import java.util.ArrayList;
import java.util.List;

import com.phantomxe.invoiceservice.entity.Invoice;
 
public class InvoiceRepository {
    private List<Invoice> invoices = new ArrayList<>();
    private Integer invoiceNumber = 1;

    public Integer generateInvoiceNumber() {
        return invoiceNumber++;
    }

    public Invoice save(Invoice invoice) {
        invoices.add(invoice);
        return invoice;
    }

    public List<Invoice> getAll() {
        return invoices;
    }

    public List<Invoice> getInvoicesByEmail(String email) {
        return invoices.stream()
            .filter(invoice -> invoice.getCustomer().getEmail().equals(email))
            .toList();
    }
}
