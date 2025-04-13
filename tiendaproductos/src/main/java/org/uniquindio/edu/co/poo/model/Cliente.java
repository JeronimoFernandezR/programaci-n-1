package org.uniquindio.edu.co.poo.model;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String cedula;
    private String direccion;
    private String telefono;
    private String email;
    private List<Factura> facturas;

    public Cliente(String nombre, String cedula, String direccion, String telefono, String email) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.facturas = new ArrayList<>(); 
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private Factura buscarFactura(String codigo) {
        Factura facturaEncontrada = null;
        for (Factura facturaAux : facturas) {
            if (facturaAux.getCodigo().equals(codigo)) {
                facturaEncontrada = facturaAux;
            }
        }
        return  facturaEncontrada;
        
    }

    public String agregarFactura(Factura factura, String codigo, List<Venta> ventas) {
        Factura encontrado= buscarFactura(factura.getCodigo());
        String mensaje;
        if(encontrado != null){
            mensaje = "ERROR: la factura "+ encontrado.getCodigo() +" ya está registrada";
            return mensaje;
        }else{
            Factura nuevaFactura = new Factura(codigo, this, ventas);
            facturas.add(nuevaFactura);
            mensaje = "La factura " + nuevaFactura.getCodigo() + " ha sido registrada con éxito";
            return mensaje;
        }
    }

    public String eliminarFactura(String codigo) {
        Factura facturaAEliminar = buscarFactura(codigo);
        if (facturaAEliminar != null) {
            facturas.remove(facturaAEliminar);
            return "La factura " + codigo + " ha sido eliminada con éxito";
        } else {
            return "ERROR: No se encontró una factura con el código " + codigo;
        }
    }

   
   
    @Override
    public String toString() {
        return "Cliente [nombre=" + nombre + ", cedula=" + cedula + ", direccion=" + direccion + ", telefono="
                + telefono + ", email=" + email + "]";
    }

}