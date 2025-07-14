package com.foody.foody.Models;


import jakarta.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @ManyToOne
    @JoinColumn(
            name = "user_id"
    )
    private  UserModel userId;
    private  String addressLine1;
    private  String addressLine2;
    private  String city;
    private  String state;
    private  String zipCode;
    private  String country;
    private  double latitude;
    private  double longitude;
}
