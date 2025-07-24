package com.foody.foody.Services.impl;

import com.foody.foody.Dtos.*;
import com.foody.foody.Exceptions.NotFoundException;
import com.foody.foody.Models.Cart;
import com.foody.foody.Models.CartItem;
import com.foody.foody.Models.FoodItem;
import com.foody.foody.Models.UserModel;
import com.foody.foody.Repositories.CartItemRepository;
import com.foody.foody.Repositories.CartRepository;
import com.foody.foody.Repositories.FoodItemRepository;
import com.foody.foody.Services.interfaces.CartService;
import com.foody.foody.Services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private FoodItemRepository foodItemRepository;
    @Autowired
    UserService userService;


    @Override
    public ApiResponse<CartResponse> addItemToCart(CartRequest cartRequest) {
        Cart cart = getCart(cartRequest.getUserId());
        CartItem cartItem = cart.getFoodItemList()
                .stream().filter((e) -> e.getFoodItem().getId().equals(cartRequest.getFoodItemId()))
                .findFirst().orElse(null);

        if (cartItem != null) {
            cartItem.setQuantity(cartItem.getQuantity() + cartRequest.getQuantity());
            cartItemRepository.save(cartItem);
        } else {
            Optional<FoodItem> foodItem = foodItemRepository.findById(cartRequest.getFoodItemId());
            if (foodItem.isEmpty()) {
                throw new NotFoundException("Food Item not found");
            }
            CartItem cartItemToSave = new CartItem();
            cartItemToSave.setFoodItem(foodItem.get());
            cartItemToSave.setQuantity(cartRequest.getQuantity());
            cartItemToSave.setCart(cart);
            cartItemRepository.save(cartItemToSave);


        }
        System.out.println("cart"+getCart(cartRequest.getUserId()));
        return new ApiResponse<>(consturctCartResponse(getCart(cartRequest.getUserId())));
    }

    @Override
    public ApiResponse<CartResponse> getCartByUserId(Long userId) {
        System.out.println("Hello " + userId);
        return new ApiResponse<>(consturctCartResponse(getCart(userId)));
    }

    @Override
    public ApiResponse<CartResponse> removeFoodItemFromCart(Long userId, Long foodItemId) {
        Cart cart = getCart(userId);
        CartItem cartItem = cart.getFoodItemList().stream()
                .filter((e) -> e.getFoodItem().getId().equals(foodItemId))
                .findFirst().orElse(null);

        if (cartItem == null) {
            throw new NotFoundException("Cart Item not found");
        }

        cartItemRepository.delete(cartItem);
        cart.getFoodItemList().remove(cartItem);
        return new ApiResponse<>(consturctCartResponse(cart));
    }

    private Cart getCart(Long userId) {
        System.out.println("Hello " + userId);

        Optional<Cart> cartOptional = cartRepository.findByUserId(userId);
        UserModel userModel = userService.getUserById(userId);
        if (cartOptional.isEmpty()) {
            Cart cart = new Cart();
            cart.setCreatedAt(LocalDateTime.now());
            cart.setUser(userModel);
            return cartRepository.save(cart);
        } else {
            return cartOptional.get();
        }
    }

    private CartResponse consturctCartResponse(Cart cart) {
        List<CartItemResponse> cartItemResponses = cart
                .getFoodItemList()
                .stream()
                .map(this::consturctCartItemResponse).toList();
        System.out.println("Cart items are "+cart.getFoodItemList());

        return new CartResponse(
                cart.getId(),
                cart.getCreatedAt(),
                cartItemResponses,
                constructUserResponse(cart.getUser())
        );

    }


    private CartItemResponse consturctCartItemResponse(CartItem cartItem) {
        FoodItemResponse foodItemResponse = new FoodItemResponse(
                cartItem.getFoodItem().getId(),
                cartItem.getCart().getCreatedAt(),
                cartItem.getFoodItem().getDescription(),
                cartItem.getFoodItem().getImageUrl(),
                cartItem.getFoodItem().getName(),
                cartItem.getFoodItem().getPrice(),
                cartItem.getFoodItem().getRestaurant().getId()
        );

        return new CartItemResponse(cartItem.getId(), foodItemResponse, cartItem.getQuantity());
    }

    private UserResponse constructUserResponse(UserModel user) {
        return new UserResponse(user.getFullName(), user.getEmail(), user.getId(), user.getCreatedAt());
    }


}
