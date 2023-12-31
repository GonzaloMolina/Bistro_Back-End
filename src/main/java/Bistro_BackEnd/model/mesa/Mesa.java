package Bistro_BackEnd.model.mesa;
import Bistro_BackEnd.model.Orden.Orden;

import javax.persistence.*;

@Entity
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int capacidad;
    private Double cuenta;
    private Long menuId;
    private boolean estaAsignada;

    @OneToOne
    private Orden orden;

    // Constructor vacío
    public Mesa() {
    }

    public Mesa(Long menuId) {
        this.menuId= menuId;
        this.estaAsignada = false;
    }

    public Mesa(Long menuId, boolean estado) {
        this.menuId= menuId;
        this.estaAsignada = estado;
    }

    //Getters
    public Long getId() {
        return id;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public Double getCuenta() {
        return cuenta;
    }

    public Orden getOrden() {
        return orden;
    }

    //Setters
    public void setId(Long id){
        this.id = id;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setCuenta(Double cuenta) {
        this.cuenta = cuenta;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public boolean isEstaAsignada() {
        return estaAsignada;
    }

    public void setEstaAsignada(boolean estaAsignada) {
        this.estaAsignada = estaAsignada;
    }

    public void cambiarEstado(){
        this.estaAsignada = !this.estaAsignada;
    }
}
