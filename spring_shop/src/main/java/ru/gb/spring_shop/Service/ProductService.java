package ru.gb.spring_shop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.spring_shop.Model.Product;
import ru.gb.spring_shop.Repository.ProductRepository;

import java.util.Collections;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product findProductById(Long id) {
        return productRepository.getById(id);
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(productRepository.getProducts());
    }
}
