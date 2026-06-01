/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empaquetado;

/**
 *
 * @author ASUS
 */
public class Nodo {
    
    public String codP;
    public String nomP;
    public float precioU;
    public Nodo sig;

    public Nodo(String codP, String nomP, float precioU) {
        this.codP = codP;
        this.nomP = nomP;
        this.precioU = precioU;
        sig = null;
    }
}
