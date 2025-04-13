package org.uniquindio.edu.co.poo.model;

import java.util.List; 

public class Tienda {

    private String nombre;
    private String direccion;
    private List<Producto> productos;
    private List<Cliente> clientes;
    private List<Factura> facturas;

    

    public Tienda(String nombre, String direccion, List<Producto> productos, List<Cliente> clientes, List<Factura> facturas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.productos = productos;
        this.clientes = clientes;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }


    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public String agregarProducto(Producto producto) {
        for (Producto p : productos) {
            if (p.getCodigo().equals(producto.getCodigo())) {
                return "El producto ya existe en la tienda.";
            }
        }
        productos.add(producto);
        return "Producto agregado: " + producto.toString();
    }
    public String actualizarProducto (String codigo, String nombre, double precio, int stock, String categoria) {
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                producto.setNombre(nombre);
                producto.setPrecio(precio);
                producto.setStock(stock);
                producto.setCategoria(categoria);
                return "Producto actualizado: " + producto.toString();
            }
        }
        return "Producto no encontrado";
    }

    public String registrarCliente(String nombre, String cedula, String direccion, String telefono, String email) {
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                return "ERROR: El cliente con cédula " + cedula + " ya está registrado.";
            }
        }
        Cliente nuevoCliente = new Cliente(nombre, cedula, direccion, telefono, email);
        clientes.add(nuevoCliente);
        return "Cliente registrado con éxito: " + nuevoCliente.toString();
    }

    

    public String mostrarInformacionCompleta() {
        StringBuilder info = new StringBuilder();
        info.append("Información de la Tienda:\n");
        info.append("Nombre: ").append(nombre).append("\n");
        info.append("Dirección: ").append(direccion).append("\n\n");

        info.append("Productos:\n");
        for (Producto producto : productos) {
            info.append("- ").append(producto.getNombre())
                .append(" (Código: ").append(producto.getCodigo())
                .append(", Precio: ").append(producto.getPrecio())
                .append(", Stock: ").append(producto.getStock())
                .append(", Categoría: ").append(producto.getCategoria())
                .append(")\n");
        }

        info.append("\nClientes y sus Facturas:\n");
        for (Cliente cliente : clientes) {
            info.append("- Cliente: ").append(cliente.getNombre())
                .append(" (Cédula: ").append(cliente.getCedula())
                .append(", Dirección: ").append(cliente.getDireccion())
                .append(", Teléfono: ").append(cliente.getTelefono())
                .append(", Email: ").append(cliente.getEmail())
                .append(")\n");

            List<Factura> facturasCliente = cliente.getFacturas();
            if (facturasCliente != null && !facturasCliente.isEmpty()) {
                for (Factura factura : facturasCliente) {
                    info.append("  * Factura Código: ").append(factura.getCodigo())
                        .append(", Total: ").append(factura.getTotalFactura())
                        .append("\n    Ventas:\n");
                    for (Venta venta : factura.getVentas()) {
                        Producto producto = venta.getProducto();
                        info.append("      - Producto: ").append(producto.getNombre())
                            .append(" (Cantidad: ").append(venta.getCantidadProducto())
                            .append(", Precio Unitario: ").append(producto.getPrecio())
                            .append(", Subtotal: ").append(producto.getPrecio() * venta.getCantidadProducto())
                            .append(")\n");
                    }
                }
            } else {
                info.append("  * No tiene facturas registradas.\n");
            }
        }

        return info.toString();
    }

  
}
