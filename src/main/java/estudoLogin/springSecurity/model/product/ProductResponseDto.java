package estudoLogin.springSecurity.model.product;

public record ProductResponseDto(String name, double price) {
    public ProductResponseDto(Product product){
        this(product.getName(), product.getPrice());
    }
}
