package Control;

import Modelo.Noperecederos;
import Modelo.Perecederos;
import Modelo.Producto;
import Modelo.Producto.Tipoembalaje;
import Modelo.Proveedor;
import Modelo.Semiperecederos;
import java.time.LocalDate;
import java.util.ArrayList;

public class ControlProductos {

    private ArrayList<Perecederos> productosperecederos;
    private ArrayList<Semiperecederos> productossemiperecederos;
    private ArrayList<Noperecederos> productosnoperecederos;
    private ArrayList<Producto> producto;
    private FachadaLogica fachadalogica;

    public ControlProductos(FachadaLogica fachadalogica) {
        this.productosperecederos = new ArrayList<Perecederos>();
        this.productossemiperecederos = new ArrayList<Semiperecederos>();
        this.productosnoperecederos = new ArrayList<Noperecederos>();
        this.producto = new ArrayList<Producto>();
        this.fachadalogica = fachadalogica;
    }

    public void crearProductoperecedero(LocalDate fechadefabricacion, String nombre, double precio, int cantidadproducto, Tipoembalaje tipoembalaje, String nombreproveedor, String marcaproveedor, String correoproveedor, String direccionproveedor, int diascaducar) {
        Perecederos perecederos = new Perecederos(diascaducar, fechadefabricacion, nombre, new Proveedor(nombreproveedor, marcaproveedor, correoproveedor, direccionproveedor), precio, cantidadproducto, tipoembalaje);
        productosperecederos.add(perecederos);
    }

    public void crearProductosemiperecedero(LocalDate fechadefabricacion, String nombre, double precio, int cantidadproducto, Tipoembalaje tipoembalaje, String nombreproveedor, String marcaproveedor, String correoproveedor, String direccionproveedor, int porcentajeagua) {
        Semiperecederos semiperecederos = new Semiperecederos(porcentajeagua, fechadefabricacion, nombre, new Proveedor(nombreproveedor, marcaproveedor, correoproveedor, direccionproveedor), precio, cantidadproducto, tipoembalaje);
        productossemiperecederos.add(semiperecederos);
    }

    public void crearProductosnoperecederos(LocalDate fechadefabricacion, String nombre, double precio, int cantidadproducto, Tipoembalaje tipoembalaje, String nombreproveedor, String marcaproveedor, String correoproveedor, String direccionproveedor, String tipo) {
        Noperecederos noperecederos = new Noperecederos(tipo, fechadefabricacion, nombre, new Proveedor(nombreproveedor, marcaproveedor, correoproveedor, direccionproveedor), precio, cantidadproducto, tipoembalaje);
        productosnoperecederos.add(noperecederos);
    }

    public void crearProductos(LocalDate fechadefabricacion, String nombre, double precio, int cantidadproducto, Tipoembalaje tipoembalaje, String nombreproveedor, String marcaproveedor, String correoproveedor, String direccionproveedor) {
        Producto productos = new Producto(fechadefabricacion, nombre, new Proveedor(nombreproveedor, marcaproveedor, correoproveedor, direccionproveedor), precio, cantidadproducto, tipoembalaje);
        producto.add(productos);
    }

    public String mostrarProductosperecederos() {
        StringBuilder resultado = new StringBuilder("Productos Perecederos:\n");
        for (Perecederos p : productosperecederos) {
            resultado.append(p.toString()).append("\n");
        }
        return resultado.toString();
    }

    public String mostrarProductossemiperecederos() {
        StringBuilder resultado = new StringBuilder("Productos Semiperecederos:\n");
        for (Semiperecederos s : productossemiperecederos) {
            resultado.append(s.toString()).append("\n");
        }
        return resultado.toString();
    }

    public String mostrarProductosnoperecederos() {
        StringBuilder resultado = new StringBuilder("Productos No Perecederos:\n");
        for (Noperecederos n : productosnoperecederos) {
            resultado.append(n.toString()).append("\n");
        }
        return resultado.toString();
    }

