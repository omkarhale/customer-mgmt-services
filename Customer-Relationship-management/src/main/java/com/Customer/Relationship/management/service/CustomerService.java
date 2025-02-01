package com.Customer.Relationship.management.service;

import com.Customer.Relationship.management.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    String insertCustomer(Customer customer);

    List<Customer>getCustomersList();
    Customer getCustomerById(int id);
    String customerUpdate(Customer customer);
    String deleteCustomerById(int id);
    String customerInsertMultiple(List<Customer>customers);
    List<Customer>getCustomerByFirstName(String firstName);
    List<Customer>getCustomerByLessThenAge(int age);
    List<Customer>getCustomerByExactAge(int age);
    List<Customer>getCustomerBylastName(String lastName);
    List<Customer>getCustomerByEmail(String email);
    List<Customer>getCusomerByMobileNumber(String mobilenumber);
    String updateFirstName(int id, String firstName);
    String updateLastName(int id,String lastname);
    String updateEmail(int id ,String email);
    String updatemobileNumber(int id,String mobilenumber);
    String updateAge(int id,int age);
    List<String>getCustomersfirstname();
}
