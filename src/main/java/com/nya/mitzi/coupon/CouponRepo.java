package com.nya.mitzi.coupon;

import com.nya.mitzi.company.Company;
import com.nya.mitzi.couponCustomer.CouponCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouponRepo extends JpaRepository<Coupon,Integer> {

    boolean existsByTitle(String title);

    boolean existsByTitleAndCompanyId(String title, int id);

    List<Coupon> findAllByCompanyId(int companyId);
    List<Coupon> findAllByCompanyIdAndCategoryId(int companyId,int categoryId);

    @Query("SELECT c FROM Coupon c WHERE c.company = :company and c.price <= :max_price")
    List<Coupon> getCouponsByCompanyAndMaxPrice(@Param("company") Company company, @Param("max_price") double maxPrice);


    //List<Coupon> findAllByCustomerId(int customerId);

    //List<Coupon> findAllByCustomerIdAndCategoryId(int customerId, int categoryId);

    //List<Coupon>  findAllByCustomerIdAndMaxPrice(int customerId, double maxPrice);
}
