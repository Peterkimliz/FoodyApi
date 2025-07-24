package com.foody.foody.Controllers;

import com.foody.foody.Dtos.ApiResponse;
import com.foody.foody.Dtos.CartRequest;
import com.foody.foody.Dtos.CartResponse;
import com.foody.foody.Services.interfaces.CartService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart/")
@Tag(name = "Cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("add")
    public ResponseEntity<ApiResponse<CartResponse>> addItemToTheCart(@RequestBody CartRequest cartRequest) {
        return new ResponseEntity<>(cartService.addItemToCart(cartRequest), HttpStatus.OK);
    }

    @GetMapping("all/{userId}")
    public ResponseEntity<ApiResponse<CartResponse>> getUserCart(@PathVariable("userId") Long userId) {
        return new ResponseEntity<>(cartService.getCartByUserId(userId), HttpStatus.OK);
    }

    @DeleteMapping("{userId}/{foodItemId}")
    public ResponseEntity<ApiResponse<CartResponse>> addItemToTheCart(
            @PathVariable("userId") Long userId,
            @PathVariable("foodItemId") Long foodItemId) {
        return new ResponseEntity<>(cartService.removeFoodItemFromCart(userId, foodItemId), HttpStatus.OK);
    }


}
