package com.nya.mitzi.clr;

import com.nya.mitzi.customer.Customer;
import com.nya.mitzi.customer.CustomerService;
import com.nya.mitzi.exception.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

//@Component
//@Order(2)
public class Demo4 implements CommandLineRunner {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CustomerService customerService;

    public List<Customer>customers4Test=new ArrayList<>();

    @Override
    public void run(String... args) throws Exception {

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+'\n');

        System.out.println("--------------------CUSTOMER SERVICE");

        System.out.println("--------------------1.is exist");

        this.addCustomers(0,10,false);

        System.out.println("--------------------1.1.valid"+'\n');

        Customer customer0=this.customers4Test.get(0);
        try {
            this.customerService.addCustomer(customer0);
        }catch (CustomerException e){
            e.printStackTrace();
        }

        System.out.println('\n'+"result: " + this.customerService.isExist(customer0) + '\n');


        System.out.println("--------------------1.2.not valid - email null"+'\n');
        Customer customer1= this.customers4Test.get(1);
        customer1.setFirstName("customer1-null email");
        customer1.setEmail(null);
        System.out.println('\n'+"result: "+this.customerService.isExist(customer1)+'\n');


        System.out.println("--------------------1.3.not valid - password null"+'\n');
        Customer customer2= this.customers4Test.get(2);
        customer2.setFirstName("customer-null password");
        customer2.setPassword(null);
        System.out.println('\n'+"result: "+this.customerService.isExist(customer2)+'\n');


        System.out.println("--------------------1.4.not valid - name null"+'\n');

        Customer customer3= this.customers4Test.get(3);
        customer3.setEmail("customer3-null name");
        customer3.setFirstName(null);

        System.out.println('\n'+"result: "+this.customerService.isExist(customer3)+'\n');


        System.out.println("--------------------1.5.not valid - not exist"+'\n');

        Customer customer4=  this.customers4Test.get(4);

        System.out.println('\n'+"result: "+this.customerService.isExist(customer4)+'\n');


        System.out.println("--------------------1.6.not valid - email empty"+'\n');

        Customer customer5= this.customers4Test.get(5);
        customer5.setFirstName("customer6-empty email");
        customer5.setEmail("");

        System.out.println('\n'+"result: "+this.customerService.isExist(customer5)+'\n');

        System.out.println("--------------------1.7.not valid - password empty"+'\n');

        Customer customer6= this.customers4Test.get(6);
        customer6.setFirstName("customer6-empty password");
        customer6.setPassword("");

        System.out.println('\n'+"result: "+this.customerService.isExist(customer6)+'\n');

        System.out.println("--------------------1.8.not valid - name empty"+'\n');

        Customer customer7= this.customers4Test.get(7);
        customer7.setEmail("customer7-empty name");
        customer7.setFirstName("");

        System.out.println('\n'+"result: "+this.customerService.isExist(customer7)+'\n');


        System.out.println("--------------------2.add");

        this.addCustomers(10,10,false);


        System.out.println("--------------------2.1.valid"+'\n');

        Customer customer10= this.customers4Test.get(10);

        try {
            this.customerService.addCustomer(customer10);
        }catch (CustomerException e) {
            e.printStackTrace();
        }


       System.out.println("--------------------2.2.not valid - email not unique"+'\n');

        Customer customer11= this.customers4Test.get(11);
        customer11.setFirstName("customer10-email not unique");
        customer11.setEmail("customer0@email");

        try {
            this.customerService.addCustomer(customer11);
        }catch (CustomerException e) {
            e.printStackTrace();
        }//todo fix

        System.out.println("--------------------2.3.not valid - firstName not unique"+'\n');

        Customer customer12= this.customers4Test.get(12);
        customer12.setFirstName("customer0");
        customer12.setEmail("customer12-name not unique");

        try {
            this.customerService.addCustomer(customer12);
        }catch (CustomerException e) {
            e.printStackTrace();
        }//todo fix


        /*System.out.println("--------------------2.4.not valid - email null"+'\n');

        Customer customer13= this.customers4Test.get(13);
        customer13.setFirstName("customer3-email null");
        customer13.setEmail(null);

        try {
            this.customerService.addCustomer(customer13);
        }catch (CustomerException e) {
            e.printStackTrace();
        }//todo fix


        System.out.println("--------------------2.5.not valid - password null"+'\n');

        Customer customer14= this.customers4Test.get(14);
        customer14.setFirstName("customer14-password null");
        customer14.setPassword(null);

        try {
            this.customerService.addCustomer(customer14);
        }catch (CustomerException e) {
            e.printStackTrace();
        }//todo fix


        System.out.println("--------------------2.6.not valid - name null"+'\n');

        Customer customer15= this.customers4Test.get(15);
        customer15.setFirstName(null);
        customer15.setEmail("customer15-name null@email");//"real name"

        try {
            this.customerService.addCustomer(customer15);
        }catch (CustomerException e) {
            e.printStackTrace();
        }//todo fix
        */

        System.out.println("--------------------2.7.not valid - email empty"+'\n');

        Customer customer16= this.customers4Test.get(16);
        customer16.setFirstName("customer16-email empty");
        customer16.setEmail("");

        try {
            this.customerService.addCustomer(customer16);
        }catch (CustomerException e) {
            e.printStackTrace();
        }//todo fix


        System.out.println("--------------------2.8.not valid - password empty"+'\n');

        Customer customer17= this.customers4Test.get(17);
        customer17.setFirstName("customer17-password empty");
        customer17.setPassword("");

