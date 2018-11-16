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
 * @author AntonioGonzalez1
 */
public class DataBase {

    private String USER = "root";
    private String PASS = "Discord1";
    private String CON_STR = "jdbc:mysql://localhost:3306/jm?useSSL=false";

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
    
    public void Insertar(String insert){
        try{
           Statement stm = this.con.createStatement();
        stm.executeUpdate(insert); 
        }catch(SQLException e){
            System.out.println("Error al Actualizar/Insertar "+e.getMessage());
        }
        
    }
    
    public String[][] ConvertirMatriz(ResultSet rs){
        try{
            
            //obtenemos los metadatos
            ResultSetMetaData meta = rs.getMetaData();//obtenemos los metadatos
            int ColumnasCant=meta.getColumnCount();//aqui tenemos la cantidad de columnas que tiene la tabla
            rs.last();
            int RenglonesCant=rs.getRow();//aqui tenemos la cantidad de renglones
            rs.first();
            
            //matriz a devolver (solo inicializada)
            String[][] resultados = new String[RenglonesCant][ColumnasCant];
            
            int contadorRenglon=0;
            do{
                for (int i = 0; i < ColumnasCant; i++) {
                    resultados[contadorRenglon][i]=rs.getString(i+1);
                }
                
                contadorRenglon++;
            }while(rs.next());
            
            return resultados;
        }catch(SQLException e){
            System.out.println("error al convertir en matriz: "+e.getMessage());
            
            return null;
        }
        
    }
    
    public void imprimirMatriz(String[][] resultados){
        int renglones=resultados.length;
        int columnas = resultados[0].length;
        for (int i = 0; i < renglones; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(" "+resultados[i][j]);
            }
            System.out.println("");
        }
    }
}
