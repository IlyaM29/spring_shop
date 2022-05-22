package ru.gb.spring_shop.Controllers;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring_shop.Dto.ProductDto;
import ru.gb.spring_shop.Model.Product;
import ru.gb.spring_shop.Service.ProductService;
import ru.gb.spring_shop.exceptions.ResourceNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class MainController {

    private ProductService productService;

    public MainController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Page<ProductDto> getAllProducts(@RequestParam(name = "page", defaultValue = "1") Integer page,
                                           @RequestParam(name = "min_cost", required = false) Integer minCost,
                                           @RequestParam(name = "max_cost", required = false) Integer maxCost,
                                           @RequestParam(name = "title", required = false) String title) {
        if (page < 1) page = 1;
        return productService.find(page, minCost, maxCost, title);
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping
    public void addProduct(@RequestBody ProductDto productDto) {
        productService.addProduct(productDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct (@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
