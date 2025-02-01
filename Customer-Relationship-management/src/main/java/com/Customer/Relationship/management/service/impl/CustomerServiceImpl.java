package com.Customer.Relationship.management.service.impl;

import com.Customer.Relationship.management.dao.CustomerDao;
import com.Customer.Relationship.management.entity.Customer;
import com.Customer.Relationship.management.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    CustomerDao customerDao;

    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public String insertCustomer(Customer customer) {
       String msg=customerDao.insertCustomer(customer);
       return msg;
    }

    @Override
    public List<Customer> getCustomersList() {
        return customerDao.getCustomersList();
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerDao.getCustomerById(id);
    }

    @Override
    public String customerUpdate(Customer customer) {
        return customerDao.updateCustomer(customer);
    }

    @Override
    public String deleteCustomerById(int id) {
        return customerDao.deleteCustomerById(id);
    }

    @Override
    public String customerInsertMultiple(List<Customer> customers) {
        return  customerDao.insertMultipleCustomer(customers);
    }

    @Override
    public List<Customer> getCustomerByFirstName(String firstName) {
        return customerDao.getCustomerByFirstName(firstName);
    }

    @Override
    public List<Customer> getCustomerByLessThenAge(int age) {
        return customerDao.getCustomerByAge(age);
    }

    @Override
    public List<Customer> getCustomerByExactAge(int age) {
        return customerDao.getCustomerByExactAge(age);
    }

    @Override
    public List<Customer> getCustomerBylastName(String lastName) {
        return customerDao.getCustomerByLastName(lastName);
    }

    @Override
    public List<Customer> getCustomerByEmail(String email) {
        return customerDao.getCustomerByEmail(email);
    }

    @Override
    public List<Customer> getCusomerByMobileNumber(String mobilenumber) {
        return customerDao.getCustomerBymobileNumber(mobilenumber);
    }

    @Override
    public String updateFirstName(int id, String firstName) {
        return customerDao.updateFirstName(id,firstName);
    }

    @Override
    public String updateLastName(int id, String lastname) {
        return customerDao.updateLastName(id,lastname);
    }

    @Override
    public String updateEmail(int id, String email) {
        return customerDao.updateEmailId(id,email);
    }

    @Override
    public String updatemobileNumber(int id, String mobilenumber) {
        return customerDao.updateMobileNumber(id,mobilenumber);
    }

    @Override
    public String updateAge(int id, int age) {
        return customerDao.updateAge(id,age);
    }

    @Override
    public List<String> getCustomersfirstname() {
        return customerDao.getCustomersFirstName();
    }
}
