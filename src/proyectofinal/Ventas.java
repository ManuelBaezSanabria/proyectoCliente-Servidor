/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

import java.util.ArrayList;
import Interfaces.CrudInterface;
import javax.swing.JOptionPane;
import static proyectofinal.Cliente.lstClientes;
import static proyectofinal.Producto.lstProductos;
import static proyectofinal.Empleado.listaEmpleados;

public class Ventas implements CrudInterface {
    //Atributos de la clase
    private int numeroVenta;
    private double montoFacturado;
    private ArrayList productosAdquiridos;
    private String metodoPago;
    private int IdComprador;
    private String nombreComprador;
    private int IdVendedor;
    private String nombreVendedor;
    private String fecha;
    
    //Creación de objeto menu controller
    
    private static menuController m = new menuController();
    
    public static ArrayList<Ventas> lstVentas = new ArrayList();

    public Ventas() {
    }

    public Ventas(int numeroVenta, double montoFacturado, ArrayList productosAdquiridos, String metodoPago, int IdComprador, String nombreComprador, int IdVendedor, String nombreVendedor, String fecha) {
        this.numeroVenta = numeroVenta;
        this.montoFacturado = montoFacturado;
        this.productosAdquiridos = productosAdquiridos;
        this.metodoPago = metodoPago;
        this.IdComprador = IdComprador;
        this.nombreComprador = nombreComprador;
        this.IdVendedor = IdVendedor;
        this.nombreVendedor = nombreVendedor;
        this.fecha = fecha;
    }

    public int getNumeroVenta() {
        return numeroVenta;
    }

    public void setNumeroVenta(int numeroVenta) {
        this.numeroVenta = numeroVenta;
    }

    public double getMontoFacturado() {
        return montoFacturado;
    }

    public void setMontoFacturado(double montoFacturado) {
        this.montoFacturado = montoFacturado;
    }

    public ArrayList getProductosAdquiridos() {
        return productosAdquiridos;
    }

