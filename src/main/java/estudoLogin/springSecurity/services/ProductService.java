package estudoLogin.springSecurity.services;

import estudoLogin.springSecurity.model.product.Product;
import estudoLogin.springSecurity.model.product.ProductRequestDto;
import estudoLogin.springSecurity.model.product.ProductResponseDto;
import estudoLogin.springSecurity.repository.ProductRepository;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Data
public class ProductService {
    private final ProductRepository productRepository;



    public List<ProductResponseDto> listAll(){
        return productRepository.findAll().stream().map(ProductResponseDto::new).toList();
    }

    public Product addProduct(ProductRequestDto data){
        Product newProduct = new Product(data.name(), data.price());
        return productRepository.save(newProduct);
    }
}
