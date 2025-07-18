package com.foody.foody.Services.impl;

import com.foody.foody.Dtos.AddressRequest;
import com.foody.foody.Dtos.AddressResponse;
import com.foody.foody.Dtos.ApiResponse;
import com.foody.foody.Exceptions.NotFoundException;
import com.foody.foody.Models.Address;
import com.foody.foody.Models.UserModel;
import com.foody.foody.Repositories.AddressRepository;
import com.foody.foody.Services.interfaces.AddressService;
import com.foody.foody.Services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    UserService userService;


    @Override
    public ApiResponse<AddressResponse> createAddress(AddressRequest addressRequest) {
        UserModel userModel = userService.getUserById(addressRequest.getUserId());
        Address address = new Address();
        address.setAddressLine1(addressRequest.getAddressLine1());
        address.setAddressLine2(addressRequest.getAddressLine2());
        address.setState(addressRequest.getState());
        address.setCountry(addressRequest.getCountry());
        address.setCity(addressRequest.getCity());
        address.setZipCode(addressRequest.getZipCode());
        address.setLatitude(addressRequest.getLatitude());
        address.setLongitude(addressRequest.getLongitude());
        address.setUser(userModel);
        addressRepository.save(address);
        return new ApiResponse<>(constructAddressResponse(address));
    }

    @Override
    public ApiResponse<AddressResponse> getAddressById(Long id) {
        Optional<Address> addressOptional = addressRepository.findById(id);
        if (addressOptional.isEmpty()) {
            throw new NotFoundException("Address Not found");
        }
        ;

        return new ApiResponse<>(
                constructAddressResponse(addressOptional.get())
        );
    }

    private AddressResponse constructAddressResponse(Address address) {
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setAddressLine1(address.getAddressLine1());
        addressResponse.setAddressLine2(address.getAddressLine2());
        addressResponse.setCity(address.getCity());
        addressResponse.setState(address.getState());
        addressResponse.setCountry(address.getCountry());
        addressResponse.setZipCode(address.getZipCode());
        addressResponse.setLatitude(address.getLatitude());
        addressResponse.setLongitude(address.getLongitude());
        addressResponse.setId(address.getId());
        return addressResponse;
    }

    @Override
    public ApiResponse<List<AddressResponse>> getAddressesByUserId(Long id) {
        List<Address> addressOptional = addressRepository.findByUserId(id);

        List<AddressResponse> addressResponses = addressOptional.stream().map(this::constructAddressResponse).toList();
        return new ApiResponse<>(
                addressResponses
        );
    }

    @Override
    public void deleteAddressesByUserId(Long id) {
        Optional<Address> addressOptional = addressRepository.findById(id);
        if (addressOptional.isEmpty()) {
            throw new NotFoundException("Address Not found");
        }
        ;
        addressRepository.deleteById(id);
    }
}
