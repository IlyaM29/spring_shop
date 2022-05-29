package ru.gb.spring_shop.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring_shop.Dto.ProductDto;
import ru.gb.spring_shop.Service.CartService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
//@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public List<ProductDto> getAllProducts() {
        return cartService.getAllProduct();
    }

    @PostMapping
    public void addProduct(@RequestBody ProductDto productDto) {
        cartService.addProduct(productDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct (@PathVariable Long id) {
        cartService.deleteProductById(id);
    }
}
