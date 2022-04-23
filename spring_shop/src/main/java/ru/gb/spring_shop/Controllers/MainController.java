package ru.gb.spring_shop.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring_shop.Model.Product;
import ru.gb.spring_shop.Service.ProductService;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/product/change_cost")
    public void changeCost(@RequestParam Long productId, @RequestParam Integer delta) {
        productService.changeCost(productId, delta);
    }

    @PostMapping("/product/add")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @GetMapping("/product/remove")
    public void removeProduct (@RequestParam Long productId) {
        productService.removeProduct(productId);
    }
}
