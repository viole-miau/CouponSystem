package com.nya.mitzi.customer;
import com.nya.mitzi.couponCustomer.CouponCustomer;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name="customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<CouponCustomer> couponCustomer;
}