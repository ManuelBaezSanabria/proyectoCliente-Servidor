package proyectofinal;

import javax.swing.JOptionPane;

public class menuController {

    public void msg(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    public int SIoNo(String msg, String titulo) {
        int respuesta = JOptionPane.showConfirmDialog(null, msg, titulo, JOptionPane.YES_NO_OPTION);
        return respuesta;
    }

    public int Menus(String msg, String titulo, String opciones[], String valorDefecto) {
        int opcion = JOptionPane.showOptionDialog(null, msg, titulo, 0,
                JOptionPane.QUESTION_MESSAGE, null, opciones, valorDefecto);
        return opcion;
    }

    public String Input(String msg) {
        String cadena = JOptionPane.showInputDialog(msg);
        return cadena;
    }

}
