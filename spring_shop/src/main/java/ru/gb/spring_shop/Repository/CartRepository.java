package ru.gb.spring_shop.Repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.gb.spring_shop.Dto.ProductDto;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CartRepository {

    private final List<ProductDto> cartList = new ArrayList<>();

    public List<ProductDto> getAllProduct() {
        return cartList;
    }

    public void addProduct(ProductDto productDto) {
        cartList.add(productDto);
    }

    public void deleteProductById(Long id) {
        cartList.remove(cartList.stream().filter(productDto -> productDto.getId().equals(id)));
    }
}
