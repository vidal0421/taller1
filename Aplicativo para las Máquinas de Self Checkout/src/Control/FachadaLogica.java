package Control;

import Modelo.Producto.Tipoembalaje;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FachadaLogica {

    private ControlProductos controlproductos;
    private ControlCheckout controlcheckout;
    private FachadaGrafica fachadagrafica;

    public FachadaLogica(FachadaGrafica fachadagrafica) {
        this.fachadagrafica = fachadagrafica;
        this.controlproductos = new ControlProductos(this);
        this.controlcheckout = new ControlCheckout(this);

    }

    public void crearProductoperecedero() {
        String fechaTexto = "";
        LocalDate fechadefabricacion = LocalDate.now();
        String nombre = "";
        double precio = 0;
        int cantidadproducto = 0;
        Tipoembalaje tipoembalaje = null;
        String nombreproveedor = "";
        String marcaproveedor = "";
        String correoproveedor = "";
        String direccionproveedor = "";
        int diascaducar = 0;

        fechaTexto = this.fachadagrafica.getInterfaz().fechaField.getText();
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        if (fechaTexto == null || fechaTexto.trim().isEmpty()) {
            return;
        }

        fechadefabricacion = LocalDate.parse(fechaTexto, formatoFecha);

        nombre = this.fachadagrafica.getInterfaz().nombreProductoField.getText();
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío.");
        }
        precio = Double.parseDouble(this.fachadagrafica.getInterfaz().precioField.getText());

        cantidadproducto = Integer.parseInt(this.fachadagrafica.getInterfaz().cantidadField.getText());
        diascaducar = Integer.parseInt(this.fachadagrafica.getInterfaz().diascaducadosField.getText());
        String tipoEmbalajeName = this.fachadagrafica.getInterfaz().tipoEmbalaje.getToolTipText().toUpperCase();
        tipoembalaje = Tipoembalaje.valueOf(tipoEmbalajeName);

        nombreproveedor = this.fachadagrafica.getInterfaz().proveedorNombreField.getText();
        marcaproveedor = this.fachadagrafica.getInterfaz().proveedorMarcaField.getText();
        correoproveedor = this.fachadagrafica.getInterfaz().proveedorCorreoField.getText();
        direccionproveedor = this.fachadagrafica.getInterfaz().proveedorDireccionField.getText();

        this.controlproductos.crearProductoperecedero(fechadefabricacion, nombre, precio, cantidadproducto, tipoembalaje, nombreproveedor, marcaproveedor, correoproveedor, direccionproveedor, diascaducar);
        this.controlproductos.crearProductos(fechadefabricacion, nombre, precio, cantidadproducto, tipoembalaje, nombreproveedor, marcaproveedor, correoproveedor, direccionproveedor);
    }

    public void crearProductossemiperecedero() {
        String fechaTexto = "";
        LocalDate fechadefabricacion = LocalDate.now();
        String nombre = "";
        double precio = 0;
        int cantidadproducto = 0;
        Tipoembalaje tipoembalaje = null;
        String nombreproveedor = "";
        String marcaproveedor = "";
        String correoproveedor = "";
        String direccionproveedor = "";
        int porcentajeagua = 0;
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        fechaTexto = this.fachadagrafica.getInterfaz().fechaField.getText();

        if (fechaTexto == null || fechaTexto.trim().isEmpty()) {
            return;
        }

        fechadefabricacion = LocalDate.parse(fechaTexto, formatoFecha);
        nombre = this.fachadagrafica.getInterfaz().nombreProductoField.getText();
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío.");
        }

        precio = Double.parseDouble(this.fachadagrafica.getInterfaz().precioField.getText());

        cantidadproducto = Integer.parseInt(this.fachadagrafica.getInterfaz().cantidadField.getText());

        porcentajeagua = Integer.parseInt(this.fachadagrafica.getInterfaz().diascaducadosField.getText());

        String tipoEmbalajeName = this.fachadagrafica.getInterfaz().tipoEmbalaje.getToolTipText();
        if (tipoEmbalajeName != null && !tipoEmbalajeName.trim().isEmpty()) {
            tipoembalaje = Tipoembalaje.valueOf(tipoEmbalajeName.toUpperCase());
        } else {
            throw new IllegalArgumentException("El tipo de embalaje no puede estar vacío o nulo.");
        }

        nombreproveedor = this.fachadagrafica.getInterfaz().proveedorNombreField.getText();
        marcaproveedor = this.fachadagrafica.getInterfaz().proveedorMarcaField.getText();
        correoproveedor = this.fachadagrafica.getInterfaz().proveedorCorreoField.getText();
        direccionproveedor = this.fachadagrafica.getInterfaz().proveedorDireccionField.getText();

        this.controlproductos.crearProductosemiperecedero(fechadefabricacion, nombre, precio, cantidadproducto, tipoembalaje, nombreproveedor, marcaproveedor, correoproveedor, direccionproveedor, porcentajeagua);
        this.controlproductos.crearProductos(fechadefabricacion, nombre, precio, cantidadproducto, tipoembalaje, nombreproveedor, marcaproveedor, correoproveedor, direccionproveedor);
    }

    public void crearProductonoperecedero() {
        String fechaTexto = "";
        LocalDate fechadefabricacion = LocalDate.now();
        String nombre = "";
        double precio = 0;
        int cantidadproducto = 0;
        Tipoembalaje tipoembalaje = null;
        String nombreproveedor = "";
        String marcaproveedor = "";
        String correoproveedor = "";
        String direccionproveedor = "";
        String tipo = "";
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        fechaTexto = this.fachadagrafica.getInterfaz().fechaField.getText();

        if (fechaTexto == null || fechaTexto.trim().isEmpty()) {
            return;
        }

        fechadefabricacion = LocalDate.parse(fechaTexto, formatoFecha);

        nombre = this.fachadagrafica.getInterfaz().nombreProductoField.getText();
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío.");
        }

        precio = Double.parseDouble(this.fachadagrafica.getInterfaz().precioField.getText());
        cantidadproducto = Integer.parseInt(this.fachadagrafica.getInterfaz().cantidadField.getText());

        String tipoEmbalajeName = this.fachadagrafica.getInterfaz().tipoEmbalaje.getToolTipText().toUpperCase();
        tipoembalaje = Tipoembalaje.valueOf(tipoEmbalajeName);

        nombreproveedor = this.fachadagrafica.getInterfaz().proveedorNombreField.getText();
        marcaproveedor = this.fachadagrafica.getInterfaz().proveedorMarcaField.getText();
        correoproveedor = this.fachadagrafica.getInterfaz().proveedorCorreoField.getText();
        direccionproveedor = this.fachadagrafica.getInterfaz().proveedorDireccionField.getText();
        tipo = this.fachadagrafica.getInterfaz().tipoField.getText();

        this.controlproductos.crearProductosnoperecederos(fechadefabricacion, nombre, precio, cantidadproducto, tipoembalaje, nombreproveedor, marcaproveedor, correoproveedor, direccionproveedor, tipo);
        this.controlproductos.crearProductos(fechadefabricacion, nombre, precio, cantidadproducto, tipoembalaje, nombreproveedor, marcaproveedor, correoproveedor, direccionproveedor);
    }

    public String listadosProductos() {
        String alpha = this.controlproductos.mostrarProductosperecederos();
        String beta = this.controlproductos.mostrarProductossemiperecederos();
        String omega = this.controlproductos.mostrarProductosnoperecederos();

        if (alpha.isEmpty() && beta.isEmpty() && omega.isEmpty()) {
            this.fachadagrafica.getInterfaz().mostrarPanel("No productos");
            return "";
        }

        String delta = alpha + "\n" + beta + "\n" + omega;
        return delta;
    }

    public void cambiarExistencias() {
        String nombre = this.fachadagrafica.getInterfaz().nombreProductoField.getText();
        String marca = this.fachadagrafica.getInterfaz().proveedorMarcaField.getText();
        String operacion = (String) this.fachadagrafica.getInterfaz().operacionComboBox.getSelectedItem();

        if (operacion == null || (!operacion.equalsIgnoreCase("Adicionar") && !operacion.equalsIgnoreCase("Restar"))) {
            return;
        }

        String cantidadTexto = this.fachadagrafica.getInterfaz().cantidadProductoField.getText();
        if (cantidadTexto == null || cantidadTexto.trim().isEmpty()) {
            return;
        }

        int cantidadproducto;
        cantidadproducto = Integer.parseInt(cantidadTexto);
        this.controlproductos.cambiarExistencias(nombre, marca, cantidadproducto, operacion);
    }

    public void eliminarProducto() {
        String nombre = this.fachadagrafica.getInterfaz().nombreProductoField.getText();
        String marca = this.fachadagrafica.getInterfaz().proveedorMarcaField.getText();
        this.controlproductos.eliminarProducto(nombre, marca);
    }

    public ControlProductos getControlproductos() {
        return controlproductos;
    }

    public void cambiarExistencias2() {
        String nombre = this.fachadagrafica.getInterfaz().nombreProductoField.getText();
        String marca = this.fachadagrafica.getInterfaz().proveedorMarcaField.getText();
        String operacion = "Restar";

        String cantidadTexto = this.fachadagrafica.getInterfaz().cantidadProductoField.getText();
        if (cantidadTexto == null || cantidadTexto.trim().isEmpty()) {
            return;
        }

        int cantidadproducto;
        cantidadproducto = Integer.parseInt(cantidadTexto);
        this.controlproductos.cambiarExistencias(nombre, marca, cantidadproducto, operacion);
    }

    public void panelmostrar(String n) {
        this.fachadagrafica.getInterfaz().mostrarPanel(n);
    }

    public ControlCheckout getControlcheckout() {
        return controlcheckout;
    }

    public void saldoMaquina() {
        String nombre = this.fachadagrafica.getInterfaz().nombreProductoField.getText();
        String marca = this.fachadagrafica.getInterfaz().proveedorMarcaField.getText();
        this.controlproductos.buscarProducto(nombre, marca);
    }

    public void trump(String total, double precio, int porcentajedeagua, String nombre, String marca) {
        double pagado = Double.parseDouble(this.fachadagrafica.getInterfaz().pagadoField.getText());
        int cantidad = Integer.parseInt(this.fachadagrafica.getInterfaz().cantidadProductoField.getText());
        this.controlcheckout.descuentos(total, precio, porcentajedeagua, pagado, cantidad);

    }

    public FachadaGrafica getFachadagrafica() {
        return fachadagrafica;
    }

}
