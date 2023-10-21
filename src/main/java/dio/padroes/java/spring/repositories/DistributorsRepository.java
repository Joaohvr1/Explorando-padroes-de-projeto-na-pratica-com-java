package dio.padroes.java.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dio.padroes.java.spring.entities.Distributors;

public interface DistributorsRepository extends CrudRepository<Distributors, Long> {
    
}
