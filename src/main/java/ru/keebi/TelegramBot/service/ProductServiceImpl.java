package ru.keebi.TelegramBot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import ru.keebi.TelegramBot.Entity.Product;
import ru.keebi.TelegramBot.Repos.ProductRepo;
import ru.keebi.TelegramBot.service.interfaces.ProductService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(Long id) {

        Product product = new Product();
        product.setId(id);

        return productRepo.findOne(Example.of(product)).orElse(null);

    }

    @Override
    public Product getProductsByName(String name) {

        Product product = new Product();
        product.setName(name);

        return productRepo.findOne(Example.of(product)).orElse(null);

    }

    @Override
    public List<Product> getCategoryProducts(Long id) {
        return productRepo.getCategoryProducts(id);
    }

    @Override
    public List<Product> getTopPopular(Integer top){
        return productRepo.getTopPopular(top).stream().limit(top).collect(Collectors.toList());
    }

    @Override
    public List<Product> getClientProducts(Long id) {
        return productRepo.getClientProducts(id);
    }

}
