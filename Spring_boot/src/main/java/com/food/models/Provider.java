package com.food.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id")
    private Long id;
    @Column(name = "shop_full_name")
    private String shopFullName;
    @Column(name = "shop_user_name")
    private String shopUserName;
    @Column(name = "shop_type")
    private String shopType;
    @Column(name = "shop_email")
    private String shopEmail;
    @Column(name = "shop_phone")
    private String shopPhone;
    @Column(name = "shop_address")
    private String shopAddress;
    @Column(name = "shop_password")
    private String shopPassword;
}
