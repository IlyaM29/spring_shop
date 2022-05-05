package ru.gb.spring_shop.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.gb.spring_shop.Model.Product;
import ru.gb.spring_shop.Model.ProductDaoImpl;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> products;

    @Autowired
    private ProductDaoImpl productDao;

//    public void init() {
//        products = new ArrayList<>(Arrays.asList(
//                new Product(1L, "Bread", 10),
//                new Product(2L, "Milk", 24),
//                new Product(3L, "Tomato", 20),
//                new Product(4L, "Cucumber", 16)
//        ));
//    }

    public List<Product> getProducts() {
        return productDao.findAll();
    }

    public Product getById(Long id) {
        return productDao.findById(id);
    }

//    public void addProduct(Product product) {
//        products.add(product);
//    }
//
//    public void removeProduct(Long id) {
//        products.remove(getById(id));
//    }
}
