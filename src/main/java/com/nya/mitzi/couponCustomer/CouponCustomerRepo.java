package com.nya.mitzi.couponCustomer;

import com.nya.mitzi.company.Company;
import com.nya.mitzi.coupon.Coupon;
import com.nya.mitzi.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouponCustomerRepo extends JpaRepository<CouponCustomer,Integer> {

    boolean existsByCouponIdAndCustomerId(int couponId, int customerId);


    void deleteByCouponIdAndCustomerId(int id, int id1);


    @Query("SELECT c.coupon FROM CouponCustomer c WHERE c.customer = :customer")
    List<Coupon> findAllCouponsByCustomerId(@Param("customer") Customer customer);
}
