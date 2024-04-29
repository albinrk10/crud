package com.example.crud.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    //  @Query("SELECT * FROM Product p WHERE p.name= ? 1")
    //Metodo personalizado para mandar la imformacion en db
    Optional<Product> findProductByName(String name);
}
