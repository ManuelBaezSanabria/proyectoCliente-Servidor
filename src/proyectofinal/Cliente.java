
package proyectofinal;

import Interfaces.CrudInterface;
import java.util.ArrayList;

public class Cliente extends Persona implements CrudInterface{
    //definicion de atributos
    private String correoElectronico;
    
    public static ArrayList<Cliente> lstClientes = new ArrayList();
    
    //creacion de constructor vacio
    public Cliente() {
    }
    
    //creacion de constructor
    public Cliente(String correoElectronico, int ID, String nombre, int edad) {
        super(ID, nombre, edad);
        this.correoElectronico = correoElectronico;
    }
    
    //creacion de encapsuladores
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }  
    
    public int getId(){
        return super.getID();
    }

    @Override
    public void registrar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modificar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void consultar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}//fin de la clase
