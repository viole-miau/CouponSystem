package com.nya.mitzi.clr;

import com.nya.mitzi.category.CategoryService;
import com.nya.mitzi.company.Company;
import com.nya.mitzi.company.CompanyService;
import com.nya.mitzi.coupon.CouponService;
import com.nya.mitzi.couponCustomer.CouponCustomerService;
import com.nya.mitzi.customer.CustomerService;
import com.nya.mitzi.exception.CompanyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

//@Component
//@Order(1)
public class Demo3 implements CommandLineRunner {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CouponService couponService;
    @Autowired
    private CouponCustomerService couponCustomerService;

    public List<Company>companies4Test=new ArrayList<>();

    @Override
    public void run(String... args) {

       /* System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+'\n');

        System.out.println("--------------------COMPANY SERVICE");

        System.out.println("--------------------1.is exist");

        this.addCompanies(0,10,false);

        System.out.println("--------------------1.1.valid"+'\n');

        Company company0=this.companies4Test.get(0);
        try {
            this.companyService.addCompany(company0);
        }catch (CompanyException e){
            e.printStackTrace();
        }

        System.out.println('\n'+"result: " + this.companyService.isExist(company0) + '\n');


        System.out.println("--------------------1.2.not valid - email null"+'\n');
        Company company1= this.companies4Test.get(1);
        company1.setName("company1-null email");
        company1.setEmail(null);
        System.out.println('\n'+"result: "+this.companyService.isExist(company1)+'\n');


        System.out.println("--------------------1.3.not valid - password null"+'\n');
        Company company2= this.companies4Test.get(2);
        company2.setName("company2-null password");
        company2.setPassword(null);
        System.out.println('\n'+"result: "+this.companyService.isExist(company2)+'\n');


        System.out.println("--------------------1.4.not valid - name null"+'\n');

        Company company3= this.companies4Test.get(3);
        company3.setEmail("company3-null name");
        company3.setName(null);

        System.out.println('\n'+"result: "+this.companyService.isExist(company3)+'\n');


        System.out.println("--------------------1.5.not valid - not exist"+'\n');

        Company company4=  this.companies4Test.get(4);

        System.out.println('\n'+"result: "+this.companyService.isExist(company4)+'\n');


        System.out.println("--------------------1.6.not valid - email empty"+'\n');

        Company company5= this.companies4Test.get(5);
        company5.setName("company6-empty email");
        company5.setEmail("");

        System.out.println('\n'+"result: "+this.companyService.isExist(company5)+'\n');

        System.out.println("--------------------1.7.not valid - password empty"+'\n');

        Company company6= this.companies4Test.get(6);
        company6.setName("company6-empty password");
        company6.setPassword("");

        System.out.println('\n'+"result: "+this.companyService.isExist(company6)+'\n');

        System.out.println("--------------------1.8.not valid - name empty"+'\n');

        Company company7= this.companies4Test.get(7);
        company7.setEmail("company7-empty name");
        company7.setName("");

        System.out.println('\n'+"result: "+this.companyService.isExist(company7)+'\n');


        System.out.println("--------------------2.add");

        this.addCompanies(10,10,false);


        System.out.println("--------------------2.1.valid"+'\n');

        Company company10= this.companies4Test.get(10);

        try {
            this.companyService.addCompany(company10);
        }catch (CompanyException e){
            e.printStackTrace();
        }


       *//* System.out.println("--------------------2.2.not valid - email not unique"+'\n');

        Company company11= this.companies4Test.get(11);
        company11.setName("company10-email not unique");
        company11.setEmail("company0@email");

        try {
            this.companyService.addCompany(company11);
        }catch (CompanyException e){
            e.printStackTrace();
        }//todo fix

        System.out.println("--------------------2.3.not valid - name not unique"+'\n');

        Company company12= this.companies4Test.get(12);
        company12.setName("company0");
        company12.setEmail("company12-name not unique");

        try {
            this.companyService.addCompany(company12);
        }catch (CompanyException e){
            e.printStackTrace();
        }//todo fix


        System.out.println("--------------------2.4.not valid - email null"+'\n');

        Company company13= this.companies4Test.get(13);
        company13.setName("company3-email null");
        company13.setEmail(null);

        try {
            this.companyService.addCompany(company13);
        }catch (CompanyException e){
            e.printStackTrace();
        }//todo fix


        System.out.println("--------------------2.5.not valid - password null"+'\n');

        Company company14= this.companies4Test.get(14);
        company14.setName("company14-password null");
        company14.setPassword(null);

        try {
            this.companyService.addCompany(company14);
        }catch (CompanyException e){
            e.printStackTrace();
        }//todo fix


        System.out.println("--------------------2.6.not valid - name null"+'\n');

        Company company15= this.companies4Test.get(15);
        company15.setName(null);
        company15.setEmail("company15-name null@email");//"real name"

        try {
            this.companyService.addCompany(company15);
        }catch (CompanyException e) {
            e.printStackTrace();
        }//todo fix*//*
        ///

        *//*System.out.println("--------------------2.7.not valid - email empty"+'\n');

        Company company16= this.companies4Test.get(16);
        company16.setName("company16-email empty");
        company16.setEmail("");

        try {
            this.companyService.addCompany(company16);
        }catch (CompanyException e){
            e.printStackTrace();
        }//todo fix


        System.out.println("--------------------2.8.not valid - password empty"+'\n');

        Company company17= this.companies4Test.get(17);
        company17.setName("company17-password empty");
        company17.setPassword("");

        try {
            this.companyService.addCompany(company17);
        }catch (CompanyException e){
            e.printStackTrace();
        }//todo fix
        /*


        System.out.println("--------------------2.9.not valid - name empty"+'\n');

        Company company18= this.companies4Test.get(18);
        company18.setName("");
        company18.setEmail("company18-name empty@email");//"real name"

        try {
            this.companyService.addCompany(company18);
        }catch (CompanyException e) {
            e.printStackTrace();
        }//todo fix
*//*
        System.out.println("--------------------3.update");

        this.addCompanies(20,10,true);

        System.out.println("--------------------3.1.valid"+'\n');

        Company company20= this.companies4Test.get(20);
        company20.setName("company20-updated");

        try {
            this.companyService.updateCompany(3,company20);
        }catch (CompanyException e){
            e.printStackTrace();
        }


        System.out.println("--------------------3.2.not valid - email not unique"+'\n');

        Company company21=this.companies4Test.get(21);
        company21.setEmail("company0@email");
        company21.setName("company21-email not unique-updated");

        try {
            this.companyService.updateCompany(4,company21);
        }catch (CompanyException e){
            e.printStackTrace();
        }//todo fix


        System.out.println("--------------------3.3.not valid - name not unique"+'\n');

        Company company22=this.companies4Test.get(22);
        company22.setEmail("company22-name not unique-updated");
        company22.setName("company0");

        try {
            this.companyService.updateCompany(5,company22);
        }catch (CompanyException e){
            e.printStackTrace();
        }//todo fix


        System.out.println("--------------------3.4.not valid - email null"+'\n');

        Company company23=this.companies4Test.get(23);
        company23.setEmail(null);
        company23.setName("company23-null email-updated");

        try {
            this.companyService.updateCompany(6,company23);
        }catch (CompanyException e){
            e.printStackTrace();
        }//todo fix


        System.out.println("--------------------3.5.not valid - password null"+'\n');

        Company company24=this.companies4Test.get(24);
        company24.setPassword(null);
        company24.setName("company24-null password-updated");

        try {
            this.companyService.updateCompany(7,company24);
        }catch (CompanyException e){
            e.printStackTrace();
        }//todo fix


        System.out.println("--------------------3.6.not valid - name null"+'\n');

        Company company25=this.companies4Test.get(25);
        company25.setEmail("company25-null name-updated");
        company25.setName(null);

        try {
            this.companyService.updateCompany(8,company25);
        }catch (CompanyException e){
            e.printStackTrace();
        }//todo fix


        System.out.println("--------------------3.7.not valid - email empty"+'\n');

        Company company26=this.companies4Test.get(26);
        company26.setEmail("");
        company26.setName("company26-null email-updated");

        try {
            this.companyService.updateCompany(6,company26);
        }catch (CompanyException e){
            e.printStackTrace();
        }//todo fix


        System.out.println("--------------------3.8.not valid - password empty"+'\n');

        Company company27=this.companies4Test.get(27);
        company27.setPassword("");
        company27.setName("company27-null password-updated");

        try {
            this.companyService.updateCompany(7,company24);
        }catch (CompanyException e){
            e.printStackTrace();
        }//todo fix


        System.out.println("--------------------3.9.not valid - name empty"+'\n');

        Company company28=this.companies4Test.get(28);
        company28.setEmail("company28-null name-updated");
        company28.setName("");

        try {
            this.companyService.updateCompany(8,company28);
        }catch (CompanyException e){
            e.printStackTrace();
        }//todo fix


        System.out.println("--------------------3.10.not valid - id not exist"+'\n');

        Company company29=this.companies4Test.get(29);

        try {
            this.companyService.updateCompany(20,company29);
        }catch (CompanyException e){
            e.printStackTrace();
        }//todo fix


        System.out.println("--------------------4.delete");
        System.out.println("--------------------4.1. valid"+'\n');

        try {
            this.companyService.deleteCompany(4);
        }catch (CompanyException e){
            e.printStackTrace();
        }


        System.out.println("--------------------4.2. not valid - id not exist"+'\n');
        try {
            this.companyService.deleteCompany(20);
        }catch (CompanyException e){
            e.printStackTrace();
        }


        System.out.println("--------------------5.get one"+'\n');
        System.out.println("--------------------5.1. valid"+'\n');

        try {
            System.out.println(this.companyService.getCompany(1));
        }catch (CompanyException e){
            e.printStackTrace();
        }


        System.out.println("--------------------5.2. not valid"+'\n');

        try {
            System.out.println(this.companyService.getCompany(20));
        }catch (CompanyException e){
            e.printStackTrace();
        }

        System.out.println("--------------------6.get all"+'\n');

        System.out.println(this.companyService.getCompanyList());
    }
    public void addCompanies(int firstSerialNumber,int amount,boolean isAddToDb){
        for (int i = firstSerialNumber; i <firstSerialNumber+amount ; i++) {
            Company company=Company.builder()
                    .name("company"+(i))
                    .email("company"+(i)+"@email")
                    .password("password"+(i))
                    .build();
            if(isAddToDb) {
                try {
                    this.companyService.addCompany(company);
                } catch (CompanyException e) {
                    e.printStackTrace();
                }
            }
            this.companies4Test.add(company);
        }*/
    }
}
