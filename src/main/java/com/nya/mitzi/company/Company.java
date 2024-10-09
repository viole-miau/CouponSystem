package com.nya.mitzi.company;

import com.nya.mitzi.coupon.Coupon;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/*@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString*/
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name="companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;

    @OneToMany(mappedBy = "company",fetch = FetchType.LAZY,cascade = {CascadeType.REMOVE})
    @ToString.Exclude
    private List<Coupon> couponList;
}
