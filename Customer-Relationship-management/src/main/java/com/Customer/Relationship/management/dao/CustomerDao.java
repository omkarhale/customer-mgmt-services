package com.Customer.Relationship.management.dao;

import com.Customer.Relationship.management.entity.Customer;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CustomerDao {
    //database code
//    @Autowired
    SessionFactory sf;


    public CustomerDao(SessionFactory sf) {
        super();
        this.sf = sf;
    }

    public String insertCustomer(Customer customer) {
        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();
        //insert,update,delete -> you need to use transaction
        session.save(customer);
        tr.commit();
        session.close();
        return "Customer insert Successfully";

    }

    public List<Customer> getCustomersList() {
        Session session=sf.openSession();
        return session.createQuery("from Customer").list();
    }
    public Customer getCustomerById(int id){
        Session session= sf.openSession();
        Customer customer=session.get(Customer.class,id);
        return customer;
    }
    public String updateCustomer(Customer customer){
       Session session= sf.openSession();
       Transaction tr=session.beginTransaction();
       session.update(customer);
       tr.commit();
       session.close();
       return "customer updated succesfully";
    }
    public String deleteCustomerById(int id){
        Session session=sf.openSession();
        Transaction tr=session.beginTransaction();
       Customer customer= session.get(Customer.class,id);
       session.delete(customer);
        tr.commit();
        session.close();
        return "Customer delete successfully";
    }
   public String insertMultipleCustomer(List<Customer>customers){
        Session session=sf.openSession();
       Transaction tr= session.beginTransaction();
        for(Customer customer:customers){
            session.save(customer);
        }
        tr.commit();
        session.close();
        return "Customers inserted successfully";

   }
   public List<Customer>getCustomerByFirstName(String firstName){
        Session session=sf.openSession();

        Query<Customer>customerQuery= session.createQuery("from Customer c  where c.firstName=:firstName",Customer.class);
        customerQuery.setParameter("firstName",firstName);
       List <Customer>list= customerQuery.list();
       return list;
   }
   public List<Customer>getCustomerByAge(int age){
        Session session=sf.openSession();
        Query<Customer>customerQuery= session.createQuery("from Customer c where c.age<:age" ,Customer.class);
        customerQuery.setParameter("age",age);
       List<Customer>list= customerQuery.list();
       return list;
   }
   public List<Customer>getCustomerByExactAge(int age){
        Session session=sf.openSession();
        Query<Customer>customerQuery=session.createQuery("from Customer c where c.age=:age",Customer.class);
        customerQuery.setParameter("age",age);
        List<Customer>list=customerQuery.list();
        return list;
   }
   public List<Customer>getCustomerByLastName(String lastName){
        Session session=sf.openSession();
       Query<Customer>customerQuery= session.createQuery("from Customer c where c.lastName=:lastName",Customer.class);
       customerQuery.setParameter("lastName",lastName);
       List<Customer>list=customerQuery.list();
       return list;
   }
    public List<Customer>getCustomerByEmail(String eMail) {
        Session session = sf.openSession();
        Query<Customer> customerQuery = session.createQuery("from Customer c where c.email=:email", Customer.class);
        customerQuery.setParameter("email", eMail);
        List<Customer> list = customerQuery.list();
        return list;
    }
    public List<Customer>getCustomerBymobileNumber(String mobilenumber) {
        Session session = sf.openSession();
        Query<Customer> customerQuery = session.createQuery("from Customer c where c.mobileNumber=:mobileNumber", Customer.class);
        customerQuery.setParameter("mobileNumber", mobilenumber);
        List<Customer> list = customerQuery.list();
        return list;
    }
    public String updateFirstName(int id,String firstName){
        Session session=sf.openSession();
        Transaction tr=session.beginTransaction();
        Customer customer=session.get(Customer.class,id);
        customer.setFirstName(firstName);
        tr.commit();
        session.close();
        return "updated firstname succesfully";
    }
    public String updateLastName(int id,String lastname){
        Session session=sf.openSession();
        Transaction tr=session.beginTransaction();
       Customer customer= session.get(Customer.class,id);
       customer .setLastName(lastname);
       tr.commit();
       session.close();
       return "updated succesfully";
    }
    public String updateEmailId(int id,String Email){
        Session session=sf.openSession();
        Transaction tr=session.beginTransaction();
        Customer customer=session.get(Customer.class,id);
        customer.setEmail(Email);
        tr.commit();
        session.close();
        return " email update successfully";
    }
    public String updateMobileNumber(int id,String mobileNumber){
        Session session=sf.openSession();
        Transaction tr=session.beginTransaction();
        Customer customer=session.get(Customer.class,id);
        customer.setMobileNumber(mobileNumber);
        tr.commit();
        session.close();
        return "mobile Number updated successfully";
    }
    public String updateAge(int id,int age){
        Session session=sf.openSession();
        Transaction tr=session.beginTransaction();
        Customer customer=session.get(Customer.class,id);
        customer.setAge(age);
        tr.commit();
        session.close();
        return "Age updated successfully";
    }
    public List<String>getCustomersFirstName(){
        Session session=sf.openSession();
        return session.createQuery("select  c.firstName from Customer c").list();
    }
    }
