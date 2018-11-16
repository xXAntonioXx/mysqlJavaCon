/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
        String query = "SELECT * FROM cliente";
        ResultSet rs = db.Consulta(query);
        
        try {
            
            ResultSetMetaData meta = rs.getMetaData();
            
            
            rs.last();
            String[][] resultados = new String[rs.getRow()][meta.getColumnCount()];
            rs.first();
            
            //System.out.println(rs.getString(2));
            int contadorRenglon=0;
            do{
                for (int i = 0; i < meta.getColumnCount(); i++) {
                    //System.out.println(rs.getString(i));
                    resultados[contadorRenglon][i]=rs.getString(i+1);
                }
                contadorRenglon++;
            }while(rs.next());
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.print(" "+resultados[i][j]);
                }
                System.out.println("");
            }
            //System.out.println(rs.getRow());
        } catch (SQLException e) {

        }
        /*String insert = "INSERT INTO pendientes VALUES(1,'Este pendientes proviene de java',NULL,NULL)";
        db.Insertar(insert);*/
        
        /*String update = "UPDATE asunto SET fecha_fin = '2018-11-16', estatus = 'concluido' WHERE id=1";
        db.Insertar(update);*/
    }

}
