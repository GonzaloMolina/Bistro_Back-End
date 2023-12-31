package Bistro_BackEnd.model.empleado;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String receptor;
    private String emisor;
    private String asunto;
    private String cuerpo;
    private Estado estado;

    /*Constructors*/
    public Solicitud() {}

    public Solicitud(String receptor, String emisor, String asunto, String cuerpo) {
        this.receptor = receptor;
        this.emisor = emisor;
        this.asunto = asunto;
        this.cuerpo = cuerpo;
        this.estado = Estado.ENPROCESO;
    }

    public Long getId() {
        return id;
    }

    public String getReceptor() {
        return receptor;
    }

    public String getEmisor() {
        return emisor;
    }

    public String getAsuto() {
        return asunto;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public void setAsuto(String asuto) {
        this.asunto = asuto;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