    public void setProductosAdquiridos(ArrayList productosAdquiridos) {
        this.productosAdquiridos = productosAdquiridos;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public int getIdComprador() {
        return IdComprador;
    }

    public void setIdComprador(int IdComprador) {
        this.IdComprador = IdComprador;
    }

    public String getNombreComprador() {
        return nombreComprador;
    }

    public void setNombreComprador(String nombreComprador) {
        this.nombreComprador = nombreComprador;
    }

    public int getIdVendedor() {
        return IdVendedor;
    }

    public void setIdVendedor(int IdVendedor) {
        this.IdVendedor = IdVendedor;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Ventas{" + "numeroVenta=" + numeroVenta + ", montoFacturado=" + montoFacturado + ", productosAdquiridos=" + productosAdquiridos + ", metodoPago=" + metodoPago + ", IdComprador=" + IdComprador + ", nombreComprador=" + nombreComprador + ", IdVendedor=" + IdVendedor + ", nombreVendedor=" + nombreVendedor + ", fecha=" + fecha + '}';
    }
    
    public void Menu() {
        int opcion = -1;
        String[] opciones = {"Registrar nueva venta", "Consultar una venta", "Modificar información de una venta", " Eliminar una venta", "Volver"};
        while (opcion != opciones.length - 1) {
            opcion = m.Menus("Seleccione un opción", "Módulo de registro de ventas", opciones, "Volver");
            switch (opcion) {
                case 0:
                    registrar();
                    break;
                case 1:
                    consultar();
                    break;
                case 2:
                    modificar();
                    break;
                case 3:
                    eliminar();
                    break;
            }
        }
    }

    @Override
    public void registrar() {
        //Variables
        m.msg("Registrando una venta");
        int numVen = 0;
        int idCli = 0;
        int idPro = 0;
        int idEmp = 0;
        double montoFac = 0;
        String metPago = "";
        String nomCli = "";
        String fecha = "";
        String nomEmp = "";
        ArrayList productos = new ArrayList();
        
        boolean existe = false;

        //Poner el número de venta como auto incremental
        
        
        existe = false;
        do {
            try {
                idCli = Integer.parseInt(m.Input("Ingrese el ID del cliente: "));
                int indice = idClienteExiste(idEmp);
                if (indice != -1) {
                    nomCli = lstClientes.get(indice).getNombre();
                    existe = true;
                } else {
                    m.msg("El número ID del cliente indicado no existe");
                }
            } catch (Exception e) {
                m.msg("Debe ingresar un número de ID válido");
            }
        } while (!existe);
        
        existe = false;
        do {
            try {
                idEmp = Integer.parseInt(m.Input("Ingrese el ID del empleado: "));
                int indice = idEmpleadoExiste(idEmp);
                if (indice != -1) {
                    nomEmp = listaEmpleados.get(indice).getNombre();
                    existe = true;
                } else {
                    m.msg("El número ID del empleado indicado no existe");
                }
            } catch (Exception e) {
                m.msg("Debe ingresar un número de ID válido");
            }
        } while (!existe);
        
        existe = false;
        do {
            try {
                int cantidadProductos = 0;
                cantidadProductos = Integer.parseInt("Ingrese la cantidad de productos que comprará: ");
                for (int i=0; i<cantidadProductos; i++){
                    idEmp = Integer.parseInt(m.Input("Ingrese el ID del producto: "));
                    int indice = prodExiste(idEmp);
                    if (indice != -1) {
                        productos.add(lstProductos.get(indice));
                        existe = true;
                    } else {
                        m.msg("El número ID del empleado indicado no existe");
                    }
                }
            } catch (Exception e) {
                m.msg("Debe ingresar un número de ID válido");
            }
        } while (!existe);

        //Valida la fecha del viaje
        Boolean fechaValida = false;
        while (!fechaValida) {
            fecha = m.Input("Ingrese la fecha : ");
            if (fecha.isEmpty()) {
                m.msg("Debe ingresar una fecha válida");
            } else {
                fechaValida = true;
            }
        }

        //Valida el destino
        Boolean metValido = false;
        while (!metValido) {
            metPago = m.Input("Ingrese el método de pago: ");
            if (metPago.isEmpty()) {
                m.msg("Debe ingresar un método válido");
            } else {
                metValido = true;
            }
        }
        //Valida el precio del tiquete
        Boolean Valido = false;
        while (!Valido) {
            try {
                numVen = Integer.parseInt(m.Input("Ingrese el número de venta: "));
                Valido = true;
            } catch (Exception e) {
                m.msg("Debe ingresar un número válido");
            }
        }
        
        Boolean Valido2 = false;
        while (!Valido2) {
            try {
                montoFac = Double.parseDouble(m.Input("Ingrese el monto de la factura: "));
                //Sustituir por la implementación del método calcularFactura para la versión 2
                Valido2 = true;
            } catch (Exception e) {
                m.msg("Debe ingresar un monto válido");
            }
        }
        
        Ventas venta = new Ventas(numVen, montoFac, productos, metPago, idCli, nomCli, idEmp, nomEmp,  fecha);

        int resp;
        String msg = venta.toString();
        String titulo = "¿Los datos están correctos?";
        resp = m.SIoNo(msg, titulo);

        if (resp == 0) {
            lstVentas.add(venta);
        } else {
            m.msg("Por favor intenta de nuevo");
        }
    }

    @Override
    public void modificar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void consultar() {
        m.msg("Buscando viajes");

        int idVenta;
        try {
            idVenta = Integer.parseInt(m.Input("Ingrese el número de venta: "));
            for (int i = 0; i < lstVentas.size(); i++) {
                if (lstVentas.get(i).getNumeroVenta() == idVenta) {
                    JOptionPane.showMessageDialog(null, lstVentas.get(i));
                    break;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Número de ID incorrecto");
        }
    }

    @Override
    public void eliminar() {
        m.msg("Eliminando venta");
        int idVenta;
        try {
            idVenta = Integer.parseInt(m.Input("Ingrese el número de venta: "));
            for (int i = 0; i < lstVentas.size(); i++) {
                if (lstVentas.get(i).getNumeroVenta() == idVenta) {
                    int resp;
                    String msg = "¿Está seguro(a) que desea eliminar esta venta?" + "\n" + lstVentas.get(i);
                    String titulo = "Eliminar venta";
                    resp = m.SIoNo(msg, titulo);

                    if (resp == 0) {
                        lstVentas.remove(i);
                        m.msg("La venta fue eliminado con éxito");
                    } else if (resp == 1) {
                        m.msg("La venta no fue eliminado");
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Número de ID no existe");
        }
    }
  
    
    public int prodExiste(int idprod) {
        for (int i = 0; i < lstProductos.size(); i++) {
            Producto producto = lstProductos.get(i);
            if (producto.getId() == idprod) {
                return i; // Retorna el índice donde se encontró el empleado
            }
        }
        return -1; // Retorna -1 si el empleado no se encuentra en la lista
    }
    
    public int idClienteExiste(int idCliente) {
        for (int i = 0; i < lstClientes.size(); i++) {
            Cliente cliente = lstClientes.get(i);
            if (cliente.getId() == idCliente) {
                return i; // Retorna el índice donde se encontró el empleado
            }
        }
        return -1; // Retorna -1 si el empleado no se encuentra en la lista
    }
    
    public int idEmpleadoExiste(int idEmpleado) {
        for (int i = 0; i < listaEmpleados.size(); i++) {
            Empleado empleado = listaEmpleados.get(i);
            if (empleado.getId() == idEmpleado) {
                return i; // Retorna el índice donde se encontró el empleado
            }
        }
        return -1; // Retorna -1 si el empleado no se encuentra en la lista
    }
    
}
