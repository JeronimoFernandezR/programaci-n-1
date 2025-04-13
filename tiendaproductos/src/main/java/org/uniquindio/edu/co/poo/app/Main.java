package org.uniquindio.edu.co.poo.app;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.uniquindio.edu.co.poo.model.Cliente;
import org.uniquindio.edu.co.poo.model.Factura;
import org.uniquindio.edu.co.poo.model.Producto;
import org.uniquindio.edu.co.poo.model.Tienda;
import org.uniquindio.edu.co.poo.model.Venta;

public class Main {
    public static void main(String[] args) {
        
        Tienda tienda = new Tienda("Tienda de Prueba", "Calle 123", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        Producto laptop = new Producto("Laptop", "LAP123", 1500.00, 10, "Electrónica");
        tienda.agregarProducto(laptop);
        
        Producto telefono = new Producto("Teléfono", "TEL456", 800.00, 20, "Electrónica");
        tienda.agregarProducto(telefono);
        
        Producto camiseta = new Producto("Camiseta", "CAM789", 20.00, 50, "Ropa");
        tienda.agregarProducto(camiseta);

        // Registrar cliente
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
        String cedula = JOptionPane.showInputDialog("Ingrese la cédula del cliente:");
        String direccion = JOptionPane.showInputDialog("Ingrese la dirección del cliente:");
        String telefonoCliente = JOptionPane.showInputDialog("Ingrese el teléfono del cliente:");
        String email = JOptionPane.showInputDialog("Ingrese el email del cliente:");
        String mensajeCliente = tienda.registrarCliente(nombre, cedula, direccion, telefonoCliente, email);
        JOptionPane.showMessageDialog(null, mensajeCliente);

        // Buscar cliente registrado
        Cliente cliente = null;
        for (Cliente c : tienda.getClientes()) {
            if (c.getCedula().equals(cedula)) {
                cliente = c;
                break;
            }
        }

        if (cliente != null) {
            // Crear una nueva factura
            String codigoFactura = JOptionPane.showInputDialog("Ingrese el código de la factura:");
            List<Venta> ventas = new ArrayList<>();
            boolean agregarProductos = true;

            while (agregarProductos) {
                // Seleccionar producto
                String codigoProducto = JOptionPane.showInputDialog("Ingrese el código del producto que desea agregar:");
                Producto producto = null;
                for (Producto p : tienda.getProductos()) {
                    if (p.getCodigo().equals(codigoProducto)) {
                        producto = p;
                        break;
                    }
                }

                if (producto != null) {
                    // Ingresar cantidad
                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad del producto:"));
                    if (producto.getStock() >= cantidad) {
                        // Crear venta y agregarla a la lista
                        String fechaVenta = JOptionPane.showInputDialog("Ingrese la fecha de la venta (dd/MM/yyyy):");
                        Venta venta = new Venta(fechaVenta, producto, cantidad);
                        ventas.add(venta);
                        JOptionPane.showMessageDialog(null, "Producto agregado a la venta.");
                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR: No hay suficiente stock del producto.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR: Producto no encontrado.");
                }

                // Preguntar si desea agregar otro producto
                int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea agregar otro producto?", "Agregar Producto", JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.NO_OPTION) {
                    agregarProductos = false;
                }
            }

            // Crear y registrar la factura
            String mensajeFactura = cliente.agregarFactura(new Factura(codigoFactura, cliente, ventas), codigoFactura, ventas);
            JOptionPane.showMessageDialog(null, mensajeFactura);
        } else {
            JOptionPane.showMessageDialog(null, "ERROR: Cliente no encontrado.");
        }
        // Mostrar información completa de la tienda
        String informacionCompleta = tienda.mostrarInformacionCompleta();
        JOptionPane.showMessageDialog(null, informacionCompleta, "Información Completa de la Tienda", JOptionPane.INFORMATION_MESSAGE);
    }
}