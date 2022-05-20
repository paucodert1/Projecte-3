import java.time.LocalDate;

public class Client {

    private static int idClient;
    private String dni;
    private String nom;
    private String cognom1;
    private String cognom2;
    private LocalDate dataNaix;
    private String sexe;
    private int tel;
    private String correu;
    private String compteBanc;

    private int numFed;
    private LocalDate dataCaducF;
    private int nivell;

    private String carnetFn;
    private LocalDate dataCaducFN;

    public Client(String dni, String nom, String cognom1, String cognom2, LocalDate dataNaix, String sexe, int tel,
            String correu, String compteBanc, int numFed, LocalDate localDate, int nivell, String carnetFn,
            LocalDate localDate2) {
        this.dni = dni;
        this.nom = nom;
        this.cognom1 = cognom1;
        this.cognom2 = cognom2;
        this.dataNaix = dataNaix;
        this.sexe = sexe;
        this.tel = tel;
        this.correu = correu;
        this.compteBanc = compteBanc;
        this.numFed = numFed;
        this.dataCaducF = localDate;
        this.nivell = nivell;
        this.carnetFn = carnetFn;
        this.dataCaducFN = localDate2;
    }

    public static int getIdClient() {
        return idClient;
    }

    public static void setIdClient(int idClient) {
        Client.idClient = idClient;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom1() {
        return cognom1;
    }

    public void setCognom1(String cognom1) {
        this.cognom1 = cognom1;
    }

    public String getCognom2() {
        return cognom2;
    }

    public void setCognom2(String cognom2) {
        this.cognom2 = cognom2;
    }

    public LocalDate getDataNaix() {
        return dataNaix;
    }

    public void setDataNaix(LocalDate dataNaix) {
        this.dataNaix = dataNaix;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getCorreu() {
        return correu;
    }

    public void setCorreu(String correu) {
        this.correu = correu;
    }

    public String getCompteBanc() {
        return compteBanc;
    }

    public void setCompteBanc(String compteBanc) {
        this.compteBanc = compteBanc;
    }

    public int getNumFed() {
        return numFed;
    }

    public void setNumFed(int numFed) {
        this.numFed = numFed;
    }

    public LocalDate getDataCaducF() {
        return dataCaducF;
    }

    public void setDataCaducF(LocalDate dataCaducF) {
        this.dataCaducF = dataCaducF;
    }

    public int getNivell() {
        return nivell;
    }

    public void setNivell(int nivell) {
        this.nivell = nivell;
    }

    public String getCarnetFn() {
        return carnetFn;
    }

    public void setCarnetFn(String carnetFn) {
        this.carnetFn = carnetFn;
    }

    public LocalDate getDataCaducFN() {
        return dataCaducFN;
    }

    public void setDataCaducFN(LocalDate dataCaducFN) {
        this.dataCaducFN = dataCaducFN;
    }

}