    public void cambiarExistencias(String nombre, String marca, int cantidadproducto, String operacion) {
        for (Perecederos p : productosperecederos) {
            if (p.getNombre().equalsIgnoreCase(nombre) && p.getProveedor().getMarcaproveedor().equalsIgnoreCase(marca)) {
                if (operacion.equalsIgnoreCase("Adicionar")) {
                    int cantidadActual = p.getCantidadproducto();
                    p.setCantidadproducto(cantidadActual + cantidadproducto);
                } else {
                    int cantidadActual = p.getCantidadproducto();
                    int nuevaCantidad = cantidadActual - cantidadproducto;
                    p.setCantidadproducto(Math.max(nuevaCantidad, 0));
                }
            }
        }

        for (Semiperecederos s : productossemiperecederos) {
            if (s.getNombre().equalsIgnoreCase(nombre) && s.getProveedor().getMarcaproveedor().equalsIgnoreCase(marca)) {
                if (operacion.equalsIgnoreCase("Adicionar")) {
                    int cantidadActual = s.getCantidadproducto();
                    s.setCantidadproducto(cantidadActual + cantidadproducto);
                } else {
                    int cantidadActual = s.getCantidadproducto();
                    int nuevaCantidad = cantidadActual - cantidadproducto;
                    s.setCantidadproducto(Math.max(nuevaCantidad, 0));
                }
            }
        }

        for (Noperecederos n : productosnoperecederos) {
            if (n.getNombre().equalsIgnoreCase(nombre) && n.getProveedor().getMarcaproveedor().equalsIgnoreCase(marca)) {
                if (operacion.equalsIgnoreCase("Adicionar")) {
                    int cantidadActual = n.getCantidadproducto();
                    n.setCantidadproducto(cantidadActual + cantidadproducto);
                } else {
                    int cantidadActual = n.getCantidadproducto();
                    int nuevaCantidad = cantidadActual - cantidadproducto;
                    n.setCantidadproducto(Math.max(nuevaCantidad, 0));
                }
            }
        }
    }

    public void eliminarProducto(String nombre, String marca) {
        productosperecederos.removeIf(p -> p.getNombre().equalsIgnoreCase(nombre) && p.getProveedor().getMarcaproveedor().equalsIgnoreCase(marca));
        productossemiperecederos.removeIf(s -> s.getNombre().equalsIgnoreCase(nombre) && s.getProveedor().getMarcaproveedor().equalsIgnoreCase(marca));
        productosnoperecederos.removeIf(n -> n.getNombre().equalsIgnoreCase(nombre) && n.getProveedor().getMarcaproveedor().equalsIgnoreCase(marca));
    }

    public ArrayList<Producto> getProducto() {
        return producto;
    }

    public void buscarProducto(String nombre, String marca) {
        for (Perecederos p : productosperecederos) {
            if (p.getNombre().equalsIgnoreCase(nombre) && p.getProveedor().getMarcaproveedor().equalsIgnoreCase(marca)) {
                String total = "Perecedero";
               double precio = p.getPrecio();
               int Diasperecederos = p.getDiascaducar();
               this.fachadalogica.trump(total, precio, Diasperecederos, nombre, marca);
               
            }
            for (Noperecederos np : productosnoperecederos) {
                if (np.getNombre().equalsIgnoreCase(nombre) && np.getProveedor().getMarcaproveedor().equalsIgnoreCase(marca)) {
                     double precio = np.getPrecio();
                     String tipo = np.getTipo();
                     int h = 0;
                    this.fachadalogica.trump(tipo, precio, h, nombre, marca);
                }
            }

            for (Semiperecederos sp : productossemiperecederos) {
                if (sp.getNombre().equalsIgnoreCase(nombre) && sp.getProveedor().getMarcaproveedor().equalsIgnoreCase(marca)) {
                     String total = "semiPerecedero";
                   double precio = sp.getPrecio();
                   int porcentajedeagua = sp.getPorcentajeagua();
                   this.fachadalogica.trump(total, precio, porcentajedeagua, nombre, marca);
                }
            }
           
        }
    }    
}