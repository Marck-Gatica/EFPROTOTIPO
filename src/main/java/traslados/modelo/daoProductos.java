/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package traslados.modelo;

import logistica.modelo.*;
import seguridad.modelo.*;
import traslados.controlador.clsProductos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoProductos {

    private static final String SQL_SELECT = "SELECT prodcodigo, prodnombre, prodexistencia, prodestatus FROM tbl_productos;";
    private static final String SQL_INSERT = "INSERT INTO tbl_productos(prodcodigo, prodnombre, prodexistencia, prodestatus) VALUES(?, ?, ?, ?)";
    
     private static final String SQL_UPDATE = "UPDATE tbl_productos SET prodnombre=?, prodexistencia=?, prodestatus=? WHERE prodcodigo = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_productos WHERE prodcodigo=?";
    private static final String SQL_QUERY  = "SELECT prodcodigo, prodnombre, prodexistencia, prodestatus FROM tbl_productos  WHERE prodcodigo = ?";

    public List<clsProductos> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsProductos perfil = null;
        List<clsProductos> perfiles = new ArrayList<clsProductos>();
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int iPerfil_id = rs.getInt("prodcodigo");
                String Prodnombre =rs.getString("prodnombre");
                Float Prodexistencia = rs.getFloat("prodexistencia");
                 String Prodestatus = rs.getString("prodestatus");

                perfil = new clsProductos();
                perfil.setProdcodigo(iPerfil_id);
                 perfil.setProdnombre(Prodnombre);
                  perfil.setProdexistencia(Prodexistencia);
                   perfil.setProdestatus(Prodestatus);
          

                perfiles.add(perfil);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return perfiles;
    }

    public int insert(clsProductos perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1,  perfil.getProdcodigo());
            stmt.setString(2, perfil.getProdnombre());
            stmt.setFloat(3, perfil.getProdexistencia());
             stmt.setString(4, perfil.getProdestatus());       
         

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public int update(clsProductos perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
        
            stmt.setString(1, perfil.getProdnombre());
            stmt.setFloat(2, perfil.getProdexistencia());
             stmt.setString(3, perfil.getProdestatus());
               stmt.setInt(4, perfil.getProdcodigo());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public int delete(clsProductos perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, perfil.getProdcodigo());
                      rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public clsProductos query(clsProductos perfil) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, perfil.getProdcodigo()); //getId_perfil
            rs = stmt.executeQuery();
            while (rs.next()) {
               int iPerfil_id = rs.getInt("prodcodigo");
                String Prodnombre =rs.getString("prodnombre");
                Float Prodexistencia = rs.getFloat("prodexistencia");
                 String Prodestatus = rs.getString("prodestatus");

                perfil = new clsProductos();
                perfil.setProdcodigo(iPerfil_id);
                 perfil.setProdnombre(Prodnombre);
                  perfil.setProdexistencia(Prodexistencia);
                   perfil.setProdestatus(Prodestatus);
       
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return perfil;
    }
}
