import java.time.LocalDate;

public class Colectiu extends Curs {

    private double preu;
    private LocalDate data;
    private int maxClients;

    public Colectiu(int id, String nom, String monitor, double preu, LocalDate data, int maxClients) {
        super(id, nom, monitor);
        this.preu = preu;
        this.data = data;
        this.maxClients = maxClients;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getMaxClients() {
        return maxClients;
    }

    public void setMaxClients(int maxClients) {
        this.maxClients = maxClients;
    }

}
