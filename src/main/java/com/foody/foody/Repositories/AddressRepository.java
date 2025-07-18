package com.foody.foody.Repositories;

import com.foody.foody.Models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository  extends JpaRepository<Address,Long> {

    List<Address> findByUserId(Long id);
}
