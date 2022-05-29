package ru.gb.spring_shop.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.gb.spring_shop.Converters.ProductConverter;
import ru.gb.spring_shop.Dto.ProductDto;
import ru.gb.spring_shop.Model.Product;
import ru.gb.spring_shop.Repository.ProductRepository;
import ru.gb.spring_shop.Repository.specification.ProductSpecification;
import ru.gb.spring_shop.Validators.ProductValidator;
import ru.gb.spring_shop.exceptions.ValidateException;

import javax.transaction.Transactional;
import java.util.List;

@Service
//@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductValidator productValidator;
    private final ProductConverter productConverter;

    public ProductService(ProductRepository productRepository, ProductValidator productValidator, ProductConverter productConverter) {
        this.productRepository = productRepository;
        this.productValidator = productValidator;
        this.productConverter = productConverter;
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

        return productRepository.findAll(specification, PageRequest.of(page-1, 5)).map(productConverter::entityToDto);
    }

    public ProductDto findById(Long id) {
        return productRepository.findById(id).map(productConverter::entityToDto).orElseThrow();
    }

    public ProductDto addProduct(ProductDto productDto) {
        productValidator.validate(productDto);
        productRepository.save(productConverter.dtoToEntity(productDto));
        return productDto;
    }

    public void deleteProductById(Long id) {
//        log.info("Product {} is delete", id);
        productRepository.deleteById(id);
    }

    @Transactional
    public ProductDto update(ProductDto productDto) {
        if(!productRepository.existsProductById(productDto.getId())) {
            throw new ValidateException(List.of("Продукта с таким id не существует"));
        }
        Product product = productRepository.findById(productDto.getId()).orElseThrow();
        product.setTitle(productDto.getTitle());
        product.setCost(productDto.getCost());
        return productDto;
    }

    @Transactional
    public void updateTitle(Long id, ProductDto productDto) {
        if(!productRepository.existsProductById(productDto.getId())) {
            throw new ValidateException(List.of("Продукта с таким id не существует"));
        }
        Product product = productRepository.findById(id).orElseThrow();
        product.setTitle(productDto.getTitle());
    }
}
