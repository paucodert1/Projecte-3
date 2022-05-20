import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Projecte3 extends Application {

    Client client;

    TextField txtCliDni;
    TextField txtCliNom;
    TextField txtCliCognom1;
    TextField txtCliCognom2;
    TextField txtCliDataNaix;
    TextField txtCliSexe;
    TextField txtCliTel;
    TextField txtCliCorreu;
    TextField txtCliCompteBanc;
    TextField txtCliCarnetFn;
    TextField txtCliDataCaducFN;
    TextField txtCliDataCaducF;
    TextField txtCliNumFed;
    TextField txtCliNivell;

    VBox cursCol;
    TextField txtCurColId;
    TextField txtCurColNom;
    TextField txtCurColMonitor;
    TextField txtCurColPreu;
    TextField txtCurColData;
    TextField txtCurColMaxCli;
    TextField txtCurColDescomteFN;
    TextField txtCurColPreuFinal;
    TextField txtCurColCantPersones;

    VBox cursCom;
    TextField txtCurComId;
    TextField txtCurComNom;
    TextField txtCurComMonitor;
    TextField txtCurComPreu;
    TextField txtCurComNivell;
    TextField txtCurComDataIn;
    TextField txtCurComDataFi;
    TextField txtCurComDurada;

    VBox cursIn;
    TextField txtCurInId;
    TextField txtCurInNom;
    TextField txtCurInMonitor;
    TextField txtCurInPreuH;
    TextField txtCurInHores;
    TextField txtCurInData;
    TextField txtCurInDescomte;
    TextField txtCurInPreuFinal;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage escenari) throws Exception {
        // Fem servir un contenidor BorderPane per la nostra aplicació
        // el contingut de cada regió el dibuixem

        BorderPane contenidor = new BorderPane();

        Pane pTop = partSuperior();
        contenidor.setTop(pTop);
        BorderPane.setMargin(pTop, new Insets(20, 20, 20, 20));

        Pane pBot = partInferior();
        contenidor.setBottom(pBot);
        BorderPane.setMargin(pBot, new Insets(20, 20, 20, 20));

        Pane pEsq = lateralEsquera();
        contenidor.setLeft(pEsq);
        BorderPane.setMargin(pEsq, new Insets(20, 20, 20, 20));

        Pane pDret = lateralDret();
        contenidor.setRight(pDret);
        BorderPane.setMargin(pDret, new Insets(20, 20, 20, 20));

        Pane pMid = formulariCentral();
        contenidor.setCenter(pMid);

        Scene escena = new Scene(contenidor);

        escenari.setScene(escena);

        escenari.setMinHeight(700);
        escenari.setMinWidth(1000);
        escenari.show();

    }

    private Pane lateralDret() {
        VBox vb = new VBox();

        Label lbl = new Label("Cursos");

        // vb.getChildren().addAll(lbl);
        vb.setAlignment(Pos.CENTER);

        TabPane tp = new TabPane();

        Tab tab1 = new Tab("Colectiu", cursosColectius());
        Tab tab2 = new Tab("Competicio", cursosCompeticio());
        Tab tab3 = new Tab("Individual", cursosIndividuals());

        tp.getTabs().addAll(tab1, tab2, tab3);

        vb.getChildren().addAll(lbl, tp);
        vb.setMaxWidth(300);

        return vb;
    }

    private Pane cursosCompeticio() {
        VBox vb = new VBox();

        TableView<Competicio> tblCursosCom = new TableView<>();
        TableColumn<Competicio, String> colId = new TableColumn<>("ID");
        TableColumn<Competicio, String> colNom = new TableColumn<>("Nom");
        TableColumn<Competicio, String> colPreu = new TableColumn<>("Preu");
        TableColumn<Competicio, String> colData = new TableColumn<>("Data Inici");
        TableColumn<Competicio, String> colDataFi = new TableColumn<>("Data Fi");

        tblCursosCom.getColumns().addAll(colId, colNom, colPreu, colData, colDataFi);

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPreu.setCellValueFactory(new PropertyValueFactory<>("preu"));
        colData.setCellValueFactory(new PropertyValueFactory<>("dataInici"));
        colDataFi.setCellValueFactory(new PropertyValueFactory<>("dataFi"));

        Connection con = ConexioBD.getConnection();
        String consulta = "SELECT * FROM competicio com JOIN cursos c ON com.id = c.id";

        try {
            PreparedStatement ps = con.prepareStatement(consulta);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Competicio c = new Competicio(rs.getInt("id"), rs.getString("nom"), rs.getString("dni"),
                        rs.getInt("preu"),
                        rs.getInt("nivell"), rs.getDate("data_inici").toLocalDate(),
                        rs.getDate("data_fi").toLocalDate(),
                        rs.getInt("durada"));

                tblCursosCom.getItems().add(c);
            }
        } catch (SQLException e) {
            System.out.println("NO funcione la consulta");
            e.printStackTrace();
        }

        vb.getChildren().add(tblCursosCom);

        tblCursosCom.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                Competicio curCom = (Competicio) newValue;

                if (!txtCliDni.getText().equals("") || !txtCliDni.getText().equals(" ")) {
                    if (!txtCliNumFed.getText().equals(" ")) {
                        if (curCom != null) {
                            txtCurComId.setText(String.valueOf(curCom.getId()));
                            txtCurComNom.setText(curCom.getNom());
                            txtCurComMonitor.setText(curCom.getMonitor());
                            txtCurComPreu.setText(String.valueOf(curCom.getPreu()));
                            txtCurComNivell.setText(String.valueOf(curCom.getNivell()));
                            txtCurComDataIn.setText(curCom.getDataInici().toString());
                            txtCurComDataFi.setText(curCom.getDataFi().toString());
                            txtCurComDurada.setText(String.valueOf(curCom.getDurada()));

                            cursCom.setVisible(true);
                            cursCol.setVisible(false);
                            cursIn.setVisible(false);
                        }
                    } else {
                        Alert alert = new Alert(AlertType.WARNING);
                        alert.setTitle("Avis");
                        alert.setHeaderText("El client no esta federat");
                        alert.showAndWait();
                    }
                } else {
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Avis");
                    alert.setHeaderText("No hi ha Client");
                    alert.showAndWait();
                }

            }

        });

        return vb;
    }

    private Pane cursosColectius() {
        VBox vb = new VBox();

        TableView<Colectiu> tblCursosCol = new TableView<>();
        TableColumn<Colectiu, String> colId = new TableColumn<>("ID");
        TableColumn<Colectiu, String> colNom = new TableColumn<>("Nom");
        TableColumn<Colectiu, String> colPreu = new TableColumn<>("Preu");
        TableColumn<Colectiu, String> colData = new TableColumn<>("Data");
        TableColumn<Colectiu, String> colMaxClients = new TableColumn<>("Max Clients");

        tblCursosCol.getColumns().addAll(colId, colNom, colPreu, colData, colMaxClients);

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPreu.setCellValueFactory(new PropertyValueFactory<>("preu"));
        colData.setCellValueFactory(new PropertyValueFactory<>("data"));
        colMaxClients.setCellValueFactory(new PropertyValueFactory<>("maxClients"));

        Connection con = ConexioBD.getConnection();
        String consulta = "SELECT * FROM colectiu col JOIN cursos c ON col.id = c.id";

        try {
            PreparedStatement ps = con.prepareStatement(consulta);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Colectiu c = new Colectiu(rs.getInt("id"), rs.getString("nom"), rs.getString("dni"),
                        rs.getInt("preu"), rs.getDate("data").toLocalDate(),
                        rs.getInt("max_participants"));

                tblCursosCol.getItems().add(c);
            }
        } catch (SQLException e) {
            System.out.println("NO funcione la consulta");
            e.printStackTrace();
        }

        vb.getChildren().add(tblCursosCol);

        tblCursosCol.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            Colectiu curCol;

            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                curCol = (Colectiu) newValue;

                if (curCol != null) {
                    txtCurColId.setText(String.valueOf(curCol.getId()));
                    txtCurColNom.setText(curCol.getNom());
                    txtCurColMonitor.setText(curCol.getMonitor());
                    txtCurColPreu.setText(String.valueOf(curCol.getPreu()));
                    txtCurColData.setText(curCol.getData().toString());
                    txtCurColMaxCli.setText(String.valueOf(curCol.getMaxClients()));
                    txtCurColCantPersones.setText("1");
                    txtCurColDescomteFN.setText(getDescomteFN());
                    txtCurColPreuFinal.setText(getPreuFinal());

                }

                cursCom.setVisible(false);
                cursCol.setVisible(true);
                cursIn.setVisible(false);

                txtCurColCantPersones.setOnAction(ev -> {
                    int cant = Integer.parseInt(txtCurColCantPersones.getText());

                    Double preuF;

                    if (client.getCarnetFn() != null) {
                        preuF = (curCol.getPreu() * cant) * 0.6;

                    } else {

                        preuF = (curCol.getPreu() * cant);
                    }

                    txtCurColPreuFinal.setText(String.valueOf(preuF));

                });

            }

            private String getPreuFinal() {

                int cant = Integer.parseInt(txtCurColCantPersones.getText());

                Double preuF;

                if (client.getCarnetFn() != null) {
                    preuF = (curCol.getPreu() * cant) * 0.6;

                } else {

                    preuF = (curCol.getPreu() * cant);
                }

                String preuFi = String.valueOf(preuF);

                return preuFi;
            }

            private String getDescomteFN() {

                if (client.getCarnetFn() != null) {
                    return "40";
                }

                return null;
            }

        });

        return vb;
    }

    private Pane cursosIndividuals() {
        VBox vb = new VBox();

        TableView<Individual> tblCursosIn = new TableView<>();
        TableColumn<Individual, String> colId = new TableColumn<>("ID");
        TableColumn<Individual, String> colNom = new TableColumn<>("Nom");
        TableColumn<Individual, String> colPreu = new TableColumn<>("Preu Hora");

        tblCursosIn.getColumns().addAll(colId, colNom, colPreu);

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPreu.setCellValueFactory(new PropertyValueFactory<>("preuH"));

        Connection con = ConexioBD.getConnection();
        String consulta = "SELECT * FROM individual i JOIN cursos c ON i.id = c.id";

        try {
            PreparedStatement ps = con.prepareStatement(consulta);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Individual c = new Individual(rs.getInt("id"), rs.getString("nom"), rs.getString("dni"),
                        rs.getInt("preu/h"));

                tblCursosIn.getItems().add(c);
            }
        } catch (SQLException e) {
            System.out.println("NO funcione la consulta");
            e.printStackTrace();
        }

        vb.getChildren().add(tblCursosIn);

        tblCursosIn.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            Individual curIn;

            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                curIn = (Individual) newValue;

                if (curIn != null) {
                    txtCurInId.setText(String.valueOf(curIn.getId()));
                    txtCurInNom.setText(curIn.getNom());
                    txtCurInMonitor.setText(curIn.getMonitor());
                    txtCurInPreuH.setText(String.valueOf(curIn.getPreuH()));
                    txtCurInHores.setText("2");
                    txtCurInData.setText(" ");
                    txtCurInDescomte.setText("20");
                    txtCurInPreuFinal.setText(getPreuFinal());

                }

                cursCom.setVisible(false);
                cursCol.setVisible(false);
                cursIn.setVisible(true);

                txtCurInHores.setOnAction(ev -> {

                    int h = Integer.parseInt(txtCurInHores.getText());
                    double desc = 0.8;

                    if (h <= 2) {
                        txtCurInDescomte.setText("20");
                        desc = 0.8;
                    } else if (h >= 3 && h <= 5) {
                        txtCurInDescomte.setText("30");
                        desc = 0.7;
                    } else if (h >= 6) {
                        txtCurInDescomte.setText("50");
                        desc = 0.5;
                    }

                    double ph = (curIn.getPreuH() * h) * desc;

                    txtCurInPreuFinal.setText(String.valueOf(ph));

                });

            }

            private String getPreuFinal() {
                int h = Integer.parseInt(txtCurInHores.getText());

                double ph = (curIn.getPreuH() * h) * 0.8;

                return String.valueOf(ph);
            }

        });

        return vb;
    }

    private Pane lateralEsquera() {
        VBox vesquera = new VBox();

        vesquera.getChildren().add(new Label("Clients"));
        vesquera.setAlignment(Pos.CENTER);

        TableView<Client> tblClient = new TableView<>();
        TableColumn<Client, String> colDni = new TableColumn<>("DNI");
        TableColumn<Client, String> colNom = new TableColumn<>("Nom");
        TableColumn<Client, String> colCognom1 = new TableColumn<>("Cognom1");
        TableColumn<Client, String> colCognom2 = new TableColumn<>("Cognom2");

        tblClient.getColumns().addAll(colDni, colNom, colCognom1, colCognom2);

        colDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colCognom1.setCellValueFactory(new PropertyValueFactory<>("cognom1"));
        colCognom2.setCellValueFactory(new PropertyValueFactory<>("cognom2"));

        Connection con = ConexioBD.getConnection();
        String consulta = "SELECT * FROM clients C left join federats F on C.dni = F.dni left join familia_nombrosa FN on C.dni = FN.dni";

        try {
            PreparedStatement ps = con.prepareStatement(consulta);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Client c = new Client(rs.getString("dni"), rs.getString("nom"), rs.getString("cognom_1"),
                        rs.getString("cognom_2"), rs.getDate("data_naixement").toLocalDate(),
                        rs.getString("sexe"), rs.getInt("tel"), rs.getString("correu_e"),
                        rs.getString("compte_Bancari"),
                        rs.getInt("num_fed"), getLocalDate(rs, "data_caduc_f"), rs.getInt("nivell"),
                        rs.getString("carnet_fn"), getLocalDate(rs, "data_caduc_fn"));

                tblClient.getItems().add(c);
            }
        } catch (SQLException e) {
            System.out.println("NO funcione la consulta");
            e.printStackTrace();
        }

        vesquera.getChildren().add(tblClient);

        tblClient.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                client = (Client) newValue;

                if (client != null) {
                    txtCliDni.setText(client.getDni());
                    txtCliNom.setText(client.getNom());
                    txtCliCognom1.setText(client.getCognom1());
                    txtCliCognom2.setText(client.getCognom2());
                    txtCliDataNaix.setText(client.getDataNaix().toString());
                    txtCliSexe.setText(client.getSexe());
                    txtCliTel.setText(String.valueOf(client.getTel()));
                    txtCliCorreu.setText(client.getCorreu());
                    txtCliCompteBanc.setText(client.getCompteBanc());

                    if (client.getNumFed() != 0) {
                        txtCliNumFed.setText(String.valueOf(client.getNumFed()));
                        txtCliDataCaducF.setText(client.getDataCaducF().toString());
                        txtCliNivell.setText(String.valueOf(client.getNivell()));
                    } else {
                        txtCliNumFed.setText(" ");
                        txtCliDataCaducF.setText(" ");
                        txtCliNivell.setText(" ");
                    }

                    if (client.getCarnetFn() != null) {
                        txtCliCarnetFn.setText(client.getCarnetFn());
                        txtCliDataCaducFN.setText(client.getDataCaducFN().toString());
                    } else {
                        txtCliCarnetFn.setText(" ");
                        txtCliDataCaducFN.setText(" ");
                    }

                }

            }

        });

        return vesquera;
    }

    static public LocalDate getLocalDate(ResultSet rs, String columnName) throws SQLException {
        String sqlDate = rs.getString(columnName);
        return sqlDate == null ? null : LocalDate.parse(sqlDate);
    }

    private Pane partInferior() {
        HBox hinferior = new HBox();

        Button btnLloga = new Button("Llogar Curs");
        Button btnNeteja = new Button("Netejar");

        btnLloga.setOnAction(e -> llogarCurs());
        btnNeteja.setOnAction(e -> netejarFormulari());

        hinferior.getChildren().addAll(btnLloga, btnNeteja);
        hinferior.setAlignment(Pos.CENTER);
        hinferior.setSpacing(10);

        return hinferior;
    }

    private Object llogarCurs() {
        return null;
    }

    private void netejarFormulari() {

        // Text en blanc

        txtCliNom.setText(" ");
        txtCliDni.setText(" ");
        txtCliCognom1.setText(" ");
        txtCliCognom2.setText(" ");
        txtCliDataNaix.setText(" ");
        txtCliSexe.setText(" ");
        txtCliTel.setText(" ");
        txtCliCorreu.setText(" ");
        txtCliCompteBanc.setText(" ");
        txtCliCarnetFn.setText(" ");
        txtCliDataCaducFN.setText(" ");
        txtCliDataCaducF.setText(" ");
        txtCliNumFed.setText(" ");
        txtCliNivell.setText(" ");

        cursCol.setVisible(false);
        cursCom.setVisible(false);
        cursIn.setVisible(false);

    }

    private Pane partSuperior() {
        HBox hb = new HBox();

        hb.getChildren().add(new Label("Titol"));
        hb.setAlignment(Pos.CENTER);

        return hb;
    }

    private Pane formulariCentral() {

        VBox vb = new VBox();

        VBox vbCli = new VBox();

        Label lblTitCli = new Label("DADES CLIENTS");
        lblTitCli.setFont(new Font(20));
        lblTitCli.setTextFill(Color.web("#6cb9e9"));

        GridPane gpClients = new GridPane();

        Label lblDni = new Label("DNI:");
        Label lblNom = new Label("Nom:");
        Label lblCognom1 = new Label("Cognom1:");
        Label lblCognom2 = new Label("Cognom2:");
        Label lblDataNaix = new Label("DataNaix:");
        Label lblSexe = new Label("Sexe:");
        Label lblTel = new Label("Tel:");
        Label lblCorreu = new Label("Correu:");
        Label lblCompteBanc = new Label("CompteBanc:");
        Label lblNumFed = new Label("Num Federat:");
        Label lblDataCaducF = new Label("Data Caduc Fed:");
        Label lblNivell = new Label("Nivell:");
        Label lblCarnetFn = new Label("Carnt FN:");
        Label lblDataCaducFN = new Label("Caduc Carnet FN:");

        txtCliDni = new TextField();
        txtCliNom = new TextField();
        txtCliCognom1 = new TextField();
        txtCliCognom2 = new TextField();
        txtCliDataNaix = new TextField();
        txtCliSexe = new TextField();
        txtCliTel = new TextField();
        txtCliCorreu = new TextField();
        txtCliCompteBanc = new TextField();
        txtCliNumFed = new TextField();
        txtCliDataCaducF = new TextField();
        txtCliNivell = new TextField();
        txtCliCarnetFn = new TextField();
        txtCliDataCaducFN = new TextField();

        txtCliDni.setDisable(true);
        txtCliNom.setDisable(true);
        txtCliCognom1.setDisable(true);
        txtCliCognom2.setDisable(true);
        txtCliDataNaix.setDisable(true);
        txtCliSexe.setDisable(true);
        txtCliTel.setDisable(true);
        txtCliCorreu.setDisable(true);
        txtCliCompteBanc.setDisable(true);
        txtCliNumFed.setDisable(true);
        txtCliDataCaducF.setDisable(true);
        txtCliNivell.setDisable(true);
        txtCliCarnetFn.setDisable(true);
        txtCliDataCaducFN.setDisable(true);

        gpClients.add(lblDni, 0, 0);
        gpClients.add(lblNom, 0, 1);
        gpClients.add(lblCognom1, 0, 2);
        gpClients.add(lblCognom2, 0, 3);
        gpClients.add(lblDataNaix, 0, 4);
        gpClients.add(lblSexe, 0, 5);
        gpClients.add(lblTel, 0, 6);
        gpClients.add(lblCorreu, 0, 7);
        gpClients.add(lblCompteBanc, 0, 8);
        gpClients.add(lblNumFed, 0, 9);
        gpClients.add(lblDataCaducF, 0, 10);
        gpClients.add(lblNivell, 0, 11);
        gpClients.add(lblCarnetFn, 0, 12);
        gpClients.add(lblDataCaducFN, 0, 13);

        gpClients.add(txtCliDni, 1, 0);
        gpClients.add(txtCliNom, 1, 1);
        gpClients.add(txtCliCognom1, 1, 2);
        gpClients.add(txtCliCognom2, 1, 3);
        gpClients.add(txtCliDataNaix, 1, 4);
        gpClients.add(txtCliSexe, 1, 5);
        gpClients.add(txtCliTel, 1, 6);
        gpClients.add(txtCliCorreu, 1, 7);
        gpClients.add(txtCliCompteBanc, 1, 8);
        gpClients.add(txtCliNumFed, 1, 9);
        gpClients.add(txtCliDataCaducF, 1, 10);
        gpClients.add(txtCliNivell, 1, 11);
        gpClients.add(txtCliCarnetFn, 1, 12);
        gpClients.add(txtCliDataCaducFN, 1, 13);

        gpClients.setAlignment(Pos.CENTER);

        vbCli.getChildren().addAll(lblTitCli, gpClients);
        vbCli.setAlignment(Pos.CENTER);

        StackPane cursos = new StackPane();

        cursCol = new VBox();

        Label lblTitCurCol = new Label("DADES CURSOS COLECTIUS");
        lblTitCurCol.setFont(new Font(20));
        lblTitCurCol.setTextFill(Color.web("#6cb9e9"));

        GridPane gpCurCol = new GridPane();

        Label lblCurColId = new Label("ID:");
        Label lblCurColNom = new Label("Nom:");
        Label lblCurColMonitor = new Label("Dni Monitor:");
        Label lblCurColPreu = new Label("Preu:");
        Label lblCurColData = new Label("Data:");
        Label lblCurColMaxCli = new Label("Max Clients:");
        Label lblCurColDescomteFN = new Label("Descomte FN:");
        Label lblCurColPreuFinal = new Label("Preu Final:");
        Label lblCurColCantPersones = new Label("Cant Persones:");

        txtCurColId = new TextField();
        txtCurColNom = new TextField();
        txtCurColMonitor = new TextField();
        txtCurColPreu = new TextField();
        txtCurColData = new TextField();
        txtCurColMaxCli = new TextField();
        txtCurColDescomteFN = new TextField();
        txtCurColPreuFinal = new TextField();
        txtCurColCantPersones = new TextField();

        txtCurColId.setDisable(true);
        txtCurColNom.setDisable(true);
        txtCurColMonitor.setDisable(true);
        txtCurColPreu.setDisable(true);
        txtCurColData.setDisable(true);
        txtCurColMaxCli.setDisable(true);
        txtCurColDescomteFN.setDisable(true);
        txtCurColPreuFinal.setDisable(true);

        gpCurCol.add(lblCurColId, 0, 0);
        gpCurCol.add(lblCurColNom, 0, 1);
        gpCurCol.add(lblCurColMonitor, 0, 2);
        gpCurCol.add(lblCurColPreu, 0, 3);
        gpCurCol.add(lblCurColData, 0, 4);
        gpCurCol.add(lblCurColMaxCli, 0, 5);
        gpCurCol.add(lblCurColDescomteFN, 0, 6);
        gpCurCol.add(lblCurColPreuFinal, 0, 7);
        gpCurCol.add(lblCurColCantPersones, 0, 8);

        gpCurCol.add(txtCurColId, 1, 0);
        gpCurCol.add(txtCurColNom, 1, 1);
        gpCurCol.add(txtCurColMonitor, 1, 2);
        gpCurCol.add(txtCurColPreu, 1, 3);
        gpCurCol.add(txtCurColData, 1, 4);
        gpCurCol.add(txtCurColMaxCli, 1, 5);
        gpCurCol.add(txtCurColDescomteFN, 1, 6);
        gpCurCol.add(txtCurColPreuFinal, 1, 7);
        gpCurCol.add(txtCurColCantPersones, 1, 8);

        gpCurCol.setAlignment(Pos.CENTER);

        cursCol.getChildren().addAll(lblTitCurCol, gpCurCol);
        cursCol.setAlignment(Pos.CENTER);
        cursCol.setVisible(false);

        cursCom = new VBox();

        Label lblTitCurCom = new Label("DADES CURSOS COMPETICIO");
        lblTitCurCom.setFont(new Font(20));
        lblTitCurCom.setTextFill(Color.web("#6cb9e9"));

        GridPane gpCurCom = new GridPane();

        Label lblCurComId = new Label("ID:");
        Label lblCurComNom = new Label("Nom:");
        Label lblCurComMonitor = new Label("Dni Monitor:");
        Label lblCurComPreu = new Label("Preu:");
        Label lblCurComNivell = new Label("Nivell:");
        Label lblCurComDataIn = new Label("Data Inici:");
        Label lblCurComDataFi = new Label("Data Fi:");
        Label lblCurComDurada = new Label("Durada:");

        txtCurComId = new TextField();
        txtCurComNom = new TextField();
        txtCurComMonitor = new TextField();
        txtCurComPreu = new TextField();
        txtCurComNivell = new TextField();
        txtCurComDataIn = new TextField();
        txtCurComDataFi = new TextField();
        txtCurComDurada = new TextField();

        txtCurComId.setDisable(true);
        txtCurComNom.setDisable(true);
        txtCurComMonitor.setDisable(true);
        txtCurComPreu.setDisable(true);
        txtCurComNivell.setDisable(true);
        txtCurComDataIn.setDisable(true);
        txtCurComDataFi.setDisable(true);
        txtCurComDurada.setDisable(true);

        gpCurCom.add(lblCurComId, 0, 0);
        gpCurCom.add(lblCurComNom, 0, 1);
        gpCurCom.add(lblCurComMonitor, 0, 2);
        gpCurCom.add(lblCurComPreu, 0, 3);
        gpCurCom.add(lblCurComNivell, 0, 4);
        gpCurCom.add(lblCurComDataIn, 0, 5);
        gpCurCom.add(lblCurComDataFi, 0, 6);
        gpCurCom.add(lblCurComDurada, 0, 7);

        gpCurCom.add(txtCurComId, 1, 0);
        gpCurCom.add(txtCurComNom, 1, 1);
        gpCurCom.add(txtCurComMonitor, 1, 2);
        gpCurCom.add(txtCurComPreu, 1, 3);
        gpCurCom.add(txtCurComNivell, 1, 4);
        gpCurCom.add(txtCurComDataIn, 1, 5);
        gpCurCom.add(txtCurComDataFi, 1, 6);
        gpCurCom.add(txtCurComDurada, 1, 7);

        gpCurCom.setAlignment(Pos.CENTER);

        cursCom.getChildren().addAll(lblTitCurCom, gpCurCom);
        cursCom.setAlignment(Pos.CENTER);
        cursCom.setVisible(false);

        cursIn = new VBox();

        Label lblTitCurIn = new Label("DADES CURSOS INDIVIDUALS");
        lblTitCurIn.setFont(new Font(20));
        lblTitCurIn.setTextFill(Color.web("#6cb9e9"));

        GridPane gpCurIn = new GridPane();

        Label lblCurInId = new Label("ID:");
        Label lblCurInNom = new Label("Nom:");
        Label lblCurInMonitor = new Label("Dni Monitor:");
        Label lblCurInPreuH = new Label("Preu/h:");
        Label lblCurInHores = new Label("Hores:");
        Label lblCurInData = new Label("Data:");
        Label lblCurInDescomte = new Label("Descomte:");
        Label lblCurInPreuFinal = new Label("Preu Final:");

        txtCurInId = new TextField();
        txtCurInNom = new TextField();
        txtCurInMonitor = new TextField();
        txtCurInPreuH = new TextField();
        txtCurInHores = new TextField();
        txtCurInData = new TextField();
        txtCurInDescomte = new TextField();
        txtCurInPreuFinal = new TextField();

        txtCurInId.setDisable(true);
        txtCurInNom.setDisable(true);
        txtCurInMonitor.setDisable(true);
        txtCurInPreuH.setDisable(true);
        txtCurInDescomte.setDisable(true);
        txtCurInPreuFinal.setDisable(true);

        gpCurIn.add(lblCurInId, 0, 0);
        gpCurIn.add(lblCurInNom, 0, 1);
        gpCurIn.add(lblCurInMonitor, 0, 2);
        gpCurIn.add(lblCurInPreuH, 0, 3);
        gpCurIn.add(lblCurInHores, 0, 4);
        gpCurIn.add(lblCurInData, 0, 5);
        gpCurIn.add(lblCurInDescomte, 0, 6);
        gpCurIn.add(lblCurInPreuFinal, 0, 7);

        gpCurIn.add(txtCurInId, 1, 0);
        gpCurIn.add(txtCurInNom, 1, 1);
        gpCurIn.add(txtCurInMonitor, 1, 2);
        gpCurIn.add(txtCurInPreuH, 1, 3);
        gpCurIn.add(txtCurInHores, 1, 4);
        gpCurIn.add(txtCurInData, 1, 5);
        gpCurIn.add(txtCurInDescomte, 1, 6);
        gpCurIn.add(txtCurInPreuFinal, 1, 7);

        gpCurIn.setAlignment(Pos.CENTER);

        // txtCurInHores.setOnAction(ev -> {

        // int h = Integer.parseInt(txtCurInHores.getText());
        // double desc = 0.8;

        // if (h <= 2) {
        // txtCurInDescomte.setText("20");
        // desc = 0.8;
        // } else if (h >= 3 && h <= 5) {
        // txtCurInDescomte.setText("30");
        // desc = 0.7;
        // } else if (h >= 6) {
        // txtCurInDescomte.setText("50");
        // desc = 0.5;
        // }

        // double ph = curIn.getPreuH() * h;

        // });

        cursIn.getChildren().addAll(lblTitCurIn, gpCurIn);
        cursIn.setAlignment(Pos.CENTER);
        cursIn.setVisible(false);

        cursos.getChildren().addAll(cursCol, cursCom, cursIn);
        cursos.setAlignment(Pos.CENTER);

        vb.getChildren().addAll(vbCli, cursos);
        vb.setAlignment(Pos.CENTER);

        return vb;
    }

}
