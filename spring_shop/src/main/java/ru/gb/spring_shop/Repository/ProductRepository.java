package ru.gb.spring_shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.spring_shop.Model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCostBetween(Integer min, Integer max);
}
