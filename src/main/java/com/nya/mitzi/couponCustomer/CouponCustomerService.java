package com.nya.mitzi.couponCustomer;

import com.nya.mitzi.coupon.Coupon;
import com.nya.mitzi.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponCustomerService  {
    @Autowired
    CouponCustomerRepo couponCustomerRepo;

    public boolean existsByCouponAndCustomer(Coupon coupon,Customer customer){
        return this.couponCustomerRepo.existsByCouponIdAndCustomerId(coupon.getId(),customer.getId());
    }

    public void addCouponCustomer(Coupon coupon, Customer customer){
        CouponCustomer couponCustomer= CouponCustomer.builder().customer(customer).coupon(coupon).build();
        this.couponCustomerRepo.save(couponCustomer);
    }


    public void deleteCouponCustomer(Coupon coupon, Customer customer) {
        this.couponCustomerRepo.deleteByCouponIdAndCustomerId(coupon.getId(),customer.getId());
    }
}
