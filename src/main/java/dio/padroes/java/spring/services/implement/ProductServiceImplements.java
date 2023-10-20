package dio.padroes.java.spring.services.implement;

import dio.padroes.java.spring.entities.Address;
import dio.padroes.java.spring.entities.Distributors;
import dio.padroes.java.spring.entities.Products;

import dio.padroes.java.spring.repositories.AddressesRepository;
import dio.padroes.java.spring.repositories.DistributorsRepository;
import dio.padroes.java.spring.repositories.ProductsRepository;

import dio.padroes.java.spring.services.ProductService;
import dio.padroes.java.spring.services.ViaCepService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * Implementação da <b>Strategy</b> {@link ProductsService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>.
 *
 * @author didifive
 */
@Service
public class ProductServiceImplements implements ProductsService {

    // Singleton: Injetar os componentes do Spring com @Autowired.
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private DistributorsRepository distributorsRepository;
    @Autowired
    private AddressRepository addressesRepository;
    @Autowired
    private ViaCepService viaCepService;

    // Strategy: Implementar os métodos definidos na interface.
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

    @Override
    public Iterable<Products> findAll() {
        return productsRepository.findAll();
    }

    @Override
    public Products findById(Long id) {
        Optional<Products> product = productsRepository.findById(id);
        return product.orElse(null);
    }

    @Override
    public void insert(Products product) {
        insertProductWithDistributor(product);
    }

    @Override
    public void update(Long id, Products product) {
        Optional<Products> productDb = productsRepository.findById(id);
        if (productDb.isPresent()) {
            insertProductWithDistributor(product);
        }
    }

    @Override
    public void delete(Long id) {
        productsRepository.deleteById(id);
    }

    private void insertProductWithDistributor(Products product) {
        List<Distributors> distributorsList = product.getDistributors();
        distributorsList.forEach(this::insertDistributorWithZipCod);
        productsRepository.save(product);
    }

    private void insertDistributorWithZipCod(Distributors distributor) {
        String cep = distributor.getAddress().getCep();
        Addresses address = addressesRepository.findById(cep).orElseGet(() -> {
            Addresses newAddress = viaCepService.consultarCep(cep);
            addressesRepository.save(newAddress);
            return newAddress;
        });
        distributor.setAddress(address);
        distributorsRepository.save(distributor);
    }

}