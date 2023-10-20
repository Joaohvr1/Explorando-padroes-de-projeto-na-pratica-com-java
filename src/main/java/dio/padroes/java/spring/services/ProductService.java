package dio.padroes.java.spring.services;

import dio.padroes.java.spring.entities.Products;

public class ProductService {
    public Iterable<Products> findAll();

    public Products findById(Long id);

    public void insert(Products product);

    public void update(Long id, Products product);

    public void delete(Long id);
}
