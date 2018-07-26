/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex02_25072018_car;

import ConnectSQL.SQLServerConnUtils_SQLJDBC;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author doduy
 */
public class Insurance extends InsurancePack {

    Connection con;
    Statement stm;
    ResultSet rs;

    void Connected() throws SQLException, ClassNotFoundException {
        Connection con = SQLServerConnUtils_SQLJDBC.getSQLServerConnection();
        Statement stm = con.createStatement();
    }
    private String idInsure;

    public String getIdInsure() {
        return idInsure;
    }

    public void setIdInsure(String idInsure) {
        this.idInsure = idInsure;
    }
    
    String lastID = "";
    String prefixID = "Car#";
    String nextID = "";
    
    private String loadID() throws SQLException, ClassNotFoundException {
        Connected();
        String sql = "SELECT IDCar FROM MyCars WHERE IDCar = (SELECT max(IDCar) FROM MyCars)";
        rs = stm.executeQuery(sql);
        while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp.
            String carID = rs.getString(1);
            if (carID != null) {
                int nID = Integer.parseInt(carID.substring(4, carID.length()));
                int nextID = nID + 1;
                int lengthNumberID = carID.length() - prefixID.length();
                String zeroNumber = "";
                for (int i = 1; i <= lengthNumberID; i++) {
                    if (nextID < Math.pow(10, i)) {
                        for (int j = 1; j <= lengthNumberID - i; j++) {
                            zeroNumber += "0";
                        }
                    }
                }
                lastID = prefixID + zeroNumber + nextID;
                break;
            } else {
                carID = prefixID + "01";
                break;
            }

        }
        return lastID;
    }
    
    public void nhapThongtin() throws SQLException, ClassNotFoundException {
        try {
            Connected();
            loadID();
            //String sql = "INSERT INTO MyCars([IDCar],[NumberPlate],[YearManu],[Brand],[HaveInsu]) VALUES('" + getIDCar() + "','" + getNumberPlate() + "','" + getYearManu() + "','" + getBrand() + "','" + isHaveInsu() + "')";
            //stm.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (con != null) {
                try {
                    stm.close();
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
    }
    
    public void inThongtin() throws SQLException, ClassNotFoundException {
        try {
            Connected();
            String sql = "Select * from Insurance";
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                String idInsure = rs.getString(1);
                String typePack = rs.getString(2);
                System.out.println("--------------------");
                System.out.println("IdInsurance:" + idInsure);
                System.out.println("PackageType:" + idInsure);
            }
            // Đóng kết nối
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (con != null) {
                try {
                    stm.close();
                    con.close();
                } catch (SQLException e) {
                }
            }
        }

    }
}
