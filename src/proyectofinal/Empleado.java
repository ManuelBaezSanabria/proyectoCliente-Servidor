
package proyectofinal;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import Interfaces.CrudInterface;

public class Empleado extends Persona implements CrudInterface{
    //definicion de atributos
    private double salario;
    private String puesto;
    
    //Se crea el arrayList de empleados vacio
    public static ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
   
    
    //creacion del constructor vacio
    public Empleado() {
    }
    
    //creacion del constructor
    public Empleado(double salario, String puesto, int ID, String nombre, int edad) {
        super(ID, nombre, edad);
        this.puesto = puesto;
        this.salario = salario;
    }
    
    //creacion de encapsuladores
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }    
    
    //metodoToString
    @Override
    public String toString() {
        return super.toString() + "\n" + "Salario: " + salario + " colones" + "\n" + "Puesto: " + puesto+ "\n" + "\n";
    }
    
    public int getId(){
        return super.getID();
    }
    
    //Se crea el metodo para ingresar trabajadores al ArrayList
    public void ingresarTrabajador(){        
        //Se crea un boolean que nos ayudara al try catch
        boolean valorCorrecto = false;
        
        while(true){
            String salir = JOptionPane.showInputDialog
        ("Digite SALIR para terminar - otra cosa para seguir").toUpperCase();
            
            if("SALIR".equals(salir)){
                //quebrar el ciclo
                break;
            }//fin del if;  
            
            //ingresar informacion del empleado
            super.setNombre(JOptionPane.showInputDialog
            ("Digite el nombre completo del empleado"));
            
            while(!valorCorrecto){
                try {
                super.setEdad(Integer.parseInt(JOptionPane.showInputDialog
                ("Digite la edad")));
                valorCorrecto = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Valor incorrecto");
                }
            }
            
            valorCorrecto = false; //se reinicia el valor del boolean
            
            while(!valorCorrecto){
                try {
                    super.setID(Integer.parseInt(JOptionPane.showInputDialog
                    ("Digite la cedula del empleado")));
                    valorCorrecto = true;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Valor incorrecto");
                }
            }
            
            valorCorrecto = false; //se reinicia el valor del boolean
            
            while(!valorCorrecto){
                try {salario = Double.parseDouble(JOptionPane.showInputDialog
                ("Digite el salario del empleado"));
                valorCorrecto = true;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Valor incorrecto");
                }
            }           
            
            valorCorrecto = false; //se reinicia el valor del boolean para el siguiente elemento
            
            puesto = JOptionPane.showInputDialog("Digite el puesto del empleado");
            
            //se crea un empleado con la informacion del empleado
            listaEmpleados.add(new Empleado(salario, puesto, super.getID(), super.getNombre(), super.getEdad()));           
        }
    }
    
    //metodo para mostrar los datos
    public void mostrarDatos(){       
        String msj = "";
        for(Empleado a: listaEmpleados){
            msj = msj +"\n" + a;
        }//fin del for
        
        JOptionPane.showMessageDialog(null, msj);
    }  
    
    //metodo para eliminar datos
    public void eliminarDatos(){        
        int cedula;
        
        //se solicita la cedula a eliminar
        cedula = Integer.parseInt(JOptionPane.showInputDialog(null, 
        "Digite el ID de la persona a eliminar"));
        
        //se recorre el arraylist buscando la cedula a eliminar
        for(int i=0; i<listaEmpleados.size(); i++){
            if(cedula == listaEmpleados.get(i).getID()){
                listaEmpleados.remove(i);    
            }
        }
    }
    
    public void modificarDatos(){
        int cedula;
        int opc;
        
        //se solicita la cedula para buscar el empleado
        cedula = Integer.parseInt(JOptionPane.showInputDialog(null, 
        "Digite el ID de la persona que quieres modificar en el programa"));
        
        //se recorre el arraylist buscando la cedula de la persona a modificar
        for(int i=0; i<listaEmpleados.size(); i++){
            if(cedula == listaEmpleados.get(i).getID()){
                //creamos un mini menu para seleccionar la opcion deseada
                opc = Integer.parseInt(JOptionPane.showInputDialog
                (null, "Ingrese lo que desea hacer\n" 
                + "\n"
                + "1. Editar Cedula\n"
                + "\n"
                + "2. Editar Nombre\n"
                + "\n"
                + "3. Editar edad\n"
                + "\n"
                + "4. Editar salario\n"
                + "\n"
                + "5. Editar puesto\n"
                + "\n"
                + "6. Salir del sistema\n")); 
                switch(opc){
        //en el caso 1 editamos la cedula   
                    
        //Añadir un bloque try catch para estas ocasiones, por aquello de recibir algo diferente a un int            
        case 1:{
            listaEmpleados.get(i).setID(Integer.parseInt(JOptionPane.showInputDialog
            ("Digite la cedula del empleado")));
            mostrarDatos();
            break;
                    }
        //en el caso 2 editamos el nombre
        case 2:{
            listaEmpleados.get(i).setNombre
            (JOptionPane.showInputDialog("Escriba el nombre del empleado"));
            mostrarDatos();
            break;
                    }
        //en el caso 3 editamos la edad
        case 3:{
            listaEmpleados.get(i).setEdad(Integer.parseInt(JOptionPane.showInputDialog
            ("Digite la edad del empleado")));
            mostrarDatos();
            break;
                    }
        //en el caso 4 editamos el salario
        case 4:{
            listaEmpleados.get(i).setSalario(Double.parseDouble
            (JOptionPane.showInputDialog("Ingrese el salario del empleado")));
            mostrarDatos();
            break;
                    }
        //en el caso 5 editamos el puesto
        case 5:{
            listaEmpleados.get(i).setPuesto
            (JOptionPane.showInputDialog("Ingrese el puesto del empleado"));
            mostrarDatos();
            break;
                    }
        case 6:{
            System.exit(0);
                    }
        default:{
            JOptionPane.showMessageDialog(null,
                    "Opcion no valida");
            }
                }
            }
        }
    }   

    @Override
    public void registrar() {
               //Se crea un boolean que nos ayudara al try catch
        boolean valorCorrecto = false;
        
        while(true){
            String salir = JOptionPane.showInputDialog
        ("Digite SALIR para terminar - otra cosa para seguir").toUpperCase();
            
            if("SALIR".equals(salir)){
                //quebrar el ciclo
                break;
            }//fin del if;  
            
            //ingresar informacion del empleado
            super.setNombre(JOptionPane.showInputDialog
            ("Digite el nombre completo del empleado"));
            
            while(!valorCorrecto){
                try {
                super.setEdad(Integer.parseInt(JOptionPane.showInputDialog
                ("Digite la edad")));
                valorCorrecto = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Valor incorrecto");
                }
            }
            
            valorCorrecto = false; //se reinicia el valor del boolean
            
            while(!valorCorrecto){
                try {
                    super.setID(Integer.parseInt(JOptionPane.showInputDialog
                    ("Digite la cedula del empleado")));
                    valorCorrecto = true;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Valor incorrecto");
                }
            }
            
            valorCorrecto = false; //se reinicia el valor del boolean
            
            while(!valorCorrecto){
                try {salario = Double.parseDouble(JOptionPane.showInputDialog
                ("Digite el salario del empleado"));
                valorCorrecto = true;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Valor incorrecto");
                }
            }           
            
            valorCorrecto = false; //se reinicia el valor del boolean para el siguiente elemento
            
            puesto = JOptionPane.showInputDialog("Digite el puesto del empleado");
            
            //se crea un empleado con la informacion del empleado
            listaEmpleados.add(new Empleado(salario, puesto, super.getID(), super.getNombre(), super.getEdad()));           
        } 
    }

    @Override
    public void modificar() {
        int cedula;
        int opc;
        
        //se solicita la cedula para buscar el empleado
        cedula = Integer.parseInt(JOptionPane.showInputDialog(null, 
        "Digite el ID de la persona que quieres modificar en el programa"));
        
        //se recorre el arraylist buscando la cedula de la persona a modificar
        for(int i=0; i<listaEmpleados.size(); i++){
            if(cedula == listaEmpleados.get(i).getID()){
                //creamos un mini menu para seleccionar la opcion deseada
                opc = Integer.parseInt(JOptionPane.showInputDialog
                (null, "Ingrese lo que desea hacer\n" 
                + "\n"
                + "1. Editar Cedula\n"
                + "\n"
                + "2. Editar Nombre\n"
                + "\n"
                + "3. Editar edad\n"
                + "\n"
                + "4. Editar salario\n"
                + "\n"
                + "5. Editar puesto\n"
                + "\n"
                + "6. Salir del sistema\n")); 
                switch(opc){
        //en el caso 1 editamos la cedula            
        case 1:{
            listaEmpleados.get(i).setID(Integer.parseInt(JOptionPane.showInputDialog
            ("Digite la cedula del empleado")));
            mostrarDatos();
            break;
                    }
        //en el caso 2 editamos el nombre
        case 2:{
            listaEmpleados.get(i).setNombre
            (JOptionPane.showInputDialog("Escriba el nombre del empleado"));
            mostrarDatos();
            break;
                    }
        //en el caso 3 editamos la edad
        case 3:{
            listaEmpleados.get(i).setEdad(Integer.parseInt(JOptionPane.showInputDialog
            ("Digite la edad del empleado")));
            mostrarDatos();
            break;
                    }
        //en el caso 4 editamos el salario
        case 4:{
            listaEmpleados.get(i).setSalario(Double.parseDouble
            (JOptionPane.showInputDialog("Ingrese el salario del empleado")));
            mostrarDatos();
            break;
                    }
        //en el caso 5 editamos el puesto
        case 5:{
            listaEmpleados.get(i).setPuesto
            (JOptionPane.showInputDialog("Ingrese el puesto del empleado"));
            mostrarDatos();
            break;
                    }
        case 6:{
            System.exit(0);
                    }
        default:{
            JOptionPane.showMessageDialog(null,
                    "Opcion no valida");
            }
                }
            }
        }
    }

    @Override
    public void consultar() {
        String msj = "";
        for(Empleado a: listaEmpleados){
            msj = msj +"\n" + a;
        }//fin del for
        
        JOptionPane.showMessageDialog(null, msj);
    }

    @Override
    public void eliminar() {
        int cedula;
        
        //se solicita la cedula a eliminar
        cedula = Integer.parseInt(JOptionPane.showInputDialog(null, 
        "Digite el ID de la persona a eliminar"));
        
        //se recorre el arraylist buscando la cedula a eliminar
        for(int i=0; i<listaEmpleados.size(); i++){
            if(cedula == listaEmpleados.get(i).getID()){
                listaEmpleados.remove(i);    
            }
        }
    }
}//fin de la clase
