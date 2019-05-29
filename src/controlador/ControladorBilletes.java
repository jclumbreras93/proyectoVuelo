package controlador;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import modelo.Asiento;
import modelo.conectar;

public class ControladorBilletes implements Initializable {

    conectar cnx = new conectar();

    List<String[]> listaReservas = new ArrayList<>();
    List<String> ListaFactura = new ArrayList<>();
    List<String> ListaVuelos = new ArrayList<>();
    Paragraph parIt;
    @FXML
    private GridPane gpAsientos;

    @FXML
    private Button V_I_0;

    @FXML
    private Button C_I_0;
    @FXML
    public Label lbUser;

    @FXML
    private Button P_I_0;

    @FXML
    private Button P_D_0;

    @FXML
    private Button C_D_0;

    @FXML
    private Button V_D_0;

    @FXML
    private Button V_I_1;

    @FXML
    private Button C_I_1;

    @FXML
    private Button P_I_1;

    @FXML
    private Button P_D_1;

    @FXML
    private Button C_D_1;

    @FXML
    private Button V_D_1;

    @FXML
    private Button V_I_2;

    @FXML
    private Button C_I_2;

    @FXML
    private Button P_I_2;

    @FXML
    private Button P_D_2;

    @FXML
    private Button C_D_2;

    @FXML
    private Button V_D_2;

    @FXML
    private Button V_I_3;

    @FXML
    private Button C_I_3;

    @FXML
    private Button P_I_3;

    @FXML
    private Button P_D_3;

    @FXML
    private Button C_D_3;

    @FXML
    private Button V_D_3;

    @FXML
    private Button V_I_4;

    @FXML
    private Button C_I_4;

    @FXML
    private Button P_I_4;

    @FXML
    private Button P_D_4;

    @FXML
    private Button C_D_4;

    @FXML
    private Button V_D_4;
    @FXML
    private Label lbIni;
    @FXML
    private ImageView imgLogo;

    @FXML
    private Button V_I_5;

    @FXML
    private Button C_I_5;

    @FXML
    private Button P_I_5;

    @FXML
    private Button P_D_5;

    @FXML
    private Button C_D_5;

    @FXML
    private Button V_D_5;

    @FXML
    private Button V_I_6;

    @FXML
    private Button C_I_6;

    @FXML
    private Button P_I_6;

    @FXML
    private Button P_D_6;

    @FXML
    private Button C_D_6;

    @FXML
    private Button V_D_6;

    @FXML
    private Button V_I_7;

    @FXML
    private Button C_I_7;

    @FXML
    private Button P_I_7;

    @FXML
    private Button P_D_7;

    @FXML
    private Button C_D_7;

    @FXML
    private Button V_D_7;

    @FXML
    private Button V_I_8;

    @FXML
    private Button C_I_8;

    @FXML
    private Button P_I_8;

    @FXML
    private Button P_D_8;

    @FXML
    private Button C_D_8;

    @FXML
    private Button V_D_8;

    @FXML
    private Button V_I_9;

    @FXML
    private Button C_I_9;

    @FXML
    private Button P_I_9;

    @FXML
    private Button P_D_9;

    @FXML
    private Button C_D_9;

    @FXML
    private Button V_D_9;

    @FXML
    private Button V_I_10;

    @FXML
    private Button C_I_10;

    @FXML
    private Button P_I_10;

    @FXML
    private Button P_D_10;

    @FXML
    private Button C_D_10;

    @FXML
    private Button V_D_10;

    @FXML
    private Button V_I_11;

    @FXML
    private Button C_I_11;

    @FXML
    private Button P_I_11;

    @FXML
    private Button P_D_11;

    @FXML
    private Button C_D_11;

    @FXML
    private Button V_D_11;

    @FXML
    private Button V_I_12;

    @FXML
    private Button C_I_12;

    @FXML
    private Button P_I_12;

    @FXML
    private Button P_D_12;

