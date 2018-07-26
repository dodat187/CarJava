/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex02_25072018_car;

import java.sql.SQLException;

/**
 *
 * @author doduy
 */
public class MediumCar extends Cars {
    
    private boolean Driver;

    public boolean isDriver() {
        return Driver;
    }

    public void setDriver(boolean Driver) {
        Driver = rd.nextBoolean();
        this.Driver = Driver;
    }
    
    public void nhaphDriver(){
        this.setDriver(Driver);
    }

    public void inThongtin() throws SQLException, ClassNotFoundException {
        try {
            // Lấy ra đối tượng Connection kết nối vào DB.
            //Connection con = SQLServerConnUtils_SQLJDBC.getSQLServerConnection();
            // Tạo đối tượng Statement.
            //Statement statement = con.createStatement();
            Connected();
            String sql = "Select * from MediumCar";
            // Thực thi câu lệnh SQL trả về đối tượng ResultSet.
            rs = stm.executeQuery(sql);
            // Duyệt trên kết quả trả về.
            while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp.
                String icarid = rs.getString(1);
                int inumber = rs.getInt(2);
                int iyear = rs.getInt(3);
                String ibrand = rs.getString(4);
                String ihaveinsu = rs.getString(5);
                String hdriver = rs.getString(6);
                System.out.println("--------------------");
                System.out.println("CarID:" + icarid);
                System.out.println("NumberPlate:" + inumber);
                System.out.println("YearofManu:" + iyear);
                System.out.println("Brand:" + ibrand);
                System.out.println("HaveInsu:" + ihaveinsu);
                System.out.println("HandDriver:" + hdriver);
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
