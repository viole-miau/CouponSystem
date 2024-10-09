package com.nya.mitzi.clr;

import com.nya.mitzi.category.Category;
import com.nya.mitzi.category.CategoryService;
import com.nya.mitzi.company.Company;
import com.nya.mitzi.company.CompanyService;
import com.nya.mitzi.customer.Customer;
import com.nya.mitzi.customer.CustomerService;
import com.nya.mitzi.exception.CategoryException;
import com.nya.mitzi.exception.CompanyException;
import com.nya.mitzi.exception.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ServiceDemo implements CommandLineRunner {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CustomerService customerService;

    @Override
    public void run(String... args) throws java.lang.Exception {

        //this.addCompanies(1,10,true);

        /*System.out.println("CATEGORY:");
        System.out.println("add:");

        System.out.println("0.valid:");
        try {
            this.categoryService.addCategory(Category.builder().name("category1").build());
        }catch (CategoryException e){
            e.printStackTrace();
        }
        System.out.println("1.1.null name:");
        try {
            this.categoryService.addCategory(Category.builder().name(null).build());
        }catch (CategoryException e){
            e.printStackTrace();
        }
        System.out.println("1.2.empty name:");
        try {
            this.categoryService.addCategory(Category.builder().name("").build());
        }catch (CategoryException e){
            e.printStackTrace();
        }
        System.out.println("1.3.non unique name:");
        try {
            this.categoryService.addCategory(Category.builder().name("category1").build());
        }catch (CategoryException e){
            e.printStackTrace();
        }
        System.out.println("/////");

        System.out.println("update:");
        try {
            this.categoryService.addCategory(Category.builder().name("category2").build());
        }catch (CategoryException e){
            e.printStackTrace();
        }
        System.out.println("0.valid:");
        try {
            this.categoryService.updateCategory(1,Category.builder().name("category1-updated").build());
        }catch (CategoryException e){
            e.printStackTrace();
        }
        System.out.println("1.id not exist:");
        try {
            this.categoryService.updateCategory(3,Category.builder().name("category1-updated again").build());
        }catch (CategoryException e){
            e.printStackTrace();
        }
        System.out.println("2.1.null name:");
        try {
            this.categoryService.updateCategory(1,Category.builder().name(null).build());
        }catch (CategoryException e){
            e.printStackTrace();
        }
        System.out.println("2.2.empty name:");
        try {
            this.categoryService.updateCategory(1,Category.builder().name("").build());
        }catch (CategoryException e){
            e.printStackTrace();
        }
        System.out.println("2.3.non unique name:");
        try {
            this.categoryService.updateCategory(1,Category.builder().name("category2").build());
        }catch (CategoryException e){
            e.printStackTrace();
        }
        System.out.println("/////");


        System.out.println("delete:");
        try{
            this.categoryService.addCategory(Category.builder().name("category3").build());
        } catch(CategoryException e) {
            e.printStackTrace();
        }

        System.out.println("0.valid:");
        try{
            this.categoryService.deleteCategory(2);
        } catch(CategoryException e) {
            e.printStackTrace();
        }
        System.out.println("1.id not exist:");
        try{
            this.categoryService.deleteCategory(4);
        } catch(CategoryException e) {
            e.printStackTrace();
        }
        System.out.println("/////");

        System.out.println("get one:");

        System.out.println("0.valid:");
        try{
            System.out.println(""+this.categoryService.getCategory(1)+'\n');
        } catch(CategoryException e) {
            e.printStackTrace();
        }
        System.out.println("1.id not exist:");
        try{
            System.out.println(""+this.categoryService.getCategory(4)+'\n');
        } catch(CategoryException e) {
            e.printStackTrace();
        }
        System.out.println("/////");

        System.out.println("get all:");
        System.out.println(""+this.categoryService.getCategoryList()+'\n');
        System.out.println("///////////////////////////////////////////////");

        System.out.println("COMPANY:");
        System.out.println("add:");

        System.out.println("0.valid:");
        try {
            this.companyService.addCompany(Company.builder()
                    .name("company1")
                    .email("company@email")
                    .password("password1")
                    .build());
        }catch (CompanyException e){
            e.printStackTrace();
        }
        System.out.println("2.1.null name:");
        try {
            this.companyService.addCompany(Company.builder()
                    .name(null)
                    .email("company@email")
                    .password("password1")
                    .build());
        }catch (CompanyException e){
            e.printStackTrace();
        }
        System.out.println("2.2.empty name:");
        try {
            this.companyService.addCompany(Company.builder()
                    .name("")
                    .email("company@email")
                    .password("password1")
                    .build());
        }catch (CompanyException e){
            e.printStackTrace();
        }
        System.out.println("2.3.non unique name:");
        try {
            this.companyService.addCompany(Company.builder()
                    .name("company1")
                    .email("company@email")
                    .password("password1")
                    .build());
        }catch (CompanyException e){
            e.printStackTrace();
        }
        System.out.println("3.1.null email:");
        try {
            this.companyService.addCompany(Company.builder()
                    .name("company1")
                    .email(null)
                    .password("password1")
                    .build());
        }catch (CompanyException e){
            e.printStackTrace();
        }
        System.out.println("3.2.empty email:");
        try {
            this.companyService.addCompany(Company.builder()
                    .name("company1")
                    .email("")
                    .password("password1")
                    .build());
        }catch (CompanyException e){
            e.printStackTrace();
        }
        System.out.println("3.3.non unique email:");
        try {
            this.companyService.addCompany(Company.builder()
                    .name("company1")
                    .email("company1@email")
                    .password("password1")
                    .build());
        }catch (CompanyException e){
            e.printStackTrace();
        }
        System.out.println("4.1.null password:");
        try {
            this.companyService.addCompany(Company.builder()
                    .name("company1")
                    .email("company1@email")
                    .password(null)
                    .build());
        }catch (CompanyException e){
            e.printStackTrace();
        }
        System.out.println("4.2.empty password:");
        try {
            this.companyService.addCompany(Company.builder()
                    .name("company1")
                    .email("company1@email")
                    .password("")
                    .build());
        }catch (CompanyException e){
            e.printStackTrace();
        }
        System.out.println("///////");

        System.out.println("update:");
        try {
            this.companyService.addCompany(Company.builder()
                    .name("company2")
                    .password("password2")
                    .email("company2@email")

                    .build());
        }catch (CompanyException e){
            e.printStackTrace();
        }
        System.out.println("0.valid:");
        try {
            this.companyService.updateCompany(1,Company.builder()
                    .name("company1-updated")
                    .email("company@email")
                    .password("password1")
                    .build());
        }catch (CompanyException e){
            e.printStackTrace();
        }
        System.out.println("1.id not exist:");
        try {
            this.companyService.updateCompany(4,Company.builder()
                    .name("company1-updated again")
                    .email("company@email")
                    .password("password1")
                    .build());
        }catch (CompanyException e){
            e.printStackTrace();
        }
        System.out.println("2.1.null name:");
        try {
            this.companyService.updateCompany(1,Company.builder()
                    .name(null)
                    .email("company@email")
                    .password("password1")
                    .build());
        }catch (CompanyException e){
            e.printStackTrace();
        }
        System.out.println("2.2.empty name:");
        try {
            this.companyService.updateCompany(1,Company.builder()
                    .name("")
                    .email("company@email")
                    .password("password1")
                    .build());
        }catch (CompanyException e){
            e.printStackTrace();
        }
        System.out.println("2.3.non unique name:");
        try {
            this.companyService.updateCompany(1,Company.builder()
                    .name("company2")
                    .email("company@email")
                    .password("password1")
                    .build());
        }catch (CompanyException e){
            e.printStackTrace();
        }

        System.out.println("3.1.null email:");
        try {
            this.companyService.addCompany(Company.builder().email(null).build());
        }catch (CompanyException e){
            e.printStackTrace();
        }
        System.out.println("3.2.empty email:");
        try {
            this.companyService.updateCompany(1,Company.builder()
                    .name("company1-updated again")
                    .email("")
                    .password("password1")
                    .build());
        }catch (CompanyException e){
            e.printStackTrace();
        }
        System.out.println("3.3.non unique email:");
        try {
            this.companyService.updateCompany(1,Company.builder()
                    .name("company1-updated again")
                    .email("company2@email")
                    .password("password1")
                    .build());
        }catch (CompanyException e){
            e.printStackTrace();
        }
        System.out.println("4.1.null password:");
        try {
            this.companyService.updateCompany(1,Company.builder()
                    .name("company1-updated again")
                    .email("company1@email")
                    .password(null)
                    .build());
        }catch (CompanyException e){
            e.printStackTrace();
        }
        System.out.println("4.2.empty password:");
        try {
            this.companyService.updateCompany(1,Company.builder()
                    .name("company1-updated again")
                    .email("company@email")
                    .password("")
                    .build());
        }catch (CompanyException e){
            e.printStackTrace();
        }
        System.out.println("/////");


        System.out.println("delete:");
        try{
            this.companyService.addCompany(Company.builder()
                    .name("company3")
                    .email("company3@email")
                    .password("password3")
                    .build());
        } catch(CompanyException e) {
            e.printStackTrace();
        }

        System.out.println("0.valid:");
        try{
            this.companyService.deleteCompany(2);
        } catch(CompanyException e) {
            e.printStackTrace();
        }
        System.out.println("1.id not exist:");
        try{
            this.companyService.deleteCompany(4);
        } catch(CompanyException e) {
            e.printStackTrace();
        }
        System.out.println("/////");

        System.out.println("get one:");

        System.out.println("0.valid:");
        try{
            System.out.println(""+this.companyService.getCompany(1)+'\n');
        } catch(CompanyException e) {
            e.printStackTrace();
        }
        System.out.println("1.id not exist:");
        try{
            System.out.println(""+this.companyService.getCompany(4)+'\n');
        } catch(CompanyException e) {
            e.printStackTrace();
        }
        System.out.println("/////");

        System.out.println("get all:");
        System.out.println(""+this.companyService.getCompanyList()+'\n');
        System.out.println("/////");*/

        System.out.println("CUSTOMER:");
        System.out.println("add:");

        System.out.println("0.valid:");
        try {
            this.customerService.addCustomer(Customer.builder()
                    .firstName("customer1")
                    .email("customer1@email")
                    .password("password1")
                    .build());
        } catch (CustomerException e) {
            e.printStackTrace();
        }
        System.out.println("2.1.null name:");
        try {
            this.customerService.addCustomer(Customer.builder()
                    .firstName(null)
                    .email("customer2@email")
                    .password("password1")
                    .build());
        } catch (CustomerException e) {
            e.printStackTrace();
        }
        System.out.println("2.2.empty name:");
        try {
            this.customerService.addCustomer(Customer.builder()
                    .firstName("")
                    .email("customer2@email")
                    .password("password1")
                    .build());
        } catch (CustomerException e) {
            e.printStackTrace();
        }
        System.out.println("2.3.non unique name:");
        try {
            this.customerService.addCustomer(Customer.builder()
                    .firstName("customer1")
                    .email("customer@email")
                    .password("password1")
                    .build());
        } catch (CustomerException e) {
            e.printStackTrace();
        }
        System.out.println("3.1.null email:");
        try {
            this.customerService.addCustomer(Customer.builder()
                    .firstName("customer2")
                    .email(null)
                    .password("password2")
                    .build());
        } catch (CustomerException e) {
            e.printStackTrace();
        }
        System.out.println("3.2.empty email:");
        try {
            this.customerService.addCustomer(Customer.builder()
                    .firstName("customer2")
                    .email("")
                    .password("password12")
                    .build());
        } catch (CustomerException e) {
            e.printStackTrace();
        }
        System.out.println("3.3.non unique email:");
        try {
            this.customerService.addCustomer(Customer.builder()
                    .firstName("customer2")
                    .email("customer1@email")
                    .password("password2")
                    .build());
        } catch (CustomerException e) {
            e.printStackTrace();
        }
        System.out.println("4.1.null password:");
        try {
            this.customerService.addCustomer(Customer.builder()
                    .firstName("customer2")
                    .email("customer2@email")
                    .password(null)
                    .build());
        } catch (CustomerException e) {
            e.printStackTrace();
        }
        System.out.println("4.2.empty password:");
        try {
            this.customerService.addCustomer(Customer.builder()
                    .firstName("customer2")
                    .email("customer2@email")
                    .password("")
                    .build());
        } catch (CustomerException e) {
            e.printStackTrace();
        }
        System.out.println("///////");

        System.out.println("update:");
        try {
            this.customerService.addCustomer(Customer.builder()
                    .firstName("customer2")
                    .password("password2")
                    .email("customer2@email")

                    .build());
        } catch (CustomerException e) {
            e.printStackTrace();
        }
        /////
        //update:

        /*System.out.println("0.valid:");
        try {
            this.customerService.updateCustomer(1,Customer.builder()
                    .firstName("customer1-updated")
                    .email("customer@email")
                    .password("password1")
                    .build());
        }catch (CustomerException e){
            e.printStackTrace();
        }
        System.out.println("1.id not exist:");
        try {
            this.customerService.updateCustomer(4,Customer.builder()
                    .firstName("customer1-updated again")
                    .email("customer3@email")
                    .password("password3")
                    .build());
        }catch (CustomerException e){
            e.printStackTrace();
        }
        System.out.println("2.1.null name:");
        try {
            this.customerService.updateCustomer(1,Customer.builder()
                    .firstName(null)
                    .email("customer3@email")
                    .password("password3")
                    .build());
        }catch (CustomerException e){
            e.printStackTrace();
        }
        System.out.println("2.2.empty name:");
        try {
            this.customerService.updateCustomer(1,Customer.builder()
                    .firstName("")
                    .email("customer3@email")
                    .password("password3")
                    .build());
        }catch (CustomerException e){
            e.printStackTrace();
        }
        System.out.println("2.3.non unique name:");
        try {
            this.customerService.updateCustomer(1,Customer.builder()
                    .firstName("customer2")
                    .email("customer3@email")
                    .password("password3")
                    .build());
        }catch (CustomerException e){
            e.printStackTrace();
        }

        System.out.println("3.1.null email:");
        try {
            this.customerService.addCustomer(Customer.builder().email(null).build());
        }catch (CustomerException e){
            e.printStackTrace();
        }
        System.out.println("3.2.empty email:");
        try {
            this.customerService.updateCustomer(1,Customer.builder()
                    .firstName("customer1-updated again")
                    .email("")
                    .password("password1")
                    .build());
        }catch (CustomerException e){
            e.printStackTrace();
        }
        System.out.println("3.3.non unique email:");
        try {
            this.customerService.updateCustomer(1,Customer.builder()
                    .firstName("customer1-updated again")
                    .email("customer2@email")
                    .password("password1")
                    .build());
        }catch (CustomerException e){
            e.printStackTrace();
        }
        System.out.println("4.1.null password:");
        try {
            this.customerService.updateCustomer(1,Customer.builder()
                    .firstName("customer1-updated again")
                    .email("customer1@email")
                    .password(null)
                    .build());
        }catch (CustomerException e){
            e.printStackTrace();
        }
        System.out.println("4.2.empty password:");
        try {
            this.customerService.updateCustomer(1,Customer.builder()
                    .firstName("customer1-updated again")
                    .email("customer@email")
                    .password("")
                    .build());
        }catch (CustomerException e){
            e.printStackTrace();
        }
        System.out.println("/////");


        System.out.println("delete:");
        try{
            this.customerService.addCustomer(Customer.builder()
                    .firstName("customer3")
                    .email("customer3@email")
                    .password("password3")
                    .build());
        } catch(CustomerException e) {
            e.printStackTrace();
        }

        System.out.println("0.valid:");
        try{
            this.customerService.deleteCustomer(2);
        } catch(CustomerException e) {
            e.printStackTrace();
        }
        System.out.println("1.id not exist:");
        try{
            this.customerService.deleteCustomer(4);
        } catch(CustomerException e) {
            e.printStackTrace();
        }
        System.out.println("/////");

        System.out.println("get one:");

        System.out.println("0.valid:");
        try{
            System.out.println(""+this.customerService.getCustomer(1)+'\n');
        } catch(CustomerException e) {
            e.printStackTrace();
        }
        System.out.println("1.id not exist:");
        try{
            System.out.println(""+this.customerService.getCustomer(4)+'\n');
        } catch(CustomerException e) {
            e.printStackTrace();
        }
        System.out.println("/////");

        System.out.println("get all:");
        System.out.println(""+this.customerService.getCustomerList()+'\n');
        System.out.println("/////");*/
    }

    public void addCompanies(int firstSerialNumber, int amount, boolean isAddToDb) {
        for (int i = firstSerialNumber; i < firstSerialNumber + amount; i++) {
            Company company = Company.builder()
                    .name("company" + (i))
                    .email("company" + (i) + "@email")
                    .password("password" + (i))
                    .build();
            if (isAddToDb) {
                try {
                    this.companyService.addCompany(company);
                } catch (CompanyException e) {
                    e.printStackTrace();
                }
            }
            //this.companies4Test.add(company);
        }
    }
}
