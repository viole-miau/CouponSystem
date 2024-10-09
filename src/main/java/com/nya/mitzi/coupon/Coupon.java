package com.nya.mitzi.coupon;

import com.nya.mitzi.company.Company;
import com.nya.mitzi.couponCustomer.CouponCustomer;
import jakarta.persistence.*;
import com.nya.mitzi.category.Category;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name="coupons")
@Entity
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name="title")
    private String title;
    @Column(name="description")
    private String description;
    @Column(name="start_date")
    private LocalDate startDate;
    @Column(name="end_date")
    private LocalDate endDate;
    @Column(name="amount")
    private Integer amount;
    @Column(name="price")
    private double price;
    @Column(name="image")
    private String image;

    @ManyToOne()
    @JoinColumn(name="company_id")
    @ToString.Exclude
    private Company company;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name="category_id")
    private Category category;

    @ToString.Exclude
    @OneToMany(mappedBy = "coupon", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<CouponCustomer> couponCustomer;



}
