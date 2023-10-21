package dio.padroes.java.spring.services;

import dio.padroes.java.spring.entities.Products;

public interface ProductService  {
    Iterable<Products> findAll();

    Products findById(Long id);

    void insert(Products product);

    void update(Long id, Products product);

    void delete(Long id);
}
