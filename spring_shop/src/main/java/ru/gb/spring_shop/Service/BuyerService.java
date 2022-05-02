package ru.gb.spring_shop.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.spring_shop.Model.Buyer;
import ru.gb.spring_shop.Repository.BuyerRepository;

import java.util.Collections;
import java.util.List;

@Service
public class BuyerService {

    @Autowired
    private BuyerRepository buyerRepository;

    public List<Buyer> getAllBuyers() {
        return Collections.unmodifiableList(buyerRepository.getBuyers());
    }
}
