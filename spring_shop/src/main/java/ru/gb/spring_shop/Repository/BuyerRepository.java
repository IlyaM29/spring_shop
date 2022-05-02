package ru.gb.spring_shop.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.gb.spring_shop.Model.Buyer;
import ru.gb.spring_shop.Model.BuyerDaoImp;
import ru.gb.spring_shop.Model.Product;

import java.util.List;

@Repository
public class BuyerRepository {

    private List<Buyer> buyers;

    @Autowired
    private BuyerDaoImp buyerDao;

    public List<Buyer> getBuyers() {
        return buyerDao.findAll();
    }
}
