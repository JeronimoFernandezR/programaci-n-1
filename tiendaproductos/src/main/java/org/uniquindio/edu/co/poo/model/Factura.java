package org.uniquindio.edu.co.poo.model;

import java.util.List;

public class Factura {
    private String codigo;
    private Cliente cliente;
    private List<Venta> ventas;
    private double totalFactura;

    
    public Factura(String codigo ,Cliente cliente, List<Venta> ventas) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.ventas = ventas;
        this.totalFactura = calcularTotalFactura();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public double getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(double totalFactura) {
        this.totalFactura = totalFactura;
    }

    
    private double calcularTotalFactura() {
        double total = 0;
        for (Venta venta : ventas) {
            total += venta.getProducto().getPrecio();
        }
        return total;
    }
    public String buscarProducto(String codigo) {
        for (Venta venta : ventas) {
            if (venta.getProducto().getCodigo().equals(codigo)) {
                return venta.getProducto().getNombre();
            }
        }
        return null;
    }
    public String agregarProducto(Venta venta, String codigo) {
        String nombreProducto = buscarProducto(codigo);
        String mensaje;
        if (nombreProducto != null) {
            mensaje = "ERROR: el producto " + nombreProducto + " ya está registrado en la factura";
            return mensaje;
        } else {
            Producto producto = venta.getProducto();
            int cantidadProducto = venta.getCantidadProducto(); 
            if (producto.getStock() >= cantidadProducto) {
                ventas.add(venta);
                producto.setStock(producto.getStock() - cantidadProducto); 
                totalFactura = calcularTotalFactura();
                mensaje = "El producto " + producto.getNombre() + " ha sido agregado a la factura";
                return mensaje;
            } else {
                mensaje = "ERROR: No hay suficiente stock del producto " + producto.getNombre();
                return mensaje;
            }
        }
    }

    public String eliminarProducto(String codigo) {
        String nombreProducto = buscarProducto(codigo);
        if (nombreProducto != null) {
            for (Venta venta : ventas) {
                if (venta.getProducto().getCodigo().equals(codigo)) {
                    ventas.remove(venta);
                    venta.getProducto().setStock(venta.getProducto().getStock() + venta.getCantidadProducto());
                    totalFactura = calcularTotalFactura();
                    return "El producto " + nombreProducto + " ha sido eliminado de la factura";
                }
            }
        } else {
            return "ERROR: No se encontró un producto con el código " + codigo;
        }
        return null;
    }
}
