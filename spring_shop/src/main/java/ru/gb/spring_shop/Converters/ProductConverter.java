package ru.gb.spring_shop.Converters;

import org.springframework.stereotype.Component;
import ru.gb.spring_shop.Dto.ProductDto;
import ru.gb.spring_shop.Model.Product;

@Component
public class ProductConverter {

    public Product dtoToEntity(ProductDto productDto0) {
        return new Product(null, productDto0.getTitle(), productDto0.getCost());
    }

    public ProductDto entityToDto(Product product) {
        return new ProductDto(product.getId(), product.getTitle(), product.getCost());
    }
}
