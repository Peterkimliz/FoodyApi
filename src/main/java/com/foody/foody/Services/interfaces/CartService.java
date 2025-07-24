package com.foody.foody.Services.interfaces;

import com.foody.foody.Dtos.ApiResponse;
import com.foody.foody.Dtos.CartRequest;
import com.foody.foody.Dtos.CartResponse;
import com.foody.foody.Models.Cart;

public interface CartService {
    ApiResponse<CartResponse> addItemToCart(CartRequest cartRequest);
    ApiResponse<CartResponse>getCartByUserId(Long userId);
    ApiResponse<CartResponse>removeFoodItemFromCart(Long userId, Long foodItemId);


}
