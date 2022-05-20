import java.time.LocalDate;

public class Competicio extends Curs {

    private double preu;
    private int nivell;
    private LocalDate dataInici;
    private LocalDate dataFi;
    private int durada;

    public Competicio(int id, String nom, String monitor, double preu, int nivell, LocalDate localDate,
            LocalDate localDate2, int localDate3) {
        super(id, nom, monitor);
        this.preu = preu;
        this.nivell = nivell;
        this.dataInici = localDate;
        this.dataFi = localDate2;
        this.durada = localDate3;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public int getNivell() {
        return nivell;
    }

    public void setNivell(int nivell) {
        this.nivell = nivell;
    }

    public LocalDate getDataInici() {
        return dataInici;
    }

    public void setDataInici(LocalDate dataInici) {
        this.dataInici = dataInici;
    }

    public LocalDate getDataFi() {
        return dataFi;
    }

    public void setDataFi(LocalDate dataFi) {
        this.dataFi = dataFi;
    }

    public int getDurada() {
        return durada;
    }

    public void setDurada(int durada) {
        this.durada = durada;
    }

}
