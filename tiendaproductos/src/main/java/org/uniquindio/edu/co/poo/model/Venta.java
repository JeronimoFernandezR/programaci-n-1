package org.uniquindio.edu.co.poo.model;

public class Venta {

    private String fechaVenta;
    private Producto producto;
    private int cantidadProducto;

    
    public Venta(String fechaVenta, Producto producto, int cantidadProducto) {
        this.fechaVenta = fechaVenta;
        this.producto = producto;
        this.cantidadProducto = cantidadProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

  
    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Venta{");
        sb.append("fechaVenta=").append(fechaVenta);
        sb.append(", producto=").append(producto);
        sb.append(", cantidadProducto=").append(cantidadProducto);
        sb.append('}');
        return sb.toString();
    }

    

}
