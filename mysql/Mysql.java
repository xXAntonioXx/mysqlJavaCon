/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author AntonioGonzalez1
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

            String[][] resultados=db.ConvertirMatriz(rs);
            db.imprimirMatriz(resultados);
//            for (int i = 0; i < 5; i++) {
//                for (int j = 0; j < 4; j++) {
//                    System.out.print(" "+resultados[i][j]);
//                }
//                System.out.println("");
//            }
            //System.out.println(rs.getRow());
        } catch (Exception e) {
            System.out.println("ah habido un error: " + e.getMessage());
        }
        
        
        
        
        
        /*String insert = "INSERT INTO pendientes VALUES(1,'Este pendientes proviene de java',NULL,NULL)";
        db.Insertar(insert);*/
        
        /*String update = "UPDATE asunto SET fecha_fin = '2018-11-16', estatus = 'concluido' WHERE id=1";
        db.Insertar(update);*/
    }
    
}