    @FXML
    private Button C_D_12;

    @FXML
    private Button V_D_12;

    @FXML
    private Button V_I_13;

    @FXML
    private Button C_I_13;

    @FXML
    private Button P_I_13;

    @FXML
    private Button P_D_13;

    @FXML
    private Button C_D_13;

    @FXML
    private Button V_D_13;

    @FXML
    private Button V_I_14;

    @FXML
    private Button C_I_14;

    @FXML
    private Button P_I_14;

    @FXML
    private Button P_D_14;

    @FXML
    private Button C_D_14;

    @FXML
    private Button V_D_14;

    @FXML
    private Label lbFSalida;
    @FXML
    private ComboBox<String> cbVuelos;

    @FXML
    void accionElegirVuelo(ActionEvent event) {
        cargarBotones(Integer.parseInt(cbVuelos.getValue()));
    }

    @FXML
    void handleButtonAction(ActionEvent event) {

        Button b = (Button) event.getSource();

        String idAsiento = b.getId();

        String[] partes = idAsiento.split("_");
        Asiento a = new Asiento();
        a.setIdAsiento(idAsiento);
        a.setFila(partes[2]);
        if (partes[0].equals("V")) {
            a.setTipo("Ventanilla");
        } else if (partes[0].equals("C")) {
            a.setTipo("Central");
        } else if (partes[0].equals("P")) {
            a.setTipo("Pasillo");
        }
        //igual para averigual el bloque Derecho o izquierdo
        if (partes[1].equals("D")) {
            a.setBloque("Derecho");
        } else {
            a.setBloque("Izquierdo");
        }

        int idVuelo = Integer.parseInt(cbVuelos.getValue());//Vueloelegido en el comboBox
        String user="";
        user = cnx.comprobarAsientoCancelar(idAsiento);//Guardo en user el usuario al que corresponde el asiento seleccionado
        if (lbUser.getText().equals("admin") && b.getText().equals("Reservado")) {//Si el usuario es admin puede cancelar lo que quiera
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("IberiasTu");
            alerta.setHeaderText("Cancelar Reserva");
            alerta.setContentText("¿Estas Seguro?");
            Optional<ButtonType> resultado = alerta.showAndWait();
            if (resultado.get() == ButtonType.OK) {
                if (cnx.cancelarReserva(idAsiento, idVuelo)) {
                    Alert alerta2 = new Alert(Alert.AlertType.INFORMATION);
                    alerta2.setContentText("Cancelación correcta");
                    alerta2.showAndWait();
                    cargarBotones(idVuelo);
                }
            }
        } else if (b.getText().equals("Reservado") && lbUser.getText().equals(user)) {//Cancelacion solo para los asientos del usuario logueado
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("IberiasTu");
            alerta.setHeaderText("Cancelar Reserva");
            alerta.setContentText("¿Estas Seguro?");
            Optional<ButtonType> resultado = alerta.showAndWait();
            if (resultado.get() == ButtonType.OK) {
                if (cnx.cancelarReserva(idAsiento, idVuelo)) {
                    Alert alerta2 = new Alert(Alert.AlertType.INFORMATION);
                    alerta2.setContentText("Cancelación correcta");
                    alerta2.showAndWait();
                    cargarBotones(idVuelo);
                }
            }

        } else {
            if (!b.getText().equals("Reservado")) {//Reserva de asiento 
                Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                alerta.setTitle("IberiasTu");
                alerta.setHeaderText("Confirmar Reserva");
                alerta.setContentText("¿Estas Seguro?");
                Optional<ButtonType> resultado = alerta.showAndWait();
                if (resultado.get() == ButtonType.OK) {
                    ListaFactura.clear();
                    ListaFactura = cnx.insertarAsiento(a, idVuelo, lbUser.getText());
                    if (!ListaFactura.isEmpty()) {
                        Alert alerta2 = new Alert(Alert.AlertType.INFORMATION);
                        alerta2.setContentText("Compra Realizada con exito");
                        alerta2.setTitle("IberiasTu");
                        alerta2.showAndWait();
                        b.setStyle("-fx-background-color:#0B615E");
                        b.setText("Reservado");
                        String salida = cnx.obtenerFechaSalida(idVuelo);
                        String vuelo = String.valueOf(idVuelo);
                        crearPDF(idVuelo, ListaFactura, idAsiento);
                    } else {
                        Alert alerta2 = new Alert(Alert.AlertType.ERROR);
                        alerta2.setContentText("Error al comprar");
                        alerta2.showAndWait();
                    }
                }
            } else {
                Alert alerta2 = new Alert(Alert.AlertType.ERROR);
                alerta2.setTitle("IberiasTu");
                alerta2.setContentText("Asiento reservado");
                alerta2.showAndWait();
            }
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources
    ) {
        cnx.conectar();

        //cargarBotones(1);
        cargarCombo();
    }

    private void cargarBotones(int idVuelo) {
        lbIni.setVisible(false);
        imgLogo.setVisible(false);
        boolean fPasada = cnx.comprobarFechaVuelo(idVuelo);
        //construye la lista con los identificadores de asiento ya reservados
        listaReservas.clear();
        listaReservas = cnx.ListaReservas(idVuelo);
//for each que recorre todos los botones para localizar los existentes en listaReservas
        for (Node nodo : gpAsientos.getChildren()) {
            Button b = (Button) nodo;
            //obtener el id
            b.setVisible(true);
            String asiento = b.getId();
            //hago la partición en un vector de 3 posiciones
            String[] partes = asiento.split("_");
            int fila = Integer.parseInt(partes[2]);
            if (fila >= 0 && fila <= 2) {
                b.setText("Business");
                b.setStyle("-fx-background-color:green");
            } else if (fila >= 3 && fila <= 6) {
                b.setText("Primera");
                b.setStyle("-fx-background-color:blue");
            } else {
                b.setText("turista");
                b.setStyle("-fx-background-color:orange");
            }
            if (fPasada) {
                b.setDisable(true);
                lbFSalida.setText("Salió el " + cnx.obtenerFechaSalida(idVuelo));
            } else {
                b.setDisable(false);
                lbFSalida.setText("Sale el " + cnx.obtenerFechaSalida(idVuelo));
            }

            //recorrer la lista de reservas del vuelo seleccionado
            //comparar con el nodo b donde estoy para averiguar si está o no reservado
            for (String[] lista : listaReservas) {
                if (lista[0].equals(b.getId())) {
                    b.setText("Reservado");
                    if (lista[1].equals(lbUser.getText())) {

                        b.setStyle("-fx-background-color:#0B615E");

                    } else {
                        b.setStyle("-fx-background-color:red");
                    }
                    break;
                }

            }

        }

    }

    private void crearPDF(int idVuelo, List<String> vuelo, String idAsiento) {
// Se crea el documento
        Document documento = new Document();

// Se crea el OutputStream para el fichero donde queremos dejar el pdf.
        FileOutputStream ficheroPdf;

        //String ruta = "src/facturas/" + String.valueOf(idVuelo) + "_" + f.replace(" ", "") + lbUser.getText() + ".pdf";
        try {
            File carpeta = new File("src/facturas");
            if (!carpeta.exists()) {
                carpeta.mkdirs();//Creo la carpeta de facturas si no existe
            }
            //El nombre para que no se sobrescriba el fichero pdf 
            ficheroPdf = new FileOutputStream("src/facturas/" + String.valueOf(idVuelo) + "_" + idAsiento + lbUser.getText() + ".pdf");
            PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(20);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ControladorBilletes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(ControladorBilletes.class.getName()).log(Level.SEVERE, null, ex);
        }

// Se asocia el documento al OutputStream y se indica que el espaciado entre
// lineas sera de 20. Esta llamada debe hacerse antes de abrir el documento
// Se abre el documento.
        documento.open();

        try {
            //Logo de la empresa
            Image foto = Image.getInstance("src/imagenes/descarga.png");
            foto.scaleToFit(100, 100);
            foto.setAlignment(Chunk.ALIGN_RIGHT);
            documento.add(foto);
            //Nombre
            parIt = new Paragraph("Bienvenido a bordo " + lbUser.getText(), FontFactory.getFont("arial", 15, BaseColor.RED));
            parIt.setAlignment(Chunk.ALIGN_LEFT);
            documento.add(parIt);
            //Parrafo de info de lo que ve
            parIt = new Paragraph("Tu billete e itinerario\n", FontFactory.getFont("arial", 18, Font.ITALIC, BaseColor.RED));
            parIt.setAlignment(Chunk.ALIGN_LEFT);
            documento.add(parIt);

            //Parrafo en blanco para separar la tabla
            parIt = new Paragraph(" ");
            parIt.setAlignment(Chunk.ALIGN_LEFT);
            documento.add(parIt);

            PdfPTable tabla = new PdfPTable(5);
            for (int i = 0; i < 10; i++) {
                switch (i) {
                    case 0:
                        tabla.addCell("ID Vuelo");
                        break;
                    case 1:
                        tabla.addCell("Fecha Reserva");
                        break;
                    case 2:
                        tabla.addCell("Fecha Salida");
                        break;
                    case 3:
                        tabla.addCell("Clase");
                        break;
                    case 4:
                        tabla.addCell("Precio");
                        break;
                    case 5:
                        tabla.addCell(String.valueOf(idVuelo));
                        break;
                    case 6:
                        tabla.addCell(ListaFactura.get(0));//Fecha Reserva
                        break;
                    case 7:
                        tabla.addCell(ListaFactura.get(1));//Fecha Salida
                        break;
                    case 8:
                        tabla.addCell(ListaFactura.get(2));//Clase
                        break;
                    case 9:
                        tabla.addCell(ListaFactura.get(3) + "€");//Precio
                        break;
                }

            }

            documento.add(tabla);
            foto = Image.getInstance("src/imagenes/codigoB.png");
            foto.scaleToFit(100, 100);
            foto.setAlignment(Chunk.ALIGN_RIGHT);
            documento.add(foto);
            parIt = new Paragraph("El transporte realizado en virtud del presente contrato, en lo que respecta a la responsabilidad del transportista, está sujeto, al Convenio de Montreal y a lo dispuesto en el Reglamento (CE) Nº 2027/97 del Consejo de 9 de Octubre de 1997, modificado por el Reglamento (CE) Nº 889/2002 de 13 de mayo de 2002, relativo a la responsabilidad de las compañías aéreas respecto al transporte de los pasajeros y su equipaje.\n"
                    + "\n"
                    + "En tanto no se halle en contradicción con lo anterior, todo transporte realizado y demás servicios prestados por el transportista estarán sometidos a:\n"
                    + "\n"
                    + "Las condiciones que figuran en este billete.\n"
                    + "\n"
                    + "La tarifa aplicada y sus condiciones.\n"
                    + "\n"
                    + "Las demás condiciones de transporte establecidas por el transportista y las reglamentaciones conexas que forman parte del presente contrato y que pueden ser consultadas en las oficinas del transportista.\n"
                    + "\n"
                    + "El nombre del transportista contractual puede aparecer abreviado en el billete, siempre que el nombre completo y su abreviatura figuren en los manuales, reglamentaciones y horarios del transportista; la dirección del transportista contractual es la que figura al dorso del \"billete de pasaje\"; las escalas convenidas son aquellos puntos que se indican en el \"billete de pasaje\" o que figuran en los horarios del transportista como escalas previstas en el itinerario del pasajero; el transporte a realizar en virtud de este contrato por varios transportistas sucesivos se considerará como una sola operación.\n"
                    + "\n"
                    + "El transportista que emite un billete para las líneas de otro transportista, actúa sólo como agente de este último.\n"
                    + "\n"
                    + "Cualquier limitación de responsabilidad del transportista contractual se aplicará y beneficiará a sus agentes, empleados y representantes, así como al transportista de hecho, a sus dependientes y agentes, cuando actúen en el ejercicio de sus funciones.\n"
                    + "\n"
                    + "El equipaje facturado será entregado al portador del talón de equipaje. Si el equipaje facturado resultara dañado, el pasajero deberá presentar por escrito la oportuna protesta al transportista lo antes posible o, a lo sumo, en el plazo de siete (7) días y en caso de retraso en el plazo de veintiún (21) días, siempre referidos a días naturales o de calendario, a partir, en ambos casos de ser puesto el equipaje a disposición del pasajero.\n"
                    + "\n"
                    + "Este billete es válido para el transporte durante un año desde la fecha de emisión, a menos que se estipule otra cosa en el mismo, o en las tarifas aplicables y sus condiciones. El transportista puede negarse a efectuar el transporte si la tarifa aplicable no ha sido pagada.\n"
                    + "\n"
                    + "El transportista se compromete a esforzarse todo lo posible para transportar al pasajero y a su equipaje con diligencia razonable. En caso de necesidad el transportista puede hacerse sustituir por otro transportista, utilizar aviones de terceros y modificar o suprimir escalas previstas en el billete. Si el pasajero pierde un vuelo de conexión debido a una causa imputable a Iberia, el pasajero será reubicado en otro vuelo que le permita llegar a destino lo antes posible o, en su defecto, le será reembolsado un importe igual al precio del vuelo abonado, si no se ha utilizado ninguna parte del billete o la diferencia entre el precio pagado y la tarifa aplicable a los trayectos recorridos, si se ha utilizado una parte del billete.\n"
                    + "\n"
                    + "El pasajero deberá cumplir los requisitos gubernamentales establecidos para la realización del viaje y disponer de los documentos de salida, entrada y demás exigidos, así como llegar al aeropuerto a la hora señalada por el transportista en el aviso HORA LÍMITE DE ACEPTACIÓN AL VUELO.\n"
                    + "\n"
                    + "Ningún agente, empleado o representante del transportista tiene autoridad para alterar, modificar o renunciar a cualquiera de las condiciones de este contrato.\n", FontFactory.getFont("arial", 6, BaseColor.GRAY));
            parIt.setAlignment(Chunk.ALIGN_BOTTOM);
            documento.add(parIt);
        } catch (DocumentException ex) {
            Logger.getLogger(ControladorBilletes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ControladorBilletes.class.getName()).log(Level.SEVERE, null, ex);
        }
        documento.close();
        File path = new File("src/facturas/" + String.valueOf(idVuelo) + "_" + idAsiento + lbUser.getText() + ".pdf");
        try {
            Desktop.getDesktop().open(path);
        } catch (IOException ex) {
            Logger.getLogger(ControladorBilletes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void accionCerrarSesion(ActionEvent event) {
        Stage escenario = new Stage();
        FXMLLoader fXMLLoader = new FXMLLoader();

        fXMLLoader.setLocation(getClass().getResource("/vista/logueo.fxml"));
        try {
            Scene escena = new Scene(fXMLLoader.load());
            escenario.setScene(escena);
        } catch (IOException ex) {
            Logger.getLogger(LogueoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        escenario.setTitle("IberiasTu");
        escenario.initStyle(StageStyle.UNDECORATED);
        escenario.show();

        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    private void cargarCombo() {

        ListaVuelos.clear();
        ListaVuelos = cnx.listaVuelos();
        for (int i = 0; i < ListaVuelos.size(); i++) {
            cbVuelos.getItems().add(ListaVuelos.get(i));
        }
    }

}
