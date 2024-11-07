package Vista;

import javax.swing.*;
import java.awt.*;
import Control.FachadaGrafica;

import java.util.Map;

public class Interfaz extends JFrame {

    private FachadaGrafica fachadagrafica;

    private JPanel mainPanel;
    private CardLayout cardLayout;

    public JButton botonComprarCliente;
    public JButton botonAgregarProductos;
    public JButton botoncargarnuevoproducto;
    public JButton botonCambiarCantidadExistencia;
    public JButton botonEliminarProductos;
    public JButton botonEnviarDatosProductoPerecederos;
    public JButton botonEnviarDatosProductoSemiperecederos;
    public JButton botonEnviarDatosProductoNoperecederos;
    public JButton botonproductoperesedero;
    public JButton botonproductosemiperesedero;
    public JButton botonproductonoperesedero;
    public JButton botonvolveralinicio;
    public JButton botonbuscar;
    public Map<String, JSpinner> cantidadSpinners;
    public Map<String, String> marcas;
    public JButton botonEliminar;
    public JButton botonPagar;
    public JButton botonSalir1;
    public JButton botonSalir2;
    public JButton botonSalir3;
    public JButton botonSalir4;
    public JButton botonSalir5;
    public JButton botonSalir6;
    public JButton botonRegresar;

    public JTextField fechaField;
    public JTextField nombreProductoField;
    public JTextField proveedorNombreField;
    public JTextField proveedorMarcaField;
    public JTextField proveedorCorreoField;
    public JTextField proveedorDireccionField;
    public JTextField cantidadField;
    public JTextField precioField;
    public JTextField diascaducadosField;
    public JTextField semiperecederosField;
    public JTextField tipoField;
    public JTextField cantidadProductoField;
    public JTextField pagadoField;

    private JLabel labelvueltas;
    private JLabel devueltadinero;

    public JComboBox tipoEmbalaje;
    public JComboBox<String> operacionComboBox;

    public Interfaz(String title, FachadaGrafica fachadaGrafica) {
        super(title);

        this.fachadagrafica = fachadaGrafica;

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    public void mainPanels() {

        JPanel crearProductoperecedero = crearProductoperecedero();
        JPanel crearProductosemiperecedero = crearProductosemiperecedero();
        JPanel crearProductosnoperecedero = crearProductosnoperecedero();
        JPanel cambiarexistencias = cambiarExistencias();
        JPanel listasproductos = mostrarProductos();
        JPanel eliminar = PanelEliminarProducto();
        JPanel pantallaInicial = crearPantallaInicial();
        JPanel inicioPanel = crearInicioPanel();
        JPanel seleccionTipoProductoPanel = seleccionTiproducto();
        JPanel fin = Fin();
        JPanel panelfinal = panelfinal(0, "");
        JPanel vueltasPanel = vueltas(0, "", 0, 0, 0, 0);
        JPanel devueltasDineroPanel = devueltasDinero(0, "", 0, 0, 0, 0);
        JPanel pagadoexactoPanel = pagadoexacto("", 0, 0, 0, 0);
        JPanel panelSinProductos = panelSinProductos();

        mainPanel.add(pantallaInicial, "Pantalla Inicial");
        mainPanel.add(inicioPanel, "Inicio");
        mainPanel.add(seleccionTipoProductoPanel, "SeleccionTipoProducto");
        mainPanel.add(crearProductoperecedero, "CargarProductoPerecedero");
        mainPanel.add(crearProductosemiperecedero, "CargarProductoSemiperecedero");
        mainPanel.add(crearProductosnoperecedero, "CargarProductoNoperecedero");
        mainPanel.add(cambiarexistencias, "Cambiarexistencias");
        mainPanel.add(listasproductos, "Mostrarproductos");
        mainPanel.add(eliminar, "Eliminar");
        mainPanel.add(fin, "Sair total2");
        mainPanel.add(panelfinal, "Panelfinal");
        mainPanel.add(vueltasPanel, "Vueltas");
        mainPanel.add(devueltasDineroPanel, "DevueltaDinero");
        mainPanel.add(pagadoexactoPanel, "PagadoExacto");
        mainPanel.add(panelSinProductos, "No productos");

        add(mainPanel);
        setVisible(true);
    }

    public JPanel crearPantallaInicial() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel etiquetaInicial = new JLabel("¿Qué desea hacer?", SwingConstants.CENTER);

        etiquetaInicial.setFont(new Font("Arial", Font.BOLD, 16));
        etiquetaInicial.setOpaque(true);
        etiquetaInicial.setBackground(Color.LIGHT_GRAY);
        etiquetaInicial.setForeground(Color.BLACK);
        panel.add(etiquetaInicial, BorderLayout.NORTH);

        botonComprarCliente = new JButton("Soy cliente voy a comprar");
        botonComprarCliente.setPreferredSize(new Dimension(200, 50));
        botonComprarCliente.setActionCommand("Soy cliente voy a comprar");

        botonAgregarProductos = new JButton("Agregar productos a la tienda");
        botonAgregarProductos.setPreferredSize(new Dimension(200, 50));
        botonAgregarProductos.setActionCommand("Agregar productos a la tienda");

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        buttonPanel.add(botonComprarCliente);
        buttonPanel.add(botonAgregarProductos);

        panel.add(buttonPanel, BorderLayout.CENTER);

        return panel;
    }

