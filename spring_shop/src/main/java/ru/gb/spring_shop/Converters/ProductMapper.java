package ru.gb.spring_shop.Converters;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.gb.spring_shop.Dto.ProductDto;
import ru.gb.spring_shop.Model.Product;

//@Mapper
public interface ProductMapper {
    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);

    Product toProduct(ProductDto productDto);

    @InheritConfiguration
    ProductDto fromProduct(Product product);
}
