package domain.cliente;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cliente {

    @Id
    @GeneratedValue
    private int id;
    private String nombre;
    private Long totalVentas = 0L;
    private String estado = "activo";

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public Cliente(String nombre, Long totalVentas) {
        this.nombre = nombre;
        this.totalVentas = totalVentas;
    }

    public Cliente(String nombre, String estado) {
        this.nombre = nombre;
        this.estado = estado;

    }

    public Cliente(String nombre, Long totalVentas, String estado) {
        this.nombre = nombre;
        this.estado = estado;
        this.totalVentas = totalVentas;
    }

    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Long getTotalVentas() {
        return this.totalVentas;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTotalVentas(Long totalVentas) {
        this.totalVentas = totalVentas;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "\nCliente: "+id +
                "\nNombre: "+nombre+
                "\nVentas Totales: "+totalVentas +
                "\nEstado del cliente: "+estado+ "\n";
    }
}
