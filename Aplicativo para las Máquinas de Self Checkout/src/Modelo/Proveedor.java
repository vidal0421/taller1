
package Modelo;

public class Proveedor {
    
    private String nombreproveedor;
    private String marcaproveedor;
    private String correoproveedor;
    private String direccionproveedor;

    public Proveedor(String nombreproveedor, String marcaproveedor, String correoproveedor, String direccionproveedor) {
        this.nombreproveedor = nombreproveedor;
        this.marcaproveedor = marcaproveedor;
        this.correoproveedor = correoproveedor;
        this.direccionproveedor = direccionproveedor;
    }

    public String getNombreproveedor() {
        return nombreproveedor;
    }

    public void setNombreproveedor(String nombreproveedor) {
        this.nombreproveedor = nombreproveedor;
    }

    public String getMarcaproveedor() {
        return marcaproveedor;
    }

    public void setMarcaproveedor(String marcaproveedor) {
        this.marcaproveedor = marcaproveedor;
    }

    public String getCorreoproveedor() {
        return correoproveedor;
    }

    public void setCorreoproveedor(String correoproveedor) {
        this.correoproveedor = correoproveedor;
    }

    public String getDireccionproveedor() {
        return direccionproveedor;
    }

    public void setDireccionproveedor(String direccionproveedor) {
        this.direccionproveedor = direccionproveedor;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "nombreproveedor=" + nombreproveedor + ", marcaproveedor=" + marcaproveedor + ", correoproveedor=" + correoproveedor + ", direccionproveedor=" + direccionproveedor + '}';
    }
    
}
