package org.example;

import java.time.Month;

public class Invoice {
    int id;
    int price;
    Month invoiceMonth;

    public Invoice(int id, int price, Month invoiceMonth) {
        this.id =id;
        this.price = price;
        this.invoiceMonth = invoiceMonth;
    }
}