    public JPanel crearInicioPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel preguntainicial = new JLabel("Bienvenido, ¿Desea cargar algún producto para el día de hoy?", SwingConstants.CENTER);
        preguntainicial.setFont(new Font("Arial", Font.BOLD, 16));
        preguntainicial.setOpaque(true);
        preguntainicial.setBackground(Color.LIGHT_GRAY);
        preguntainicial.setForeground(Color.BLACK);
        panel.add(preguntainicial, BorderLayout.NORTH);

        botoncargarnuevoproducto = new JButton("Sí, deseo cargar nuevos productos");
        botoncargarnuevoproducto.setActionCommand("Sí, deseo cargar nuevos productos");
        botoncargarnuevoproducto.setForeground(Color.BLUE);

        botonCambiarCantidadExistencia = new JButton("Sí, cambiar cantidad de existencia");
        botonCambiarCantidadExistencia.setActionCommand("Cambiar cantidad de existencia");
        botonCambiarCantidadExistencia.setForeground(Color.BLUE);

        botonEliminarProductos = new JButton("Sí, eliminar productos");
        botonEliminarProductos.setActionCommand("Eliminar productos");
        botonEliminarProductos.setForeground(Color.BLUE);

        botonvolveralinicio = new JButton("Volver al inicio");
        botonvolveralinicio.setActionCommand("Volver al inicio");
        botonvolveralinicio.setForeground(Color.RED);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        buttonPanel.add(botoncargarnuevoproducto);
        buttonPanel.add(botonCambiarCantidadExistencia);
        buttonPanel.add(botonEliminarProductos);
        buttonPanel.add(botonvolveralinicio);
        panel.add(buttonPanel, BorderLayout.CENTER);

