public class Individual extends Curs {

    private double preuH;

    public Individual(int id, String nom, String monitor, double preuH) {
        super(id, nom, monitor);
        this.preuH = preuH;
    }

    public double getPreuH() {
        return preuH;
    }

    public void setPreuH(double preuH) {
        this.preuH = preuH;
    }

}
