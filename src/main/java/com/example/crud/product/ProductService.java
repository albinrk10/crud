package com.example.crud.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

//Capa de servicio
@Service
public class ProductService {

    HashMap<String,Object> datos;

    private final ProductRepository productRepository;
    //Inyeccion de dependencia
    @Autowired
    public  ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    //Listar
    public List<Product> getProducts() {
        return this.productRepository.findAll();


    }
   //Guardar y actulizar
    public ResponseEntity<Object> newProduct(Product product) {
        Optional<Product> res = productRepository.findProductByName(product.getname());
         datos = new HashMap<>();

        //si encuentra el nombre , manda error o guarda el dipsositvo , se garantiza que la respuesa sea acorde  al usuario
        if (res.isPresent() && product.getId()== null) {
            datos.put("error",true);
            datos.put("message","Ya exite un productor con ese nombre");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        datos.put("message","Se guardado con exito");
        if (product.getId()!=null){
            datos.put("message","actualizo con exito");
        }
        productRepository.save(product);
        datos.put("data",product);
        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }
    //eliminado
    public ResponseEntity<Object> deleteproduct(Long id){
        datos = new HashMap<>();
        boolean existe= this.productRepository.existsById(id);
        if(!existe){
            datos.put("error",true);
            datos.put("message","No  exite un productor con ese id");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        productRepository.deleteById(id);
        datos.put("message","Producto eliminado");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );

    }


}
