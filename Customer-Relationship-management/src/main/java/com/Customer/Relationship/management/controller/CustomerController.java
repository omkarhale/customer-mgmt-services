package com.Customer.Relationship.management.controller;

import com.Customer.Relationship.management.entity.Customer;
import com.Customer.Relationship.management.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/customers")
public class CustomerController {
    CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping("/insert")
    public String insertCustomer(@RequestBody Customer customer){
        String msg=customerService.insertCustomer(customer);
        return msg;

    }
    @GetMapping
    public List<Customer>getCustomersList(){
       List<Customer>list= customerService.getCustomersList();
       return list;
    }
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id){
      return customerService.getCustomerById(id);
    }
    @PutMapping
    public String updateCustomer(@RequestBody Customer customer){
        return customerService.customerUpdate(customer);

    }
     @DeleteMapping("/{id}")
     public String deleteCustomerById(@PathVariable int id){
        return  customerService.deleteCustomerById(id);
    }
    @PostMapping
    public String insertMultipleCustomers(@RequestBody List<Customer>customers){
        return customerService.customerInsertMultiple(customers);
    }
    @GetMapping("/byname/{firstName}")
    public List<Customer>getCustomerByFirstName(@PathVariable String firstName){
      return customerService.getCustomerByFirstName(firstName);
    }
    @GetMapping("/bylessthanAge/{age}")
    public  List<Customer>getCustomerByLessThenAge(@PathVariable int age){
        return  customerService.getCustomerByLessThenAge(age);
    }
    @GetMapping("/exactage/{age}")
    public List<Customer>getAgeByExactAge(@PathVariable int age){
        return customerService.getCustomerByExactAge(age);
    }
    @GetMapping("/bylastName/{lastName}")
    public List<Customer>getCustomerByLastName(@PathVariable String lastName){
        return customerService.getCustomerBylastName(lastName);
    }
    @GetMapping("/byemail/{email}")
    public List<Customer>getCustomerByemail(@PathVariable String email){
        return customerService.getCustomerBylastName(email);
    }
    @GetMapping("/bymobile/{mobilenumber}")
    public List<Customer>getCustomerByMobileNumber(@PathVariable String mobilenumber){
        return customerService.getCusomerByMobileNumber(mobilenumber);
    }
    @PutMapping("/fname/{id}")
    public String updateFirstName(@PathVariable int id, @RequestBody Map<String,String>request){
       String firstname= request.get("firstName");
       return customerService.updateFirstName(id,firstname);
    }
    @PutMapping("/lname/{id}")
    public String updateLastName(@PathVariable int id,@RequestBody Map<String ,String>request ){
        String lastname=request.get("lastName");
        return customerService.updateLastName(id,lastname);
    }
    @PutMapping("/email/{id}")
    public String updateEmail(@PathVariable int id,@RequestBody Map<String ,String>request ){
        String email=request.get("email");
        return customerService.updateLastName(id,email);
    }
    @PutMapping("/mobile/{id}")
    public String updatemobileNumber(@PathVariable int id,@RequestBody Map<String ,String>request ){
        String email=request.get("mobileNumber");
        return customerService.updateLastName(id,email);
    }
    @PutMapping("/age/{id}")
    public String updateAge(@PathVariable int id,@RequestBody Map<String ,Integer>request ){
        int age=request.get("age");
        return customerService.updateAge(id,age);
    }
    @GetMapping("/fistnames")
    public List<String>getFirstNames(){
        return customerService.getCustomersfirstname();
    }
}
