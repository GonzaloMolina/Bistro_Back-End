package Bistro_BackEnd.model.consumibles;

import Bistro_BackEnd.model.Orden.Orden;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Plato extends Consumible {
    
    @Enumerated(EnumType.STRING)
    private TipoPlato tipo;

    @ManyToOne
    @JoinColumn(name = "orden_id")
    private Orden orden;

    @OneToMany(mappedBy = "plato", cascade = CascadeType.ALL)
    private List<Acompanamiento> acompanamientos = new ArrayList<>();

    @OneToOne(mappedBy = "plato", cascade = CascadeType.ALL) // Solo si el plato es Pasta
    private Salsa salsa;

    public Plato() {
    }

    // Constructor
    public Plato(String nombre, double precio, TipoPlato tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    //Getters
    public TipoPlato getTipo() {
        return tipo;
    }

    public Orden getOrden() {
        return orden;
    }

    public List<Acompanamiento> getAcompanamientos() {
        return acompanamientos;
    }

    //Setters
    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public void setTipo(TipoPlato tipo) {
        this.tipo = tipo;
    }

    public void setSalsa(Salsa salsa){
        this.salsa = salsa;
    }

    public void setAcompanamientos(List<Acompanamiento> acompanamientos) {
        this.acompanamientos = acompanamientos;
    }
}