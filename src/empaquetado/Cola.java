/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empaquetado;

import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ASUS
 */
public class Cola {
    
    public Nodo inicio;

    public Cola() { inicio = null; }

    public boolean getEsVacia() {
        return inicio == null ? true : false;
    }

    public void setEncolar(String cod, String nom, float precio) {
        Nodo info = new Nodo(cod, nom, precio);
        if (getEsVacia()) {
            inicio = info;
            inicio.sig = inicio;
        } else {
            Nodo p = inicio;
            while (p.sig != inicio) p = p.sig;
            p.sig = info;
            info.sig = inicio;
        }
    }

    public Nodo setDesencolar() {
        if (getEsVacia()) {
            JOptionPane.showMessageDialog(null, "No hay pedidos en la cola.");
            return null;
        }
        Nodo atendido = inicio;
        if (inicio.sig == inicio) {
            inicio = null;
        } else {
            Nodo p = inicio;
            while (p.sig != inicio) p = p.sig;
            inicio = inicio.sig;
            p.sig = inicio;
            atendido.sig = null;
        }
        return atendido;
    }
   
    public void setGuardarPedidos() {
        if (getEsVacia()) {
            JOptionPane.showMessageDialog(null, "No hay pedidos para guardar.");
            return;
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("pedidos.txt"))) {
            Nodo p = inicio;
            do {
                bw.write(p.codP + ";" + p.nomP + ";" + p.precioU);
                bw.newLine();
                p = p.sig;
            } while (p != inicio);
            JOptionPane.showMessageDialog(null, "Pedidos guardados en pedidos.txt");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar: " + e.getMessage());
        }
    }

    
    public void setCargarPedidos() {
        inicio = null;
        try (BufferedReader br = new BufferedReader(new FileReader("pedidos.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (!linea.isEmpty()) {
                    String[] datos = linea.split(";", -1);
                    if (datos.length == 3) {
                        String cod = datos[0].trim();
                        String nom = datos[1].trim();
                        float precio = Float.parseFloat(datos[2].trim());
                        setEncolar(cod, nom, precio);
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Pedidos cargados correctamente.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se encontró pedidos.txt.");
        }
    }
}
