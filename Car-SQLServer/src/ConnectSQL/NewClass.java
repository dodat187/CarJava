/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectSQL;

import ex02_25072018_car.Cars;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author doduy
 */
public class NewClass {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection conn = SQLServerConnUtils_JTDS.getSQLServerConnection();
        Cars xe = new Cars();
        // Employees (id, full_name, gender, hire_date)
        // ID: Auto Increase
        String sql = "INSERT INTO MyCars([IDCar],[NumberPlate],[YearManu],[Brand],[HaveInsu]) VALUES('" + xe.getIDCar()  + "','" + xe.getNumberPlate() + "','" + xe.getYearManu() + "','" + xe.getBrand() + "','" + xe.getHaveInsu() + "')";
        
 
        // Create a PreparedStatement object.
        PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = pstm.getGeneratedKeys();
        int idValue = 1;
        while (rs.next()) {
            idValue = rs.getInt(1);
            idValue++;
        }
        System.out.println("ID value: " + idValue);
    }
}
