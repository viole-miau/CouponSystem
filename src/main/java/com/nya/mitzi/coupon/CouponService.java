package com.nya.mitzi.coupon;

import com.nya.mitzi.company.Company;
import com.nya.mitzi.company.CompanyService;
import com.nya.mitzi.couponCustomer.CouponCustomerRepo;
import com.nya.mitzi.couponCustomer.CouponCustomerService;
import com.nya.mitzi.customer.Customer;
import com.nya.mitzi.customer.CustomerService;
import com.nya.mitzi.enum1.ErrorMessage;
import com.nya.mitzi.exception.CompanyException;
import com.nya.mitzi.exception.CouponException;
import com.nya.mitzi.exception.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CouponService {

    @Autowired
    private CouponRepo couponRepo;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CouponCustomerService couponCustomerService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    CouponCustomerRepo couponCustomerRepo;

    public Coupon addCoupon(Coupon coupon) throws CouponException, CompanyException {//todo fix so doesnt contain id
        if (coupon.getCompany()==null){
            throw new CouponException(ErrorMessage.MISSING_COMPANY);
        }

        this.isUnique(coupon);
        if((coupon.getTitle().length()<=0)||(coupon.getCompany()==null)){//todo check if i need both this and companyService.isExist
            throw new CouponException(ErrorMessage.MISSING_DETAILS);
        }
        return this.couponRepo.save(coupon);
    }


    public Coupon getCoupon(int id) throws CouponException {
        return this.couponRepo.findById((int) id).orElseThrow(() -> new CouponException
                (ErrorMessage.ID_NOT_EXIST));
    }

    public List<Coupon> getCouponList() {
        return this.couponRepo.findAll();
    }

    public void updateCoupon(int couponId, Coupon coupon) throws CouponException {
        coupon.setId(couponId);
        couponRepo.save(coupon);
    }

    public void deleteCoupon(int id) throws CouponException {

       /* if (!this.couponRepo.existsById(Math.toIntExact(id))) {
            throw new CouponException(ErrorMessage.ID_NOT_EXIST);
        }*/
        this.couponRepo.deleteById(id);
    }

    public boolean isUnique(Coupon coupon) throws CouponException {

   /*     if(!this.companyService.existById(coupon.getCompany())){
            System.out.println("company not exist");
//            return false;
            throw new CouponException(ErrorMessage.COMPANY_NOT_EXIST);//todo prettify
        }
*/
        if (this.couponRepo.existsById(coupon.getId())) {
            throw new CouponException(ErrorMessage.ID_ALREADY_FOUND);
        }
        if (this.couponRepo.existsByTitleAndCompanyId(coupon.getTitle(), coupon.getCompany().getId())) {
            throw new CouponException(ErrorMessage.COUPON_ALREADY_EXIST);
        }
    /*    if(!this.companyService.existById(coupon.getCompany())){
            throw new CouponException(ErrorMessage.COMPANY_NOT_EXIST);
        }*/
        return false;
    }

    public boolean isExist(Coupon coupon) throws CouponException {


        if(coupon.getCompany()==null){
            System.out.println("company is null");
            return false;//todo prettify
        }

        boolean couponExists=
                this.couponRepo.existsByTitleAndCompanyId(coupon.getTitle(),coupon.getCompany().getId());

        return this.couponRepo.existsByTitleAndCompanyId(coupon.getTitle(),coupon.getCompany().getId());
    }

    public void purchaseCoupon(int couponId, int customerId) throws CouponException, CustomerException {
        Coupon coupon=this.getCoupon(couponId);
        Customer customer=this.customerService.getCustomer(customerId);

        if(!this.isExist(coupon)){
            throw new CouponException(ErrorMessage.COUPON_NOT_EXIST);
        }
        if(!this.customerService.isExist(customer)){
            throw new CustomerException(ErrorMessage.CUSTOMER_NOT_EXIST);
        }
        if(this.couponCustomerService.existsByCouponAndCustomer(coupon,customer)){
            throw new CouponException(ErrorMessage.COUPON_PURCHASED_BY_CUSTOMER);
        }
        if(coupon.getAmount()<1){
            throw new CouponException(ErrorMessage.NO_COUPONS_LEFT);
        }

        this.couponCustomerService.addCouponCustomer(coupon,customer);
    }

    public void deleteCouponCustomer(Coupon coupon,Customer customer){
        this.couponCustomerService.deleteCouponCustomer(coupon,customer);
    }

    public List<Coupon>getCouponsByCompany(int companyId){
        return this.couponRepo.findAllByCompanyId(companyId);
    }

    public List<Coupon>getCouponsByCompanyAndCategory(int companyId, int categoryId) {
        return this.couponRepo.findAllByCompanyIdAndCategoryId(companyId,categoryId);
    }

    public List<Coupon>getCouponsByCompanyAndMaxPrice(int companyId,double maxPrice) throws CompanyException {
        Company company= this.couponRepo.findById(companyId).orElseThrow(
                () -> new CompanyException(ErrorMessage.ID_NOT_EXIST)
        ).getCompany();
        return this.couponRepo.getCouponsByCompanyAndMaxPrice(company, maxPrice);
    }

    public List<Coupon> getCouponsByCustomer(int customerId) throws CustomerException {
        Customer customer=this.customerService.getCustomer(customerId);
        return this.couponCustomerRepo.findAllCouponsByCustomerId(customer);
    }


    public List<Coupon> getCouponsByCustomerAndCategory(int customerId, int categoryId) throws CustomerException {
        List<Coupon>list1=this.getCouponsByCustomer(customerId);
        List<Coupon>list2=new ArrayList<>();

        for (int j = 0; j < list1.size(); j++) {
            if(list1.get(j).getCategory()!=null) {
                if (list1.get(j).getCategory().getId() == categoryId) {
                    list2.add(list1.get(j));
                }
            }
        }
        return list2;
    }



    public List<Coupon> getCouponsByCustomerAndMaxPrice(int customerId, double maxPrice) throws CustomerException {
        List<Coupon>list1=this.getCouponsByCustomer(customerId);
        List<Coupon>list2=new ArrayList<>();

        System.out.println("list1: "+list1);

        for (int j = 0; j < list1.size(); j++) {
            System.out.println("iteration no."+j);
                if (list1.get(j).getPrice()<=maxPrice) {
                    list2.add(list1.get(j));
                }
            System.out.println("coupons ol list1: "+list1.get(j));
        }
        System.out.println("list2: "+list2);

        return list2;
    }


}
