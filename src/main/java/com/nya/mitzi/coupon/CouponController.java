package com.nya.mitzi.coupon;
import com.nya.mitzi.exception.CompanyException;
import com.nya.mitzi.exception.CouponException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("api/coupons")
public class CouponController {
    @Autowired
    private CouponService couponService;
    @PostMapping
    public Coupon addCoupon(@RequestBody Coupon coupon) throws CouponException, CompanyException {
        return this.couponService.addCoupon(coupon);
    }
    @GetMapping("{id}")
    public Object getCoupon(@PathVariable int id){
        try {
            return this.couponService.getCoupon(id);
        } catch (CouponException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public List<Coupon>getCouponList(){
        return this.couponService.getCouponList();
    }
    @DeleteMapping("{id}")
    public void deleteCoupon(@PathVariable int id) throws CouponException {
        this.couponService.deleteCoupon(id);
    }


}
