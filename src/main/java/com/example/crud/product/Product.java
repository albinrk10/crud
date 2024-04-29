package com.example.crud.product;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Product {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
    //atributos -conructor vacio
    private Long id;

    @Column(unique = true)
    private String name;


    private float price;


    private LocalDate fecha;

    @Transient
    private int antiguedad;

    // se crean contructor con id
    public Product(Long id, String name, float price, LocalDate fecha){
        this.id = id;
        this.name = name;
        this.price = price;
        this.fecha = fecha;

    }

    public Product() {
    }

    // se crean contructor sin id
    public Product(String name, float price, LocalDate fecha) {
        this.name = name;
        this.price = price;
        this.fecha = fecha;

    }

    //creamos los gett and sett

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getAntiguedad() {
        //Indicara que es un campo calculado
        return Period.between(this.fecha,LocalDate.now()).getYears();
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
}
