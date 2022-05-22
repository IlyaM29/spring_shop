package ru.gb.spring_shop.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring_shop.Model.Product;
import ru.gb.spring_shop.Service.ProductService;
import ru.gb.spring_shop.exceptions.AppError;
import ru.gb.spring_shop.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@RestController
public class MainController {

    private ProductService productService;

    public MainController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product with id: " + id + " is not found"));
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