        return panel;
    }

    public JPanel crearProductoperecedero() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("En cuántos días caduca el producto"), gbc);

        gbc.gridx = 1;
        diascaducadosField = new JTextField(10);
        panel.add(diascaducadosField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Digite la fecha en formato DD/MM/AAAA"), gbc);

        gbc.gridx = 1;
        fechaField = new JTextField(10);
        panel.add(fechaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Nombre del producto"), gbc);

        gbc.gridx = 1;
        nombreProductoField = new JTextField(10);
        panel.add(nombreProductoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Precio unitario"), gbc);

        gbc.gridx = 1;
        precioField = new JTextField(10);
        panel.add(precioField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Cantidad"), gbc);

        gbc.gridx = 1;
        cantidadField = new JTextField(10);
        panel.add(cantidadField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Tipo de embalaje"), gbc);

        gbc.gridx = 1;
        tipoEmbalaje = new JComboBox<>(new String[]{
            "Botella Vidrio", "Tarro Plástico", "Tarrina", "Lata", "Tarro Cristal", "Caja Cartón"
        });
        panel.add(tipoEmbalaje, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        panel.add(new JLabel("Datos del proveedor"), gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(new JLabel("Nombre del proveedor"), gbc);

        gbc.gridx = 1;
        proveedorNombreField = new JTextField(10);
        panel.add(proveedorNombreField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(new JLabel("Marca del producto"), gbc);

        gbc.gridx = 1;
        proveedorMarcaField = new JTextField(10);
        panel.add(proveedorMarcaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        panel.add(new JLabel("Correo del proveedor"), gbc);

        gbc.gridx = 1;
        proveedorCorreoField = new JTextField(10);
        panel.add(proveedorCorreoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        panel.add(new JLabel("Dirección del proveedor"), gbc);

        gbc.gridx = 1;
        proveedorDireccionField = new JTextField(10);
        panel.add(proveedorDireccionField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 2;

        botonEnviarDatosProductoPerecederos = new JButton("Enviar Datos Del Producto");
        botonEnviarDatosProductoPerecederos.setActionCommand("Enviar Datos Del Producto Perecedero");
        botonEnviarDatosProductoPerecederos.setForeground(Color.BLUE);

        panel.add(botonEnviarDatosProductoPerecederos, gbc);

        this.fachadagrafica.getFachadalogica().crearProductoperecedero();
        return panel;
    }

    public JPanel seleccionTiproducto() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel preguntainicial = new JLabel("Seleccione el tipo de producto", SwingConstants.CENTER);
        preguntainicial.setFont(new Font("Arial", Font.BOLD, 16));
        preguntainicial.setOpaque(true);
        preguntainicial.setBackground(Color.LIGHT_GRAY);
        preguntainicial.setForeground(Color.BLACK);
        panel.add(preguntainicial, BorderLayout.NORTH);

        botonproductoperesedero = new JButton("Producto Perecedero");
        botonproductoperesedero.setActionCommand("Producto Perecedero");
        botonproductoperesedero.setForeground(Color.BLUE);

        botonproductosemiperesedero = new JButton("Producto Semiperecedero");
        botonproductosemiperesedero.setActionCommand("Producto Semiperecedero");
        botonproductosemiperesedero.setForeground(Color.BLUE);

        botonproductonoperesedero = new JButton("Producto No Perecedero");
        botonproductonoperesedero.setActionCommand("Producto No Perecedero");
        botonproductonoperesedero.setForeground(Color.BLUE);

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        buttonPanel.add(botonproductoperesedero);
        buttonPanel.add(botonproductosemiperesedero);
        buttonPanel.add(botonproductonoperesedero);
        panel.add(buttonPanel, BorderLayout.CENTER);

        return panel;
    }

    public JPanel crearProductosemiperecedero() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Que porcentaje de agua tiene el producto "), gbc);

        gbc.gridx = 1;
        semiperecederosField = new JTextField(10);
        panel.add(semiperecederosField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Digite la fecha en formato DD/MM/AAAA"), gbc);

        gbc.gridx = 1;
        fechaField = new JTextField(10);
        panel.add(fechaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Nombre del producto"), gbc);

        gbc.gridx = 1;
        nombreProductoField = new JTextField(10);
        panel.add(nombreProductoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Precio unitario"), gbc);

        gbc.gridx = 1;
        precioField = new JTextField(10);
        panel.add(precioField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Cantidad"), gbc);

        gbc.gridx = 1;
        cantidadField = new JTextField(10);
        panel.add(cantidadField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Tipo de embalaje"), gbc);

        gbc.gridx = 1;
        tipoEmbalaje = new JComboBox<>(new String[]{
            "Botella Vidrio", "Tarro Plástico", "Tarrina", "Lata", "Tarro Cristal", "Caja Cartón"
        });
        panel.add(tipoEmbalaje, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        panel.add(new JLabel("Datos del proveedor"), gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(new JLabel("Nombre del proveedor"), gbc);

        gbc.gridx = 1;
        proveedorNombreField = new JTextField(10);
        panel.add(proveedorNombreField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(new JLabel("Marca del producto"), gbc);

        gbc.gridx = 1;
        proveedorMarcaField = new JTextField(10);
        panel.add(proveedorMarcaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        panel.add(new JLabel("Correo del proveedor"), gbc);

        gbc.gridx = 1;
        proveedorCorreoField = new JTextField(10);
        panel.add(proveedorCorreoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        panel.add(new JLabel("Dirección del proveedor"), gbc);

        gbc.gridx = 1;
        proveedorDireccionField = new JTextField(10);
        panel.add(proveedorDireccionField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 2;

        botonEnviarDatosProductoSemiperecederos = new JButton("Enviar Datos Del Producto");
        botonEnviarDatosProductoSemiperecederos.setActionCommand("Enviar Datos Del Producto Semiperecedero");
        botonEnviarDatosProductoSemiperecederos.setForeground(Color.BLUE);

        panel.add(botonEnviarDatosProductoSemiperecederos, gbc);

        this.fachadagrafica.getFachadalogica().crearProductossemiperecedero();
        return panel;
    }

    public JPanel crearProductosnoperecedero() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Que tipo de producto "), gbc);

        gbc.gridx = 1;
        tipoField = new JTextField(10);
        panel.add(tipoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Digite la fecha en formato DD/MM/AAAA"), gbc);

        gbc.gridx = 1;
        fechaField = new JTextField(10);
        panel.add(fechaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Nombre del producto"), gbc);

        gbc.gridx = 1;
        nombreProductoField = new JTextField(10);
        panel.add(nombreProductoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Precio unitario"), gbc);

        gbc.gridx = 1;
        precioField = new JTextField(10);
        panel.add(precioField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Cantidad"), gbc);

        gbc.gridx = 1;
        cantidadField = new JTextField(10);
        panel.add(cantidadField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Tipo de embalaje"), gbc);

        gbc.gridx = 1;
        tipoEmbalaje = new JComboBox<>(new String[]{
            "Botella Vidrio", "Tarro Plástico", "Tarrina", "Lata", "Tarro Cristal", "Caja Cartón"
        });
        panel.add(tipoEmbalaje, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        panel.add(new JLabel("Datos del proveedor"), gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(new JLabel("Nombre del proveedor"), gbc);

        gbc.gridx = 1;
        proveedorNombreField = new JTextField(10);
        panel.add(proveedorNombreField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(new JLabel("Marca del producto"), gbc);

        gbc.gridx = 1;
        proveedorMarcaField = new JTextField(10);
        panel.add(proveedorMarcaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        panel.add(new JLabel("Correo del proveedor"), gbc);

        gbc.gridx = 1;
        proveedorCorreoField = new JTextField(10);
        panel.add(proveedorCorreoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        panel.add(new JLabel("Dirección del proveedor"), gbc);

        gbc.gridx = 1;
        proveedorDireccionField = new JTextField(10);
        panel.add(proveedorDireccionField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 2;

        botonEnviarDatosProductoNoperecederos = new JButton("Enviar Datos Del Producto");
        botonEnviarDatosProductoNoperecederos.setActionCommand("Enviar Datos Del Producto Noperecedero");
        botonEnviarDatosProductoNoperecederos.setForeground(Color.BLUE);

        panel.add(botonEnviarDatosProductoNoperecederos, gbc);

        this.fachadagrafica.getFachadalogica().crearProductonoperecedero();
        return panel;
    }

    public JPanel cambiarExistencias() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Nombre del producto"), gbc);

        gbc.gridx = 1;
        nombreProductoField = new JTextField(10);
        panel.add(nombreProductoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Marca del producto"), gbc);

        gbc.gridx = 1;
        proveedorMarcaField = new JTextField(10);
        panel.add(proveedorMarcaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Cantidad del producto"), gbc);

        gbc.gridx = 1;
        cantidadProductoField = new JTextField(10);
        panel.add(cantidadProductoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Operación"), gbc);

        gbc.gridx = 1;
        operacionComboBox = new JComboBox<>(new String[]{"Adicionar", "Restar"});
        panel.add(operacionComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;

        botonbuscar = new JButton("Buscar y cambiar existencias");
        botonbuscar.setActionCommand("Cambiar existencias");
        botonbuscar.setForeground(Color.BLUE);

        panel.add(botonbuscar, gbc);

        this.fachadagrafica.getFachadalogica().cambiarExistencias();
        return panel;
    }

    public JPanel mostrarProductos() {

        String delta = this.fachadagrafica.getFachadalogica().listadosProductos();

        JTextArea textArea = new JTextArea(delta);
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        textArea.setRows(20);
        textArea.setColumns(50);
        scrollPane.setPreferredSize(textArea.getPreferredSize());

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(scrollPane, gbc);

        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Nombre del producto"), gbc);

        gbc.gridx = 1;
        nombreProductoField = new JTextField(10);
        panel.add(nombreProductoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Marca del producto"), gbc);

        gbc.gridx = 1;
        proveedorMarcaField = new JTextField(10);
        panel.add(proveedorMarcaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Cantidad de productos:"), gbc);

        gbc.gridx = 1;
        cantidadProductoField = new JTextField(10);
        cantidadProductoField.setForeground(Color.RED);
        panel.add(cantidadProductoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Con cuanto va a cancelar"), gbc);

        gbc.gridx = 1;
        pagadoField = new JTextField(10);
        panel.add(pagadoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        botonSalir6 = new JButton("Salir");
        botonSalir6.setActionCommand("Salir total");
        botonSalir6.setForeground(Color.RED);
        panel.add(botonSalir6, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        botonPagar = new JButton("Pagar Producto");
        botonPagar.setActionCommand("Pagar Producto");
        botonPagar.setForeground(Color.RED);
        panel.add(botonPagar, gbc);

        int numeroDeTickets = this.fachadagrafica.getFachadalogica().getControlcheckout().numerodeTickets();
        this.fachadagrafica.getFachadalogica().getControlcheckout().generarTickets(numeroDeTickets);

        return panel;
    }

    public JPanel PanelEliminarProducto() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Nombre del producto"), gbc);

        gbc.gridx = 1;
        nombreProductoField = new JTextField(10);
        panel.add(nombreProductoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Marca del producto"), gbc);

        gbc.gridx = 1;
        proveedorMarcaField = new JTextField(10);
        panel.add(proveedorMarcaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;

        botonEliminar = new JButton("Eliminar Producto");
        botonEliminar.setActionCommand("Eliminar Producto");
        botonEliminar.setForeground(Color.RED);
        panel.add(botonEliminar, gbc);

        return panel;
    }

    public void mostrarPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }

    public JPanel Fin() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        botonSalir5 = new JButton("Salir");
        botonSalir5.setActionCommand("Salir, fin");
        botonSalir5.setForeground(Color.RED);
        panel.add(botonSalir5, gbc);

        return panel;
    }

    public JPanel vueltas(double vueltas, String tipoProducto, double precio, double descuento, double pagado, int cantidad) {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel labelInfo = new JLabel("Producto: " + tipoProducto + "<br>"
                + "Cantidad: " + cantidad + "<br>"
                + "Valor de compra: " + (precio * cantidad) + "<br>"
                + "Descuento aplicado: " + descuento + "<br>"
                + "Valor ingresado: " + pagado + "<br>"
                + "Vueltas generadas: " + vueltas);
        labelInfo.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(labelInfo, gbc);

        botonSalir4 = new JButton("Salir");
        botonSalir4.setActionCommand("Mostrar saldo final");
        botonSalir4.setForeground(Color.RED);
        gbc.gridy = 1;
        panel.add(botonSalir4, gbc);

        return panel;
    }

    public JPanel devueltasDinero(double devueltadinero, String tipoProducto, double precio, double descuento, double pagado, int cantidad) {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel labelInfo = new JLabel("Producto: " + tipoProducto + "<br>"
                + "Cantidad: " + cantidad + "<br>"
                + "Valor de compra: " + (precio * cantidad) + "<br>"
                + "Descuento aplicado: " + descuento + "<br>"
                + "Valor ingresado: " + pagado + "<br>"
                + "No se puede realizar la compra, faltan: " + devueltadinero);
        labelInfo.setForeground(Color.BLUE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(labelInfo, gbc);

        botonSalir3 = new JButton("Salir");
        botonSalir3.setActionCommand("Compra terminada");
        botonSalir3.setForeground(Color.RED);
        gbc.gridy = 1;
        panel.add(botonSalir3, gbc);

        return panel;
    }

    public JPanel pagadoexacto(String tipoProducto, double precio, double descuento, double pagado, int cantidad) {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel labelInfo = new JLabel("Producto: " + tipoProducto + "<br>"
                + "Cantidad: " + cantidad + "<br>"
                + "Valor de compra: " + (precio * cantidad) + "<br>"
                + "Descuento aplicado: " + descuento + "<br>"
                + "Valor ingresado: " + pagado + "<br>"
                + "La compra fue pagada en su totalidad, no queda cambio.");
        labelInfo.setForeground(Color.BLUE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(labelInfo, gbc);

        botonSalir2 = new JButton("Salir");
        botonSalir2.setActionCommand("Compra terminada");
        botonSalir2.setForeground(Color.RED);
        gbc.gridy = 1;
        panel.add(botonSalir2, gbc);

        return panel;
    }

    public JPanel panelfinal(double saldo, String info) {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel labelSaldo = new JLabel("El saldo final de la máquina es: " + saldo);
        labelSaldo.setForeground(Color.BLUE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(labelSaldo, gbc);

        JLabel labelInfo = new JLabel("La información de los productos comprados es: " + info);
        labelInfo.setForeground(Color.BLACK);
        gbc.gridy = 1;
        panel.add(labelInfo, gbc);

        botonSalir1 = new JButton("Salir");
        botonSalir1.setActionCommand("Salir");
        botonSalir1.setForeground(Color.RED);
        gbc.gridy = 2;
        panel.add(botonSalir1, gbc);

        return panel;
    }

    public JPanel panelSinProductos() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel mensajeLabel = new JLabel("No hay productos cargados");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(mensajeLabel, gbc);

        botonRegresar = new JButton("Regresar");
        botonRegresar.setActionCommand("Volver al inicio");
        gbc.gridy = 1; 
        panel.add(botonRegresar, gbc);

        return panel;
    }
}
