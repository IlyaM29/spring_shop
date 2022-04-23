package ru.gb.spring_shop.Repository;

import org.springframework.stereotype.Repository;
import ru.gb.spring_shop.Model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Bread", 10),
                new Product(2L, "Milk", 24),
                new Product(3L, "Tomato", 20),
                new Product(4L, "Cucumber", 16)
        ));
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getById(Long id) {
        return products.stream().filter(product -> product.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product tot found"));
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Long id) {
        products.remove(getById(id));
    }
}
