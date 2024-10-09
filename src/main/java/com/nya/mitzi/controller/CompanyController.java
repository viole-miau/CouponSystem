package com.nya.mitzi.controller;

import com.nya.mitzi.company.Company;
import com.nya.mitzi.company.CompanyService;
import com.nya.mitzi.coupon.Coupon;
import com.nya.mitzi.coupon.CouponService;
import com.nya.mitzi.exception.CompanyException;
import com.nya.mitzi.exception.CouponException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;
    @Autowired
    CouponService couponService;

    public boolean login(String email,String password){
        return true;
    }

    @RequestMapping(method = RequestMethod.POST,value="/addCoupon")
    public void addCoupon(@RequestBody Coupon coupon)  {
        try {
            this.couponService.addCoupon(coupon);
        } catch (CouponException e) {
            e.printStackTrace();
        } catch (CompanyException e) {
            throw new RuntimeException(e);
        }
    }
    @RequestMapping(method = RequestMethod.PUT,value="/updateCoupon/{id}")
    public void updateCoupon(@PathVariable int id,@RequestBody Coupon coupon)  {
        try {
            this.couponService.updateCoupon(id,coupon);
        } catch (CouponException e) {
            e.printStackTrace();//todo make work with postman
        }
    }


    @DeleteMapping("/deleteCoupon/{id}")
    public void deleteCoupon(@PathVariable int id) {
        try {
            couponService.deleteCoupon(id);
        } catch (CouponException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping(value="/getCompanyCoupons/{companyId}")
    public List<Coupon>getCompanyCoupons(@PathVariable int companyId){
        return this.couponService.getCouponsByCompany(companyId);
    }

    @RequestMapping(value="/getCompanyCoupons/{companyId}", params = {"categoryId"})
    public List<Coupon>getCompanyCouponsByCategory(@PathVariable int companyId,@RequestParam int categoryId){
        return this.couponService.getCouponsByCompanyAndCategory(companyId,categoryId);
    }

    @RequestMapping(value="/getCompanyCoupons/{companyId}", params = {"maxPrice"})
    public List<Coupon>getCompanyCouponsByMaxPrice(@PathVariable int companyId,@RequestParam double maxPrice) throws CompanyException {
        return this.couponService.getCouponsByCompanyAndMaxPrice(companyId,maxPrice);
    }

    @RequestMapping(value="/getCompanyDetails/{id}")
    public Company getCompanyDetails(@PathVariable int id){
        try {
            return this.companyService.getCompany(id);
        } catch (CompanyException e) {
            throw new RuntimeException(e);
        }
    }


}
