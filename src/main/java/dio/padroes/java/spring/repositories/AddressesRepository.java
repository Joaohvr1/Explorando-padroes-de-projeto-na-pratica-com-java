package dio.padroes.java.spring.repositories;

import dio.padroes.java.spring.entities.Address;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressesRepository extends CrudRepository<Address, String>{
    
}