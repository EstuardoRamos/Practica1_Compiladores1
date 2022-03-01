package graficas;

import java.util.ArrayList;

public class Grafica {
    private String  titulo;
    private ArrayList<Integer> unir = new ArrayList<>();

    public Grafica() {
    }

    public Grafica(String titulo, ArrayList<Integer> unir) {
        this.titulo = titulo;
        this.unir = unir;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<Integer> getUnir() {
        return unir;
    }

    public void setUnir(ArrayList<Integer> unir) {
        this.unir = unir;
    }
}
