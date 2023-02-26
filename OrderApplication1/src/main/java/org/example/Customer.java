package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    int id;
    LocalDate createdDate;
    List<Invoice> _invoices;

    public Customer(int id, LocalDate createdDate, Invoice... invoices) {
        this.id = id;
        this.createdDate = createdDate;
        this._invoices = new ArrayList<>(List.of(invoices));
    }
}