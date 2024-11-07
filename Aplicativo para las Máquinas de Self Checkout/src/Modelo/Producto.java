package Modelo;

import java.time.LocalDate;

public class Producto {
    
    public enum Tipoembalaje {botellavidrio, tarroplastico, tarrina, lata, tarrocristal, cajacarton};
    
    protected LocalDate fechadefabricacion;
    protected String nombre;
    protected Proveedor proveedor;
    protected double precio;
    protected int cantidadproducto;
    protected Tipoembalaje tipoembalaje;

    public Producto(LocalDate fechadefabricacion, String nombre, Proveedor proveedor, double precio, int cantidadproducto, Tipoembalaje tipoembalaje) {
        this.fechadefabricacion = fechadefabricacion;
        this.nombre = nombre;
        this.proveedor = proveedor;
        this.precio = precio;
        this.cantidadproducto = cantidadproducto;
        this.tipoembalaje = tipoembalaje;
    }

    public LocalDate getFechadefabricacion() {
        return fechadefabricacion;
    }

    public void setFechadefabricacion(LocalDate fechadefabricacion) {
        this.fechadefabricacion = fechadefabricacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadproducto() {
        return cantidadproducto;
    }

    public void setCantidadproducto(int cantidadproducto) {
        this.cantidadproducto = cantidadproducto;
    }

    public Tipoembalaje getTipoembalaje() {
        return tipoembalaje;
    }

    public void setTipoembalaje(Tipoembalaje tipoembalaje) {
        this.tipoembalaje = tipoembalaje;
    }

    @Override
    public String toString() {
        return "Producto{" + "fechadefabricacion=" + fechadefabricacion + ", nombre=" + nombre + ", proveedor=" + proveedor + ", precio=" + precio + ", cantidadproducto=" + cantidadproducto + ", tipoembalaje=" + tipoembalaje + '}';
    }
}