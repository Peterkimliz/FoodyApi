package com.foody.foody.Services.interfaces;


import com.foody.foody.Dtos.AddressRequest;
import com.foody.foody.Dtos.AddressResponse;
import com.foody.foody.Dtos.ApiResponse;

import java.util.List;

public interface AddressService {

     ApiResponse<AddressResponse>createAddress(AddressRequest addressRequest);
     ApiResponse<AddressResponse>getAddressById(Long id );
     ApiResponse<List<AddressResponse>>getAddressesByUserId(Long id);
     void deleteAddressesByUserId(Long id);

}
