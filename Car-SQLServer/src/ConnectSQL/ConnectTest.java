/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectSQL;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author doduy
 */
public class ConnectTest {

    private Connection conn;

    public ConnectTest() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-TV115F9\\SQLEXPRESS;databasename=JavaCars;"
                    + "username=sa;password=sa");
            System.out.println("Connected Success");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connected Fail");
        }
    }

    public static void main(String[] args) {
//        Connect connect = new Connect();
        try {
            String dbURL = "jdbc:sqlserver://DESKTOP-TV115F9\\SQLEXPRESS;databaseName=JavaCars;user=sa;password=sa";
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                System.out.println("Connected");
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
            }
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
        }
    }
}
