/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empaquetado;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author ASUS
 */
public class Lista {
    
    public Nodo cab;

    public Lista() { cab = null; }

    public boolean getEsVacia() {
        return cab == null ? true : false;
    }

    public Nodo getUltimo() {
        if (getEsVacia()) return null;
        Nodo p = cab;
        while (p.sig != null) p = p.sig;
        return p;
    }

    
    public void setAddF(String cod, String nom, float precio) {
        Nodo info = new Nodo(cod, nom, precio);
        if (getEsVacia()) {
            cab = info;
        } else {
            Nodo u = getUltimo();
            u.sig = info;
        }
    }

    void setCargarCatalogo() {
        
       try (BufferedReader br = new BufferedReader(new FileReader("catalogo.txt"))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            linea = linea.trim();
            if (!linea.isEmpty()) {
                String[] datos = linea.split(";", -1);
                if (datos.length == 3) {
                    String cod = datos[0].trim();
                    String nom = datos[1].trim();
                    float precio = Float.parseFloat(datos[2].trim());
                    setAddF(cod, nom, precio);
                }
            }
        }
    } catch (IOException e) {
        
    }
    }
}
