
package proyectofinal;

public class main {

    public static void main(String[] args) {
        
        menuController m = new menuController();
        Producto productoMenu = new Producto();
        Ventas ventasMenu = new Ventas();
        
        String[] opciones = {"Registro de Empleados", "Registro de Clientes", "Registro de Proveedores", "Registro de Productos", "Registro de Ventas", "Volver"};
        int opcion = -1;
        boolean existe;
        while (opcion != opciones.length - 1) {
            opcion = m.Menus("Seleccione un opción", "Auto Transportes el Roble", opciones, "Salir");
            switch (opcion) {
                case 0:
                    
                    break;
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    productoMenu.Menu();
                    break;
                case 4:
                    ventasMenu.Menu();
                    break;
            }
        }
        /*
        Empleado empleadin = new Empleado();
        
        empleadin.registrar();
        empleadin.mostrarDatos();
        empleadin.eliminarDatos();
        empleadin.mostrarDatos();
        empleadin.modificarDatos();
        empleadin.mostrarDatos();
        */
        
        
    } //fin del metodo main
    
} //final de la clase
