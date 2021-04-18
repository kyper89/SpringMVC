package ru.geekbrains.springmvc.model.repository;

import ru.geekbrains.springmvc.model.entity.Product;

import java.util.List;

public interface ProductRepository {

    Product getProduct(int id);

    List<Product> getProducts();

    void saveProduct(Product product);
}
