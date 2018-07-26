/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex02_25072018_car;

import ConnectSQL.SQLServerConnUtils_SQLJDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author doduy
 */
public class Cars {

    private String IDCar;
    private int NumberPlate;
    private int YearManu;
    private String Brand;
    private boolean HaveInsu;

    Random rd = new Random();
    Connection con;
    Statement stm;
    ResultSet rs;

    void Connected() throws SQLException, ClassNotFoundException {
        Connection con = SQLServerConnUtils_SQLJDBC.getSQLServerConnection();
        Statement stm = con.createStatement();
    }

    public void Cars() {

    }
//
//    public String genId(String lastID, String prefixID) throws SQLException, ClassNotFoundException {
//        Connected();
//        String sql = "SELECT IDCar FROM MyCars WHERE IDCar = (SELECT max(IDCar) FROM MyCars)";
//        rs = stm.executeQuery(sql);
//        while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp.
//            String carID = rs.getString(1);
//            if (carID.equalsIgnoreCase("")) {
//                return prefixID + "01";
//            }
//            System.out.println(carID);
//            int nID = Integer.parseInt(carID.substring(5, carID.length()) + 1);
//            int nextID = nID + 1;
//            System.out.println(nextID);
//            int lengthNumberID = lastID.length() - prefixID.length();
//            String zeroNumber = "";
//            for (int i = 1; i <= lengthNumberID; i++) {
//                if (nextID < Math.pow(10, i)) {
//                    for (int j = 1; j <= lengthNumberID - i; j++) {
//                        zeroNumber += "0";
//                    }
//                    return prefixID + zeroNumber + nextID;
//                }
//            }
//        }
//        return prefixID + nextID;
//    }
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

    public String getIDCar() {
        return IDCar;
    }

    public void setIDCar(String IDCar) {
        this.IDCar = IDCar;
    }

    public int getNumberPlate() {
        return NumberPlate;
    }

    public void setNumberPlate(int NumberPlate) {
        NumberPlate = (int) (rd.nextInt(99999 - 10000 + 1) + 10000);
        this.NumberPlate = NumberPlate;
    }

    public int getYearManu() {
        return YearManu;
    }

    public void setYearManu(int iYearManu) {
        iYearManu = (int) (rd.nextInt(32 + 1) + 1980);
        this.YearManu = iYearManu;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String Brand) {
        List<String> givenList = Arrays.asList("HONDA", "TOYOTA", "HYUNDAI", "BMW", "LandRover", "FORD", "KIA", "MERC");
        Brand = givenList.get(rd.nextInt(givenList.size()));
        this.Brand = Brand;
    }

    public boolean isHaveInsu() {
        return HaveInsu;
    }

    public void setHaveInsu(boolean HaveInsu) {
        HaveInsu = rd.nextBoolean();
        this.HaveInsu = HaveInsu;
    }

    public Cars(String IDCar, int NumberPlate, int YearManu, String Brand, boolean HaveInsurance) {
        this.IDCar = getIDCar();
        this.NumberPlate = getNumberPlate();
        this.YearManu = getYearManu();
        this.Brand = getBrand();
        this.HaveInsu = isHaveInsu();
    }

    public Cars() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-TV115F9\\SQLEXPRESS;databasename=JavaCars;"
                    + "username=sa;password=sa");
            stm = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
        }
    }

    public void nhapThongtin() throws SQLException, ClassNotFoundException {
        try {
            Connected();
            loadID();
            this.setIDCar(lastID);
            this.setNumberPlate(NumberPlate);
            this.setYearManu(YearManu);
            this.setBrand(Brand);
            this.setYearManu(YearManu);
            this.setHaveInsu(HaveInsu);
            String sql = "INSERT INTO MyCars([IDCar],[NumberPlate],[YearManu],[Brand],[HaveInsu]) VALUES('" + getIDCar() + "','" + getNumberPlate() + "','" + getYearManu() + "','" + getBrand() + "','" + isHaveInsu() + "')";
            stm.executeUpdate(sql);
            if (getYearManu() >= 2005) {
                nhapModernCar();
            } else {
                if (getYearManu() <= 1995) {
                    nhapOldCar();
                } else {
                    nhapMediumCar();
                }
            }
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

    public void nhapModernCar() throws SQLException, ClassNotFoundException {
        try {
            Connected();
            ModernCar xemoi = new ModernCar();
            xemoi.nhapGps();
            String sql = "INSERT INTO ModernCar([IDCar],[NumberPlate],[YearManu],[Brand],[HaveInsu],[GPS]) VALUES('" + getIDCar() + "','" + getNumberPlate() + "','" + getYearManu() + "','" + getBrand() + "','" + isHaveInsu() + "','" + xemoi.getGps() + "')";
            stm.executeUpdate(sql);
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

    public void nhapOldCar() throws SQLException, ClassNotFoundException {
        try {
            Connected();
            OldCar xecu = new OldCar();
            xecu.nhapADura(this.getYearManu());
            String sql = "INSERT INTO OldCar([IDCar],[NumberPlate],[YearManu],[Brand],[HaveInsu],[ActionDuration]) VALUES('" + getIDCar() + "','" + getNumberPlate() + "','" + getYearManu() + "','" + getBrand() + "','" + isHaveInsu() + "','" + xecu.getDuration() + "')";
            stm.executeUpdate(sql);
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

    public void nhapMediumCar() throws SQLException, ClassNotFoundException {
        try {
            Connected();
            MediumCar xetrung = new MediumCar();
            xetrung.nhaphDriver();
            String sql = "INSERT INTO MediumCar([IDCar],[NumberPlate],[YearManu],[Brand],[HaveInsu],[HandDriver]) VALUES('" + getIDCar() + "','" + getNumberPlate() + "','" + getYearManu() + "','" + getBrand() + "','" + isHaveInsu() + "','" + xetrung.isDriver() + "')";
            stm.executeUpdate(sql);
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

    public String toString() {
        return this.getIDCar() + " - " + this.getNumberPlate() + " - " + this.getYearManu() + " - " + this.getBrand() + " - " + this.isHaveInsu();
    }

    public void inThongtin() throws SQLException, ClassNotFoundException {
        try {
            // Lấy ra đối tượng Connection kết nối vào DB.
            //Connection con = SQLServerConnUtils_SQLJDBC.getSQLServerConnection();
            // Tạo đối tượng Statement.
            //Statement statement = con.createStatement();
            Connected();
            String sql = "Select IDCar, NumberPlate, YearManu, Brand, HaveInsu from MyCars";
            // Thực thi câu lệnh SQL trả về đối tượng ResultSet.
            rs = stm.executeQuery(sql);
            // Duyệt trên kết quả trả về.
            while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp.
                String icarid = rs.getString(1);
                int inumber = rs.getInt(2);
                int iyear = rs.getInt(3);
                String ibrand = rs.getString(4);
                String ihaveinsu = rs.getString(5);
                System.out.println("--------------------");
                System.out.println("CarID:" + icarid);
                System.out.println("NumberPlate:" + inumber);
                System.out.println("YearofManu:" + iyear);
                System.out.println("Brand:" + ibrand);
                System.out.println("HaveInsu:" + ihaveinsu);

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
