package estudoLogin.springSecurity.controllers;

import estudoLogin.springSecurity.model.product.ProductRequestDto;
import estudoLogin.springSecurity.repository.ProductRepository;
import estudoLogin.springSecurity.services.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/products")
@AllArgsConstructor
@NoArgsConstructor
public class ProductContoller {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<?> showAll(){
        return ResponseEntity.ok().body(productService.listAll());
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@Valid @RequestBody ProductRequestDto data){
        return ResponseEntity.ok().body(productService.addProduct(data));
    }

}
