package com.foody.foody.Models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
public class UserModel implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    @JsonIgnore
    private String password;
    private String email;
    private LocalDateTime createdAt;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore

    private List<Address> address;
    @Enumerated(EnumType.STRING)
    private Roles roles;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private  List<RestaurantModel> restaurants;

    public UserModel(Long id, String fullName, String password, String email, LocalDateTime createdAt,
                     List<Address> address, Roles roles, List<RestaurantModel> restaurants) {
        this.id = id;
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.createdAt = createdAt;
        this.address = address;
        this.roles = roles;
        this.restaurants = restaurants;
    }

    public UserModel() {
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(Roles.USER.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public List<RestaurantModel> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<RestaurantModel> restaurants) {
        this.restaurants = restaurants;
    }
}

