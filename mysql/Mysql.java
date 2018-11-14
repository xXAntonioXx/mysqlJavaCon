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
public class Mysql {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        DataBase db = new DataBase();
        //db.DataBase();
        String query = "SELECT * FROM pendientes";
        ResultSet rs = db.Consulta(query);
        try {
            System.out.println(rs.getInt(1));
        } catch (SQLException e) {

        }

    }

}
