abstract public class Curs {

    private int id;
    private String nom;
    private String monitor;

    public Curs(int id, String nom, String monitor) {
        this.id = id;
        this.nom = nom;
        this.monitor = monitor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

}
