package Modelo;

import java.time.LocalDate;

public class Perecederos extends Producto {

    private int diascaducar;

    public Perecederos(int diascaducar, LocalDate fechadefabricacion, String nombre, Proveedor proveedor, double precio, int cantidadproducto, Tipoembalaje tipoembalaje) {
        super(fechadefabricacion, nombre, proveedor, precio, cantidadproducto, tipoembalaje);
        this.diascaducar = diascaducar;
    }

    public int getDiascaducar() {
        return diascaducar;
    }

    public void setDiascaducar(int diascaducar) {
        this.diascaducar = diascaducar;
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
        return "Nombre del producto: " + nombre + ", Precio: " + precio + ", Cantidad: " + cantidadproducto
                + ", Fecha de Fabricación: " + fechadefabricacion + ", Proveedor: " + proveedor 
                + ", Días para Caducar: " + diascaducar;
    }

}
