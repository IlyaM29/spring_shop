package ru.gb.spring_shop.Model;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.spring_shop.SessionFactoryUtils;

import java.util.List;

@Component
public class BuyerDaoImp {

    @Autowired
    private SessionFactoryUtils sessionFactoryUtils;

    public BuyerDaoImp(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    public List<Product> getBuyersPurchasesById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, id);
            List<Product> products = buyer.getProducts();
            System.out.println(products); // без этого не выводит продукты
            session.getTransaction().commit();
            return products;
        }
    }

    public Buyer findBuyerById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, id);
            session.getTransaction().commit();
            return buyer;
        }
    }

    public List<Buyer> findAll() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Buyer> buyers = session.createQuery("select b from Buyer b").getResultList();
            session.getTransaction().commit();
            return buyers;
        }
    }

    public Buyer findByName(String name) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Buyer buyer = session.createQuery("select b from Buyer b where b.name = :name", Buyer.class)
                    .setParameter("name", name)
                    .getSingleResult();
            session.getTransaction().commit();
            return buyer;
        }
    }

    public void save(Buyer buyer) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(buyer);
            session.getTransaction().commit();
        }
    }

    public void update(Long id, String name) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, id);
            buyer.setName(name);
            session.getTransaction().commit();
        }
    }

    public void deleteByID(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.remove(session.get(Buyer.class, id));
            session.getTransaction().commit();
        }
    }

    public void saveOrUpdate(Buyer buyer) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(buyer);
            session.getTransaction().commit();
        }
    }
}
