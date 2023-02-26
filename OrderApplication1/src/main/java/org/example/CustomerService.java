package org.example;

import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class CustomerService {
    //List for individual customers
    List<IndivualCustomer> individualCustomers;
    //List for corporate customers
    List<CorporateCustomer> corporateCustomers;

    public CustomerService() {
        this.individualCustomers = new ArrayList<>();
        this.corporateCustomers = new ArrayList<>();
    }

    //Add individual customers
    public void addIndividualCustomer(IndivualCustomer customer) {
        individualCustomers.add(customer);
    }

    //Add corporate customers
    public void addCorporateCustomer(CorporateCustomer customer) {
        corporateCustomers.add(customer);
    }

    //List all customers
    public void getAllCustomers() {
        System.out.println("Individual Customers");
        for (IndivualCustomer customer : individualCustomers) {
            System.out.println(
                    "Customer Id: " + customer.id +
                            " Full Name: " + customer.fullName +
                            " Created Date: " + customer.createdDate +
                            " Invoices: " + customer._invoices.stream().map(b -> "Id: " + b.id + " Price: " + b.price + " Month: " + b.invoiceMonth).collect(Collectors.toList()));
        }
        System.out.println("Corporate Customers");
        for (CorporateCustomer customer : corporateCustomers) {
            System.out.println(
                    "Customer Id: " + customer.id +
                            " Name: " + customer.name +
                            " Sector: " + customer.sector +
                            " Created Date: " + customer.createdDate +
                            " Invoices: " + customer._invoices.stream().map(b -> "Id: " + b.id + " Price: " + b.price + " Month: " + b.invoiceMonth).collect(Collectors.toList()));
        }
    }

    //List customers contains 'C'
    public void getCustomersContainsC() {
        for (IndivualCustomer customer : individualCustomers) {
            if (customer.fullName.toUpperCase().contains("C")) {
                System.out.println(
                        "Customer Id: " + customer.id +
                                " Full Name: " + customer.fullName +
                                " Created Date: " + customer.createdDate +
                                " Invoices: " + customer._invoices.stream().map(b -> "Id: " + b.id + " Price: " + b.price + " Month: " + b.invoiceMonth).collect(Collectors.toList()));
            }
        }
    }

    //Total Price Of Invoices Of Customers Created In June
    public void getCustomersWithCreatedMonthJune() {
        int totalPrice = 0;
        for (IndivualCustomer customer : individualCustomers) {
            if (customer.createdDate.getMonth() == Month.JUNE) {
                List<Invoice> result = customer._invoices.stream().collect(Collectors.toList());
                for (Invoice invoice : result) {
                    totalPrice += invoice.price;
                }
            }
        }
        for (CorporateCustomer customer : corporateCustomers) {
            if (customer.createdDate.getMonth() == Month.JUNE) {
                List<Invoice> result = customer._invoices.stream().collect(Collectors.toList());
                for (Invoice invoice : result) {
                    totalPrice += invoice.price;
                }
            }
        }
        System.out.println("Total price: " + totalPrice);
    }

    //List all invoices
    public void getAllInvoices() {
        for (Customer customer : individualCustomers) {
            System.out.println(customer._invoices.stream().map(b -> "Id: " + b.id + " Price: " + b.price + " Month: " + b.invoiceMonth).collect(Collectors.toList()));
        }
        for (Customer customer : corporateCustomers) {
            System.out.println(customer._invoices.stream().map(b -> "Id: " + b.id + " Price: " + b.price + " Month: " + b.invoiceMonth).collect(Collectors.toList()));
        }
    }

    //List all invoices greater than 1500
    public void getAllInvoicesGreaterThan1500() {
        for (Customer customer : individualCustomers) {
            List<Invoice> result = customer._invoices.stream().filter(b -> b.price > 1500).collect(Collectors.toList());
            if (result.size() > 0) {
                System.out.println(result.stream().map(b -> "Id: " + b.id + " Price: " + b.price + " Month: " + b.invoiceMonth).collect(Collectors.toList()));
            }
        }
        for (Customer customer : corporateCustomers) {
            List<Invoice> result = customer._invoices.stream().filter(b -> b.price > 1500).collect(Collectors.toList());
            if (result.size() > 0) {
                System.out.println(result.stream().map(b -> "Id: " + b.id + " Price: " + b.price + " Month: " + b.invoiceMonth).collect(Collectors.toList()));
            }
        }
    }

    //Calculate average of invoices greater than 1500
    public void calculateAverageInvoicesGreaterThan1500() {
        List<Integer> avgResult = new ArrayList<>();
        int sum = 0;
        for (Customer customer : individualCustomers
        ) {
            List<Invoice> result = customer._invoices.stream().filter(b -> b.price > 1500).collect(Collectors.toList());
            for (Invoice invoice : result
            ) {
                avgResult.add(invoice.price);
            }
        }
        for (Customer customer : corporateCustomers) {
            List<Invoice> result = customer._invoices.stream().filter(b -> b.price > 1500).collect(Collectors.toList());
            for (Invoice invoice : result
            ) {
                avgResult.add(invoice.price);
            }
        }
        for (int i : avgResult) {
            sum += i;
        }
        System.out.println(sum / avgResult.size());
    }

    //List names of customers with invoices under 500TL in the system
    public void getAllCustomersLessThan500() {
        for (IndivualCustomer customer : individualCustomers) {
            List<Invoice> result = customer._invoices.stream().filter(b -> b.price < 500).collect(Collectors.toList());
            if (result.size() > 0) {
                System.out.println(customer.fullName);
            }
        }
    }

    //List in which sector the companies with invoice of less than 750 in June are
    public void getCorporateCustomersFiltered() {
        for (CorporateCustomer customer : corporateCustomers) {
            List<Invoice> result = customer._invoices.stream().filter(b -> b.price < 750).filter(b -> b.invoiceMonth == Month.JUNE).collect(Collectors.toList());
            if (result.size() > 0) {
                System.out.println(customer.sector);
            }
        }
    }
}