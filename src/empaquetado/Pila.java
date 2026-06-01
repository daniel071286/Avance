/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empaquetado;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class Pila {
    
    // En una pila el "tope" hace el papel de cab
    public Nodo tope;

    public Pila() { tope = null; }

    public boolean getEsVacia() {
        return tope == null ? true : false;
    }

    
    public void setPush(String cod, String nom, float precio) {
        Nodo info = new Nodo(cod, nom, precio);
        if (getEsVacia()) {
            tope = info;
        } else {
            info.sig = tope;
            tope = info;
        }
    }

    
    public Nodo getPop() {
        if (getEsVacia()) {
            JOptionPane.showMessageDialog(null, "Historial vacío. No hay nada que deshacer.");
            return null;
        }
        Nodo extraido = tope;
        tope = tope.sig;
        extraido.sig = null;
        return extraido;
    }

    
    public String getHistorial() {
        if (getEsVacia()) return "El historial está vacío.";
        String mensaje = "Historial de productos agregados\n";
        Nodo p = tope;
        int i = 1;
        while (p != null) {
            mensaje += i + ". " + p.nomP + " ($" + p.precioU + ")\n";
            p = p.sig;
            i++;
        }
        return mensaje;
    }
}
