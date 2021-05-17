/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jose
 */
public class ListaConPrioridadDoble {

    protected NodoDoble ini;
    protected NodoDoble fin;

    public ListaConPrioridadDoble() {
        ini = fin = null;
    }

    public boolean insertar(char dato, int nivel) {
        NodoDoble nuevo = new NodoDoble(dato, nivel);

        if (nuevo == null) {
            return false;
        }
        if (estaVacia()) {
            ini = fin = nuevo;
            return true;
        }
        if (ini == fin) {
            ini.setAnt(nuevo);
            nuevo.setSig(ini);
            nuevo.setAnt(ini);
            ini.setSig(nuevo);
            if (nuevo.getNivel() > ini.getNivel()) {
                ini = nuevo;
                fin.setSig(null);
                ini.setAnt(null);

            } else {
                fin = nuevo;
                ini.setAnt(null);
                fin.setSig(null);
            }
            return true;
        }
        acomodo(nuevo);
        return true;
    }

    public boolean eliminar() {
        if (estaVacia()) {
            return false;
        }
        if (hayUnNodo()) {
            ini.setSig(null);
            fin.setSig(null);
            ini = fin = null;
            return true;
        }
        NodoDoble temp = ini;
        ini = temp.getSig();
        ini.setAnt(null);
        temp.setSig(null);
        temp = null;
        return true;
    }

    public void acomodo(NodoDoble nuevo) {
        if (nuevo.getNivel() > ini.getNivel()) {
            nuevo.setSig(ini);
            ini.setAnt(nuevo);
            ini = nuevo;
            ini.setAnt(null);
        } else if (nuevo.getNivel() <= fin.getNivel()) {
            nuevo.setAnt(fin);
            fin.setSig(nuevo);
            fin = nuevo;
            fin.setSig(null);
        } else {
            NodoDoble temp = fin.getAnt();
            while (temp != fin) {
                if (temp.getNivel() >= nuevo.getNivel()) {
                    break;
                }
                temp = temp.getAnt();
            }
            temp.getSig().setAnt(nuevo);
            nuevo.setAnt(temp);
            nuevo.setSig(temp.getSig());
            temp.setSig(nuevo);
        }
    }

    public boolean estaVacia() {
        return ini == null;
    }

    public boolean hayUnNodo() {
        return ini == fin;
    }

    public NodoDoble getIni() {
        return ini;
    }

    public NodoDoble getFin() {
        return fin;
    }

}
