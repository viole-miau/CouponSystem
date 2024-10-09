package com.nya.mitzi.clr;

import com.nya.mitzi.category.Category;
import com.nya.mitzi.category.CategoryService;
import com.nya.mitzi.company.Company;
import com.nya.mitzi.controller.AdminController;
import com.nya.mitzi.controller.CompanyController;
import com.nya.mitzi.controller.CustomerController;
import com.nya.mitzi.coupon.Coupon;
import com.nya.mitzi.couponCustomer.CouponCustomer;
import com.nya.mitzi.customer.Customer;
import com.nya.mitzi.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

//@Component
public class Demo7 implements CommandLineRunner {

    @Autowired
    private AdminController adminController;
    @Autowired
    private CompanyController companyController;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CustomerController customerController;
    @Autowired
    CustomerService customerService;

    @Override
    public void run(String... args) throws Exception {
        Company company1 = Company.builder()
                .name("company1")
                .password("password1")
                .email("company1@email")
                .build();
        this.adminController.addCompany(company1);

        company1.setName("company1-updated");
        this.adminController.updateCompany(1, company1);

        Company company2 = Company.builder()
                .name("company2")
                .password("password2")
                .email("company2@email")
                .build();
        this.adminController.addCompany(company2);
        this.adminController.deleteCompany(1);

        Company company3 = Company.builder()
                .name("company3")
                .password("password3")
                .email("company3@email")
                .build();
        this.adminController.addCompany(company3);
        System.out.println(this.adminController.getCompany(3));

        System.out.println(this.adminController.getCompanyList());
        ///
        Coupon coupon1 = Coupon.builder()
                .title("coupon1")
                .price(1)
                .startDate(LocalDate.now())
                .endDate(LocalDate.now().plusDays(1))
                .amount(1)
                .company(company2)
                .build();
        this.companyController.addCoupon(coupon1);

        coupon1.setTitle("coupon1-updated");
        this.companyController.updateCoupon(2, coupon1);

        Coupon coupon2 = Coupon.builder()
                .title("coupon2")
                .price(2)
                .startDate(LocalDate.now())
                .endDate(LocalDate.now().plusDays(1))
                .amount(2)
                .company(company3)
                .build();
        this.companyController.addCoupon(coupon2);

        this.companyController.deleteCoupon(1);

        Category category1 = Category.builder().name("category1").build();
        this.categoryService.addCategory(category1);

        Coupon coupon3 = Coupon.builder()
                .title("coupon3")
                .price(3)
                .startDate(LocalDate.now())
                .endDate(LocalDate.now().plusDays(1))
                .amount(3)
                .company(company2)
                .category(category1)
                .build();
        System.out.println("category of coupon3: " + coupon3.getCategory());
        this.companyController.addCoupon(coupon3);

        System.out.println(this.companyController.getCompanyCoupons(2));
        System.out.println(this.companyController.getCompanyCouponsByCategory(2, 1));

        Coupon coupon4 = Coupon.builder()
                .title("coupon4")
                .price(4)
                .startDate(LocalDate.now())
                .endDate(LocalDate.now().plusDays(1))
                .amount(4)
                .company(company2)
                .category(category1)
                .price(4)
                .build();
        this.companyController.addCoupon(coupon4);

        System.out.println(
                this.companyController.getCompanyCouponsByMaxPrice(
                        2,
                        2
                )
        );

        System.out.println("to string: " + company2.toString());
        ////
        Customer customer1 = Customer.builder()
                .firstName("customer1")
                .email("customer1@email")
                .password("password1")
                .build();
        this.customerService.addCustomer(customer1);
        CouponCustomer couponCustomer1 = CouponCustomer.builder()
                .customer(customer1)
                .coupon(coupon2)
                .build();
        this.customerController.purchaseCoupon(couponCustomer1);
        System.out.println(this.customerController.getCustomerCoupons(1));

        //System.out.println("category of coupon 4: "+coupon4.getCategory());
        CouponCustomer couponCustomer2 = CouponCustomer.builder()
                .customer(customer1)
                .coupon(coupon4)
                .build();
        this.customerController.purchaseCoupon(couponCustomer2);
        System.out.println(this.customerController.getCustomerCouponsByCategory(1, 1));

        System.out.println(this.customerController.getCustomerCouponsByMaxPrice(1, 1));

        System.out.println("customer details: " + this.customerController.getCustomerCoupons(1));


    }
}
