package com.foody.foody.Controllers;


import com.foody.foody.Dtos.AddressRequest;
import com.foody.foody.Dtos.AddressResponse;
import com.foody.foody.Dtos.ApiResponse;
import com.foody.foody.Services.interfaces.AddressService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Address")
@RestController
@RequestMapping("/api/v1/address/")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping("create")
    ResponseEntity<ApiResponse<AddressResponse>> createAddress(@RequestBody @Validated AddressRequest addressRequest) {
        return new ResponseEntity<>(addressService.createAddress(addressRequest), HttpStatus.CREATED);

    }

    @GetMapping("{id}")
    ResponseEntity<ApiResponse<AddressResponse>> getAddressById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(addressService.getAddressById(id), HttpStatus.OK);
    }

    @GetMapping("all/{userId}")
    ResponseEntity<ApiResponse<List<AddressResponse>> >getAddressesByUserId(@PathVariable("userId") Long id) {
        return new ResponseEntity<>(addressService.getAddressesByUserId(id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    ResponseEntity<?> deleteAddressesByUserId(@PathVariable("id") Long id) {
        addressService.deleteAddressesByUserId(id);
        return new ResponseEntity<>(new ApiResponse<>("address deleted"), HttpStatus.OK);


    }


}
