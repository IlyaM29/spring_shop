package ru.gb.spring_shop.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.gb.spring_shop.Model.Product;
import ru.gb.spring_shop.Service.ProductService;

@Controller
public class MainController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product/{id}")
    public String getProduct(Model model, @PathVariable Long id) {
        Product product = productService.findProductById(id);
        model.addAttribute("product", product);
        return "product_page";
    }

    @GetMapping("/product/all")
    public String getTest(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products_info_page";
    }
}
