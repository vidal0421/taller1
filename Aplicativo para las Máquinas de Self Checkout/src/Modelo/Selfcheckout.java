
package Modelo;

import java.util.ArrayList;

public class Selfcheckout {

    private double saldo;
    private int numeroDepeticiones;
    private ArrayList<Producto> producto;

    public Selfcheckout(double saldo, int numeroDepeticiones, ArrayList<Producto> producto) {
        this.saldo = saldo;
        this.numeroDepeticiones = numeroDepeticiones;
        this.producto = producto;
    }

    public Selfcheckout() {
    }
    

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumeroDepeticiones() {
        return numeroDepeticiones;
    }

    public void setNumeroDepeticiones(int numeroDepeticiones) {
        this.numeroDepeticiones = numeroDepeticiones;
    }

    public ArrayList<Producto> getProductos() {
        return producto;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.producto = productos;
    }

}
    
   
 
   