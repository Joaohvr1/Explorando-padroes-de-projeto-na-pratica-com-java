package dio.padroes.java.spring.controller;

import dio.padroes.java.spring.entities.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dio.padroes.java.spring.services.ProductService;

@RestController
@RequestMapping("api/v1/products")
public class ProdRestController {

    @Autowired
    private ProductService productsService;

    @GetMapping
    public ResponseEntity<Iterable<Products>> findAll() {
        return ResponseEntity.ok(productsService.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Products> findById(@PathVariable Long id) {
        return ResponseEntity.ok(productsService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Products> insert(@RequestBody Products product) {
        productsService.insert(product);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Products> update(@PathVariable Long id, @RequestBody Products product) {
        productsService.update(id, product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productsService.delete(id);
        return ResponseEntity.ok().build();
    }
}