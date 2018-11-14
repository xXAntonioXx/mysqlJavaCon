/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jose Antonio G
 */
public class DataBase {

    private String USER = "root";
    private String PASS = "Discord1";
    private String CON_STR = "jdbc:mysql://localhost:3306/todo?useSSL=false";

    private Connection con;

    public DataBase() {
        try {
            this.con = (Connection) DriverManager.getConnection(this.CON_STR, this.USER, this.PASS);
            System.out.println("conexion exitosa");
        } catch (SQLException e) {
            System.out.println("conexion fallida" + e.getMessage());
        }
    }

    public ResultSet Consulta(String query) {
        try {
            Statement stm = this.con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            rs.next();
            return rs;
        } catch (SQLException e) {
            System.out.println("Error en metodo Consulta: " + e.getMessage());
            return null;
        }
    }
}
