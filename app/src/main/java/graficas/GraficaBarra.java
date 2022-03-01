package graficas;

import java.util.ArrayList;

public class GraficaBarra extends Grafica{
    private ArrayList<String> ejeX = new ArrayList<>();
    private ArrayList<Double> ejeY = new ArrayList<>();

    public GraficaBarra(String titulo, ArrayList<Integer> unir, ArrayList<String> ejeX, ArrayList<Double> ejeY) {
        super(titulo, unir);
        this.ejeX = ejeX;
        this.ejeY = ejeY;
    }

    public GraficaBarra() {
    }

    public ArrayList<String> getEjeX() {
        return ejeX;
    }

    public void setEjeX(ArrayList<String> ejeX) {
        this.ejeX = ejeX;
    }

    public ArrayList<Double> getEjeY() {
        return ejeY;
    }

    public void setEjeY(ArrayList<Double> ejeY) {
        this.ejeY = ejeY;
    }

    public void agregarEjeX(String x){
        ejeX.add(x);
    }

    public void agregarEjeY(double y){
        ejeY.add(y);
    }


}
