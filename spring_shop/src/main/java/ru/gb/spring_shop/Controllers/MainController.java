package ru.gb.spring_shop.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring_shop.Model.Buyer;
import ru.gb.spring_shop.Model.Product;
import ru.gb.spring_shop.Service.BuyerService;
import ru.gb.spring_shop.Service.ProductService;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private ProductService productService;

    @Autowired
    private BuyerService buyerService;

    @GetMapping("/product/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/buyer/all")
    public List<Buyer> getAllBuyer() {
        return buyerService.getAllBuyers();
    }

    @GetMapping("/product/change_cost")
    public void changeCost(@RequestParam Long productId, @RequestParam Integer delta) {
        productService.changeCost(productId, delta);
    }

//    @PostMapping("/product/add")
//    public void addProduct(@RequestBody Product product) {
//        productService.addProduct(product);
//    }
//
//    @GetMapping("/product/remove")
//    public void removeProduct (@RequestParam Long productId) {
//        productService.removeProduct(productId);
//    }
}
