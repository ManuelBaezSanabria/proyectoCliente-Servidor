
package proyectofinal;

import Interfaces.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Producto implements CrudInterface {
   //Atributos de la clase
   private int cantidadProducto;
   private int Id;
   private String descripcion;
   private double precio;
   
   private static menuController m = new menuController();
   
   public static ArrayList<Producto> lstProductos = new ArrayList();

    public Producto() {
    }

    public Producto(int cantidadProducto, int Id, String descripcion, double precio) {
        this.cantidadProducto = cantidadProducto;
        this.Id = Id;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" + "cantidadProducto=" + cantidadProducto + ", Id=" + Id + ", descripcion=" + descripcion + ", precio=" + precio + '}';
    }
    
    public void Menu() {
        int opcion = -1;
        String[] opciones = {"Registrar nuevo producto", "Consultar un producto", "Modificar información de un producto", " Eliminar un producto", "Volver"};
        while (opcion != opciones.length - 1) {
            opcion = m.Menus("Seleccione un opción", "Módulo de registro de producto", opciones, "Volver");
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
        m.msg("Registrando un producto");
        int Id = 0;
        int cantidadProducto = 0;
        String descripcion = "";
        double precio = 0;

        //Valida la cantidad
        Boolean numeroValido = false;
        while (!numeroValido) {
            try {
                cantidadProducto = Integer.parseInt(m.Input("Ingrese la cantidad de producto: "));
                numeroValido = true;
            } catch (Exception e) {
                m.msg("Debe ingresar una cantidad válida");
            }
        }

        //Valida el id
        Boolean numeroValido2 = false;
        while (!numeroValido2) {
            try {
                Id = Integer.parseInt(m.Input("Ingrese el Id dek producto: "));
                numeroValido2 = true;
            } catch (Exception e) {
                m.msg("Debe ingresar un Id válido");
            }
        }
        
        //Valida descripcion
        Boolean strValido = false;
        while (!strValido) {
                descripcion = m.Input("Ingrese una descripción: ");
                if (descripcion.isEmpty()) {
                    m.msg("Debe ingresar una descripción válida");
                } else {
                    strValido = true;
                }
        }

        //Valida el número telefónico
        Boolean numeroValido3 = false;
        while (!numeroValido3) {
            try {
                precio = Double.parseDouble(m.Input("Ingrese el precio: "));
                numeroValido3 = true;
            } catch (Exception e) {
                m.msg("Debe ingresar un precio válido");
            }
        }

        Producto producto = new Producto(cantidadProducto, Id, descripcion, precio);

        int resp;
        String msg = "Cantidad: " + producto.getCantidadProducto()+ "\n" + "Id: " + producto.getId() + "\n" + "Descripción: " + producto.getDescripcion() +"\n" + "Precio: " + producto.precio ;
        String titulo = "¿Los datos están correctos?";
        resp = m.SIoNo(msg, titulo);

        if (resp == 0) {
            lstProductos.add(producto);
        } else {
            m.msg("Por favor intenta de nuevo");
        }
    }

    @Override
    public void modificar() {
                m.msg("Editando un producto");
        int idProducto = -1;
        int indexProducto = -1;
        try {
            idProducto = Integer.parseInt(m.Input("Ingrese el ID de la persona: "));
        } catch (Exception e) {
            m.msg("Ingresó un ID no válido");
        }

        for (int i = 0; i < lstProductos.size(); i++) {
            if (lstProductos.get(i).getId() == idProducto) {
                indexProducto = i;
                break;
            }
        }
        if (indexProducto != -1) {
            int Id = lstProductos.get(indexProducto).getId();
            int cantProd = lstProductos.get(indexProducto).getCantidadProducto();
            String descripcion = lstProductos.get(indexProducto).getDescripcion();
            double precio = lstProductos.get(indexProducto).getPrecio();

            Id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Id", Id));
            cantProd = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de producto", cantProd));
            descripcion = JOptionPane.showInputDialog("Ingrese la descripción", descripcion);
            precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio", precio));

            lstProductos.get(indexProducto).setId(Id);
            lstProductos.get(indexProducto).setCantidadProducto(cantProd);
            lstProductos.get(indexProducto).setDescripcion(descripcion);
            lstProductos.get(indexProducto).setPrecio(precio);
            JOptionPane.showMessageDialog(null, "Modificación realizada con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "Producto no existe");
        }
    }

    @Override
    public void consultar() {
        m.msg("Buscando producto");

        int idProducto;
        try {
            idProducto = Integer.parseInt(m.Input("Ingrese el ID del producto:"));
            for (int i = 0; i < lstProductos.size(); i++) {
                if (lstProductos.get(i).getId() == idProducto) {
                    JOptionPane.showMessageDialog(null, lstProductos.get(i));
                    break;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Número de ID incorrecto");
        }
    }

    @Override
    public void eliminar() {
        m.msg("Eliminando un producto");
        int idProducto;
        try {
            idProducto = Integer.parseInt(m.Input("Ingrese el ID del producto:"));
            for (int i = 0; i < lstProductos.size(); i++) {
                if (lstProductos.get(i).getId() == idProducto) {
                    int resp;
                    String msg = "¿Está seguro(a) que desea eliminar este producto?" + "\n" + lstProductos.get(i);
                    String titulo = "Eliminar producto";
                    resp = m.SIoNo(msg, titulo);

                    if (resp == 0) {
                        lstProductos.remove(i);
                        m.msg("El producto fue eliminado con éxito");
                    } else if (resp == 1) {
                        m.msg("El producto no fue eliminado");
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Número de ID no existe");
        }
    }
   
}
