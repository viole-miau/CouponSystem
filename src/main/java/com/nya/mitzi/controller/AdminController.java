package com.nya.mitzi.controller;

import com.nya.mitzi.company.Company;
import com.nya.mitzi.company.CompanyService;
import com.nya.mitzi.customer.Customer;
import com.nya.mitzi.customer.CustomerService;
import com.nya.mitzi.exception.CompanyException;
import com.nya.mitzi.exception.CustomerException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/admin")
public class AdminController extends ClientController{

    @Autowired
    private CompanyService companyService;
    @Autowired
    private CustomerService customerService;

    public boolean login(String email,String password){
        return true;
    }

    @PostMapping("/addCompany")
    public Company addCompany(@RequestBody Company company) throws CompanyException {
        return this.companyService.addCompany(company);
    }

    @RequestMapping(method = RequestMethod.PUT,value="/updateCompany/{id}")
    public void updateCompany(@PathVariable int id,@RequestBody Company company) throws CompanyException {
        this.companyService.updateCompany(id,company);
    }

    @DeleteMapping("/deleteCompany/{id}")
    public void deleteCompany(@PathVariable int id) throws CompanyException {
        companyService.deleteCompany(id);
    }

    @RequestMapping(method = RequestMethod.GET,value="/getCompany/{id}")
    public Company getCompany(@PathVariable int id) throws CompanyException {
        return companyService.getCompany(id);
    }

    @RequestMapping(method = RequestMethod.GET,value="/getAllCompanies")
    public List<Company>getCompanyList(){
        return this.companyService.getCompanyList();
    }
    ///
    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer) throws CustomerException {
        return this.customerService.addCustomer(customer);
    }
    @RequestMapping(method = RequestMethod.POST,value="/updateCustomer/{id}")
    public void updateCustomer(@PathVariable int id,@RequestBody Customer customer) throws CustomerException {
        this.customerService.updateCustomer(id,customer);
    }
    @DeleteMapping("/deleteCustomer/{id}")
    public void deleteCustomer(@PathVariable int id) throws CustomerException {
        customerService.deleteCustomer(id);
    }
    @RequestMapping(method = RequestMethod.GET,value="/getCustomer/{id}")
    public Customer getCustomer(@PathVariable int id) throws CustomerException {
        return customerService.getCustomer(id);
    }
    @RequestMapping(method = RequestMethod.GET,value="/getAllCustomers")
    public List<Customer>getCustomerList(){
        return this.customerService.getCustomerList();
    }

/*

    @RequestMapping(method = RequestMethod.POST,value="/addcustomer")
    public void addcustomer(@RequestBody Customer customer)  {
        try {
            this.customerService.addCustomer(customer);
        } catch (CustomerException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping(method = RequestMethod.POST,value="/updatecustomer")
    public void updatecustomer(@RequestBody Customer customer,@PathVariable int id)  {
        try {
            this.customerService.updateCustomer(id,customer);
        } catch (CustomerException e) {
            e.printStackTrace();
        }
    }
    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable int id) {
        try {
            customerService.deleteCustomer(id);
        } catch (CustomerException e) {
            throw new RuntimeException(e);
        }
    }
    @RequestMapping(value="/customers")
    public List<Customer> getAllCustomers(){
        return customerService.getCustomerList();
    }
    public Customer getcustomer(@PathVariable int id){
        try {
            return customerService.getCustomer(id);
        } catch (CustomerException e) {
            throw new RuntimeException(e);
        }
    }
*/








}
