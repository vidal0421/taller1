package Control;

import Vista.Interfaz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FachadaGrafica implements ActionListener {
    
    private Interfaz interfaz;
    private FachadaLogica fachadalogica;

    public FachadaGrafica() {
        this.interfaz = new Interfaz("Checkout", this);
        this.fachadalogica = new FachadaLogica(this);
        interfaz.mainPanels();
        adicionarListeners();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Soy cliente voy a comprar":
                interfaz.mostrarPanel("Mostrarproductos");
                break;
            case "Agregar productos a la tienda":
                interfaz.mostrarPanel("Inicio"); 
                break;
            case "Sí, deseo cargar nuevos productos":
                interfaz.mostrarPanel("SeleccionTipoProducto");
                break;
            case "Cambiar cantidad de existencia":
                interfaz.mostrarPanel("Cambiarexistencias");
                break;
            case "Eliminar productos":
                interfaz.mostrarPanel("Eliminar");
                break;
            case "Producto Perecedero":
                interfaz.mostrarPanel("CargarProductoPerecedero");
                break;
            case "Producto Semiperecedero":
                interfaz.mostrarPanel("CargarProductoSemiperecedero");
                break;
            case "Producto No Perecedero":
                interfaz.mostrarPanel("CargarProductoNoperecedero");
                break;
            case "Enviar Datos Del Producto Noperecedero":
                interfaz.mostrarPanel("Pantalla Inicial");
                break;
            case "Enviar Datos Del Producto Semiperecedero":
                interfaz.mostrarPanel("Pantalla Inicial");
                break;
            case "Enviar Datos Del Producto Perecedero":
                interfaz.mostrarPanel("Pantalla Inicial");
                break;
            case "Volver al inicio":
                interfaz.mostrarPanel("Pantalla Inicial");
                break;
            case "Salir":
                System.exit(0);
                break;
            case "Cambiar existencias":
                interfaz.mostrarPanel("Pantalla Inicial");
                break;
            case "Eliminar Producto":
                interfaz.mostrarPanel("Pantalla Inicial");
                break;
            case "Salir total":
                this.fachadalogica.getControlcheckout().sacarinfo();
                break;
            case "Pagar Producto":
                interfaz.mostrarPanel("Pantalla inicial");
                break;
        }
    }

    public Interfaz getInterfaz() {
        return interfaz;
    }

    public FachadaLogica getFachadalogica() {
        return fachadalogica;
    }
    
    public void adicionarListeners(){
        interfaz.botonComprarCliente.addActionListener(this);
        interfaz.botonAgregarProductos.addActionListener(this);
        interfaz.botoncargarnuevoproducto.addActionListener(this);
        interfaz.botonCambiarCantidadExistencia.addActionListener(this);
        interfaz.botonEliminarProductos.addActionListener(this);
        interfaz.botonproductoperesedero.addActionListener(this);
        interfaz.botonproductosemiperesedero.addActionListener(this);
        interfaz.botonproductonoperesedero.addActionListener(this);
        interfaz.botonEnviarDatosProductoPerecederos.addActionListener(this);
        interfaz.botonEnviarDatosProductoNoperecederos.addActionListener(this);
        interfaz.botonEnviarDatosProductoSemiperecederos.addActionListener(this);
        interfaz.botonvolveralinicio.addActionListener(this);
        interfaz.botonbuscar.addActionListener(this);
        interfaz.botonEliminar.addActionListener(this);
        interfaz.botonPagar.addActionListener(this);
        interfaz.botonSalir1.addActionListener(this);
        interfaz.botonSalir2.addActionListener(this);
        interfaz.botonSalir3.addActionListener(this);
        interfaz.botonSalir4.addActionListener(this);
        interfaz.botonSalir5.addActionListener(this);
        interfaz.botonSalir6.addActionListener(this);
        interfaz.botonRegresar.addActionListener(this);
    }
}