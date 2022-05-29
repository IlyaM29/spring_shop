package ru.gb.spring_shop.Validators;

import org.springframework.stereotype.Component;
import ru.gb.spring_shop.Dto.ProductDto;
import ru.gb.spring_shop.exceptions.ValidateException;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductValidator {

    public void validate(ProductDto productDto) {

        List<String> errors = new ArrayList<>();

        if(productDto.getCost() < 1) {
            errors.add("Цена товара не может быть меньше 1");
        }
        if(productDto.getTitle().isBlank()) {
            errors.add("Название товара не может быть пустым");
        }

        if(!errors.isEmpty()) {
            throw new ValidateException(errors);
        }
    }
}
