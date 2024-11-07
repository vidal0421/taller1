package Control;

import Modelo.Producto;
import Modelo.Selfcheckout;
import java.util.ArrayList;
import java.util.Random;

public class ControlCheckout {

    private FachadaLogica fachadalogica;
    private Selfcheckout selfcheckout;
    private int[] productosComprados;
    private int i = 1;

    public ControlCheckout(FachadaLogica fachadalogica) {
        this.fachadalogica = fachadalogica;
        this.selfcheckout = new Selfcheckout();
        this.productosComprados = new int[3];
    }

    public int numerodeTickets() {
        Random random = new Random();
        int numeroDeTickets = random.nextInt(10) + 1;
        crearMaquina(numeroDeTickets);
        return numeroDeTickets;
    }

    public void generarTickets(int numeroDeTickets) {
        if (i <= numeroDeTickets) {
            String n = "Mostrarproductos";
            this.fachadalogica.panelmostrar(n);
            i++; 
        } else {
            String n = "Sair total2";
            this.fachadalogica.panelmostrar(n);
            i = 1; 
        }
    }

    public void crearMaquina(int numeroDepeticiones) {
        ArrayList<Producto> productos = fachadalogica.getControlproductos().getProducto();
        double saldo = 0;
        Selfcheckout checkout = new Selfcheckout(saldo, numeroDepeticiones, productos);
    }

    public void descuentos(String tipoProducto, double precio, int porcentajedeagua, double pagado, int cantidad) {
        double totalpagar = 0.0;
        double descuento = 0.0;

        if (tipoProducto.equalsIgnoreCase("Perecedero")) {
            int diascaducar = porcentajedeagua;
            if (diascaducar == 1) {
                descuento = 0.70;
                totalpagar = cantidad * (precio * descuento);
            } else if (diascaducar == 2) {
                descuento = 0.50;
                totalpagar = cantidad * (precio * descuento);
            } else if (diascaducar == 3) {
                descuento = 0.25;
                totalpagar = cantidad * (precio * descuento);
            } else {
                descuento = 0.0;
                totalpagar = cantidad * precio;
            }
            productosComprados[0] += cantidad;

        } else if (tipoProducto.equalsIgnoreCase("semiPerecedero")) {
            if (porcentajedeagua > 30) {
                descuento = 0.10;
                totalpagar = cantidad * (precio * 0.90);
            } else {
                descuento = 0.0;
                totalpagar = cantidad * precio;
            }
            productosComprados[1] += cantidad;

        } else {
            descuento = 0.0;
            totalpagar = cantidad * precio;
            productosComprados[2] += cantidad;
        }

        double vueltas = pagado - totalpagar;

        if (vueltas > 0) {
            this.fachadalogica.getFachadagrafica().getInterfaz().devueltasDinero(vueltas, tipoProducto, precio, descuento, pagado, cantidad);
            this.fachadalogica.cambiarExistencias2();
        } else if (vueltas == 0) {
            this.fachadalogica.getFachadagrafica().getInterfaz().pagadoexacto(tipoProducto, precio, descuento, pagado, cantidad);
            this.fachadalogica.cambiarExistencias2();
        } else {
            this.fachadalogica.getFachadagrafica().getInterfaz().vueltas(Math.abs(vueltas), tipoProducto, precio, descuento, pagado, cantidad);
        }

        double s = this.selfcheckout.getSaldo();
        double c = s + pagado;
    }

    public int[] getProductosComprados() {
        return productosComprados;
    }

    public void sacarinfo() {
        double saldo = this.selfcheckout.getSaldo();
        int totalProductos = productosComprados[0] + productosComprados[1] + productosComprados[2];

        String info = "Productos comprados: Se compraron "
                + productosComprados[0] + " productos perecederos, "
                + productosComprados[1] + " productos semiperecederos, "
                + productosComprados[2] + " productos no perecederos, "
                + "dando un total de " + totalProductos + " productos.";
        this.fachadalogica.getFachadagrafica().getInterfaz().panelfinal(saldo, info);
    }
}
