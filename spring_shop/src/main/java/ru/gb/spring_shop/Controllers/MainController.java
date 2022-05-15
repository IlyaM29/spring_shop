package ru.gb.spring_shop.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring_shop.Model.Product;
import ru.gb.spring_shop.Service.ProductService;

import java.util.List;

@RestController
public class MainController {

    private ProductService productService;

    public MainController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/products")
    public void addProduct(@RequestParam String title, @RequestParam Integer cost) {
        productService.addProduct(title, cost);
    }

    @GetMapping("/products/delete/{id}")
    public void deleteProduct (@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/products/cost")
    public List<Product> findByCost(@RequestParam(defaultValue = "0") Integer min, @RequestParam(defaultValue = "50") Integer max) {
        return productService.findByCost(min, max);
    }
}
