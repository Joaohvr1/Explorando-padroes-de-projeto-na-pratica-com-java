package dio.padroes.java.spring.repositories;

import dio.padroes.java.spring.entities.Products;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends CrudRepository<Products, Long> {

}