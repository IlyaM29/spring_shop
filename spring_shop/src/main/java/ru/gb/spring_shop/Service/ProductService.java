package ru.gb.spring_shop.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.gb.spring_shop.Dto.ProductDto;
import ru.gb.spring_shop.Model.Product;
import ru.gb.spring_shop.Repository.ProductRepository;
import ru.gb.spring_shop.Repository.specification.ProductSpecification;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<ProductDto> find(Integer page, Integer minCost, Integer maxCost, String title) {
        Specification<Product> specification = Specification.where(null);
        if(minCost != null) {
            specification = specification.and(ProductSpecification.costGreaterOrElseThan(minCost));
        }
        if(maxCost != null) {
            specification = specification.and(ProductSpecification.costLessOrElseThan(maxCost));
        }
        if(title != null) {
            specification = specification.and(ProductSpecification.titleEquals(title));
        }

        return productRepository.findAll(specification, PageRequest.of(page-1, 5)).map(ProductDto::new);
    }

    public ProductDto findById(Long id) {
        return productRepository.findById(id).map(ProductDto::new).orElseThrow();
    }

    public void addProduct(ProductDto productDto) {
        productRepository.save(new Product(productDto.getTitle(), productDto.getCost()));
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
