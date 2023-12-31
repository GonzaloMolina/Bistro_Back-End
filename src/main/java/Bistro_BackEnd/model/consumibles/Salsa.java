package Bistro_BackEnd.model.consumibles;

import javax.persistence.*;

@Entity
public class Salsa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;

    @OneToOne
    @JoinColumn(name = "plato_id")
    private Plato plato;

    // Constructores, getters y setters

    // Constructor vacío requerido por Hibernate
    public Salsa() {
    }

    // Constructor con parámetros
    public Salsa(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }
}