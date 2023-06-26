
package proyectofinal;

public class Persona {
    //definicion de atributos
    public int ID;
    public String nombre;
    public int edad;
    
    //creacion del constructor vacio
    public Persona() {
    }
    
    //creacion del constructor
    public Persona(int ID, String nombre, int edad) {
        this.ID = ID;
        this.nombre = nombre;
        this.edad = edad;
    }
    
    //creacion de los encapsuladores
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    //Metodo toString
    @Override
    public String toString() {
        return "Informacion del empleado:" + "\n" + "\n" + "ID: " + ID + "\n" + "Nombre: " + nombre + "\n" + "Edad: " + edad;
    }
    
    
    
}//fin de la clase
