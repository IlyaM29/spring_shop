package ru.gb.spring_shop.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.gb.spring_shop.Dto.ProductDto;
import ru.gb.spring_shop.Repository.CartRepository;

import java.util.List;

@Service
//@RequiredArgsConstructor
@Slf4j
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<ProductDto> getAllProduct() {
        return cartRepository.getAllProduct();
    }

    public void addProduct(ProductDto productDto) {
        cartRepository.addProduct(productDto);
    }

    public void deleteProductById(Long id) {
        cartRepository.deleteProductById(id);
    }
}
