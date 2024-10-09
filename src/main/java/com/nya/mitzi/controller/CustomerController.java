package com.nya.mitzi.controller;

import com.nya.mitzi.coupon.Coupon;
import com.nya.mitzi.coupon.CouponService;
import com.nya.mitzi.couponCustomer.CouponCustomer;
import com.nya.mitzi.customer.Customer;
import com.nya.mitzi.customer.CustomerService;
import com.nya.mitzi.exception.CouponException;
import com.nya.mitzi.exception.CustomerException;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@NoArgsConstructor
@RequestMapping("api/customer")
@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    CouponService couponService;

    public boolean login(String email,String password){
        return true;
    }

    @PostMapping(value="/addPurchase")
    public void purchaseCoupon(@RequestBody CouponCustomer couponCustomer){
        try {
            this.couponService.purchaseCoupon(couponCustomer.getCoupon().getId(), couponCustomer.getCustomer().getId());
        } catch (CouponException | CustomerException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(value="/getCustomersCoupons/{customerId}")
    public List<Coupon> getCustomerCoupons(@PathVariable int customerId) throws CustomerException {
        return this.couponService.getCouponsByCustomer(customerId);
    }

    @GetMapping(value="/getCustomersCoupons/{customerId}", params = {"categoryId"})
    public List<Coupon>getCustomerCouponsByCategory(@PathVariable int customerId,@RequestParam int categoryId) throws CustomerException {
        return this.couponService.getCouponsByCustomerAndCategory(customerId,categoryId);
    }

    @GetMapping(value="/getCustomersCoupons/{customerId}", params = {"maxPrice"})
    public List<Coupon>getCustomerCouponsByMaxPrice(@PathVariable int customerId,@RequestParam double maxPrice) throws CustomerException {
        return this.couponService.getCouponsByCustomerAndMaxPrice(customerId,maxPrice);
    }

    @GetMapping(value="/getCustomerDetails/{customerId}")
    public Customer getCustomerDetails(@PathVariable int customerId){
        try {
            return this.customerService.getCustomer(customerId);
        } catch (CustomerException e) {
            throw new RuntimeException(e);
        }
    }
}
