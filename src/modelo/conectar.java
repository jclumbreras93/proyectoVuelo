/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author profesor
 */
public class conectar extends javax.swing.JList {

    Connection conexion;
    ResultSet rs;
    Statement s;
    DefaultListModel modelo;
    PreparedStatement pstm;
    PreparedStatement pstm2;
    String cadena = "Ui2ry0L6PI";
    String usuario = "Ui2ry0L6PI";
    String clave = "XkQvoVpebf";
    List<String> lista = new ArrayList<>();
    List<String[]> lista2 = new ArrayList<>();

    public void conectar() {
        try {
            // TODO add your handling code here:
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://remotemysql.com/"+cadena, usuario, clave);
            //conexion = DriverManager.getConnection("jdbc:mysql://localhost/aeropuerto", "root", "");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar la bd");
        }
        try {
            s = conexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<String[]> ListaReservas(int idVuelo) {
        lista2.clear();
        String cadenaSql = "select idAsiento,comprador from avion where idVuelo=?";
        try {
            pstm = conexion.prepareStatement(cadenaSql);
            pstm.setInt(1, idVuelo);
            rs = pstm.executeQuery();
            while (rs.next()) {
                lista2.add(new String[]{rs.getString("idAsiento"), rs.getString("comprador")});

            }
        } catch (SQLException ex) {
            Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista2;
    }

    public boolean cancelarReserva(String idAsientos, int idVuelo) {
        boolean resultado = false;
        String cadenaSql1 = "delete from avion where idAsiento=? and idVuelo=?";
        try {
            pstm = conexion.prepareStatement(cadenaSql1);
            pstm.setString(1, idAsientos);
            pstm.setInt(2, idVuelo);
            int x = pstm.executeUpdate();
            if (x == 1) {
                resultado = true;
            }
        } catch (Exception e) {

        }
        return resultado;
    }

    public boolean logueo(String user, String pass) {
        boolean resultado = false;

        try {
            String cadenaSql = "select * from usuarios where usuario=? and clave=?";
            pstm = conexion.prepareStatement(cadenaSql);
            pstm.setString(1, user);
            pstm.setString(2, pass);
            rs = pstm.executeQuery();
            if (rs.next()) {
                resultado = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }

    public boolean register(String user, String pass) {

        boolean resultado = false;

        try {
            String cadenaSql = "insert into usuarios values(?,?)";
            pstm = conexion.prepareStatement(cadenaSql);
            pstm.setString(1, user);
            pstm.setString(2, pass);

            pstm.executeUpdate();
            resultado = true;
        } catch (SQLException ex) {

        }

        return resultado;
    }

    public List<String> insertarAsiento(Asiento a, int idVuelo, String nombre) {
        lista.clear();
        String precio = "";
        long noches;
        int precioReserva = 0;
        Timestamp t2 = null;
        Timestamp t = new java.sql.Timestamp(new java.util.Date().getTime());
        String cadenaSql = "insert into avion values(?,?,?,?,?,?,?,?)";
        int fila = Integer.parseInt(a.getFila());
        if (fila >= 0 && fila <= 2) {
            precio = "precioBussines";
        } else if (fila >= 3 && fila <= 6) {
            precio = "precioPrimera";
        } else {
            precio = "precioTurista";
        }
        String cadenaPrecio = "select fechaSalida," + precio + " from horariosAviones where idVuelo=?";

        try {
            pstm2 = conexion.prepareStatement(cadenaPrecio);
            pstm2.setInt(1, idVuelo);
            rs = pstm2.executeQuery();
            while (rs.next()) {
                precioReserva = rs.getInt(precio);
                System.out.println(precioReserva);
                t2 = rs.getTimestamp("fechaSalida");

            }
            noches = t2.getTime() - t.getTime();
            if (noches > 7) {
                precioReserva = (int) (precioReserva * 0.1);
            } else if (noches <= 7 && noches >= 4) {
                precioReserva = precioReserva;
            } else if (noches <= 3 && noches >= 1) {
                precioReserva = (int) (precioReserva * 1.3);
            } else {
                precioReserva = (int) (precioReserva * 0.5);
            }
            System.out.println(precioReserva);
            ////////////////////////////////////////////////////////////////
            pstm = conexion.prepareStatement(cadenaSql);
            pstm.setInt(1, idVuelo);
            pstm.setString(2, a.getIdAsiento());
            pstm.setString(3, a.getFila());
            pstm.setString(4, a.getTipo());
            pstm.setString(5, a.getBloque());
            pstm.setString(6, nombre);
            pstm.setTimestamp(7, t);
            pstm.setInt(8, precioReserva);
            pstm.executeUpdate();
            String tR = new SimpleDateFormat("dd-MM-yyyy").format(t);
            String tS = new SimpleDateFormat("dd-MM-yyyy").format(t2);
            lista.add(String.valueOf(tR));
            lista.add(String.valueOf(tS));
            lista.add(precio);
            lista.add(String.valueOf(precioReserva));

        } catch (Exception e) {

        }

        return lista;

    }

    public boolean comprobarFechaVuelo(int idVuelo) {
        boolean resultado = false;
        long noches;
        Timestamp t2 = null;
        Timestamp t = new java.sql.Timestamp(new java.util.Date().getTime());
        String cadena = "select fechaSalida from horariosAviones where idVuelo=?";

        try {
            pstm2 = conexion.prepareStatement(cadena);
            pstm2.setInt(1, idVuelo);
            rs = pstm2.executeQuery();
            while (rs.next()) {

                t2 = rs.getTimestamp("fechaSalida");
            }
            noches = t2.getTime() - t.getTime();
            if (noches < 0) {
                resultado = true;
            } else {

            }

        } catch (Exception e) {

        }

        return resultado;
    }

    public String obtenerFechaSalida(int idVuelo) {
        String fV = "";
        Timestamp t2 = null;

        String cadena = "select fechaSalida from horariosAviones where idVuelo=?";

        try {
            pstm2 = conexion.prepareStatement(cadena);
            pstm2.setInt(1, idVuelo);
            rs = pstm2.executeQuery();
            if (rs.next()) {

                t2 = rs.getTimestamp("fechaSalida");
                fV = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(t2);
            }

        } catch (Exception e) {

        }
        return fV;

    }

    public List<String> listaVuelos() {
        lista.clear();
        String cadenaSql = "select idVuelo from horariosAviones";
        try {
            s = conexion.createStatement();
            rs = s.executeQuery(cadenaSql);
            while (rs.next()) {
                lista.add(rs.getString("idVuelo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public String comprobarAsientoCancelar(String idAsiento) {

        String resultado = "";

        try {
            String cadenaSql = "select comprador from avion where idAsiento=?";
            pstm = conexion.prepareStatement(cadenaSql);
            pstm.setString(1, idAsiento);
            
            rs = pstm.executeQuery();
            if (rs.next()) {
                resultado = rs.getString("comprador");
            }
        } catch (SQLException ex) {
            Logger.getLogger(conectar.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }

}