        try {
            this.customerService.addCustomer(customer17);
        }catch (CustomerException e) {
            e.printStackTrace();
        }//todo fix



        System.out.println("--------------------2.9.not valid - name empty"+'\n');

        Customer customer18= this.customers4Test.get(18);
        customer18.setFirstName("");
        customer18.setEmail("customer18-name empty@email");//"real name"

        try {
            this.customerService.addCustomer(customer18);
        }catch (CustomerException e) {
            e.printStackTrace();
        }//todo fix

        System.out.println("--------------------3.update");

        this.addCustomers(20,10,true);

        System.out.println("--------------------3.1.valid"+'\n');


        Customer customer20= this.customers4Test.get(20);
        customer20.setFirstName("customer20-updated");
        System.out.println(customer20);

        try {
            this.customerService.updateCustomer(3,customer20);
        }catch (CustomerException e){
            e.printStackTrace();
        }


        System.out.println("--------------------3.2.not valid - email not unique"+'\n');

        Customer customer21=this.customers4Test.get(21);
        customer21.setEmail("customer0@email");
        customer21.setFirstName("customer21-email not unique-updated");

        try {
            this.customerService.updateCustomer(4,customer21);
        }catch (CustomerException e){
            e.printStackTrace();
        }//todo fix


        System.out.println("--------------------3.3.not valid - name not unique"+'\n');

        Customer customer22=this.customers4Test.get(22);
        customer22.setEmail("customer22-name not unique-updated");
        customer22.setFirstName("customer0");

        try {
            this.customerService.updateCustomer(5,customer22);
        }catch (CustomerException e){
            e.printStackTrace();
        }//todo fix


        System.out.println("--------------------3.4.not valid - email null"+'\n');

        Customer customer23=this.customers4Test.get(23);
        customer23.setEmail(null);
        customer23.setFirstName("customer23-null email-updated");

        try {
            this.customerService.updateCustomer(6,customer23);
        }catch (CustomerException e){
            e.printStackTrace();
        }//todo fix


        System.out.println("--------------------3.5.not valid - password null"+'\n');

        Customer customer24=this.customers4Test.get(24);
        customer24.setPassword(null);
        customer24.setFirstName("customer24-null password-updated");

        try {
            this.customerService.updateCustomer(7,customer24);
        }catch (CustomerException e){
            e.printStackTrace();
        }//todo fix


        System.out.println("--------------------3.6.not valid - name null"+'\n');

        Customer customer25=this.customers4Test.get(25);
        customer25.setEmail("customer25-null name-updated");
        customer25.setFirstName(null);

        try {
            this.customerService.updateCustomer(8,customer25);
        }catch (CustomerException e){
            e.printStackTrace();
        }//todo fix


        System.out.println("--------------------3.7.not valid - email empty"+'\n');

        Customer customer26=this.customers4Test.get(26);
        customer26.setEmail("");
        customer26.setFirstName("customer26-null email-updated");

        try {
            this.customerService.updateCustomer(6,customer26);
        }catch (CustomerException e){
            e.printStackTrace();
        }//todo fix


        System.out.println("--------------------3.8.not valid - password empty"+'\n');

        Customer customer27=this.customers4Test.get(27);
        customer27.setPassword("");
        customer27.setFirstName("customer27-null password-updated");

        try {
            this.customerService.updateCustomer(7,customer24);
        }catch (CustomerException e){
            e.printStackTrace();
        }//todo fix


        System.out.println("--------------------3.9.not valid - name empty"+'\n');

        Customer customer28=this.customers4Test.get(28);
        customer28.setEmail("customer28-null name-updated");
        customer28.setFirstName("");

        try {
            this.customerService.updateCustomer(8,customer28);
        }catch (CustomerException e){
            e.printStackTrace();
        }//todo fix


        System.out.println("--------------------3.10.not valid - id not exist"+'\n');

        Customer customer29=this.customers4Test.get(29);

        try {
            this.customerService.updateCustomer(20,customer29);
        }catch (CustomerException e){
            e.printStackTrace();
        }//todo fix


        System.out.println("--------------------4.delete");
        System.out.println("--------------------4.1. valid"+'\n');

        try {
            this.customerService.deleteCustomer(4);
        }catch (CustomerException e){
            e.printStackTrace();
        }


        System.out.println("--------------------4.2. not valid - id not exist"+'\n');
        try {
            this.customerService.deleteCustomer(20);
        }catch (CustomerException e){
            e.printStackTrace();
        }


        System.out.println("--------------------5.get one"+'\n');
        System.out.println("--------------------5.1. valid"+'\n');

        try {
            System.out.println(this.customerService.getCustomer(1));
        }catch (CustomerException e){
            e.printStackTrace();
        }


        System.out.println("--------------------5.2. not valid"+'\n');

        try {
            System.out.println(this.customerService.getCustomer(20));
        }catch (CustomerException e){
            e.printStackTrace();
        }


        System.out.println("--------------------6.get all"+'\n');

        System.out.println(this.customerService.getCustomerList());
    }
    public void addCustomers(int firstSerialNumber,int amount,boolean isAddToDb){
        for (int i = firstSerialNumber; i <firstSerialNumber+amount ; i++) {
            Customer customer=Customer.builder()
                    .firstName("customer"+(i))
                    .email("customer"+(i)+"@email")
                    .password("password"+(i))
                    .build();
            if(isAddToDb) {
                try {
                    this.customerService.addCustomer(customer);
                } catch (CustomerException e) {
                    e.printStackTrace();
                }
            }
            this.customers4Test.add(customer);
        }
    }
}
