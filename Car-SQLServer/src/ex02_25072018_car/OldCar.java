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
public class OldCar extends Cars {

    private int Duration;

    public int getDuration() {
        return Duration;
    }

    public void setDuration(int Duration) {
        Duration = (int) (2018 - Duration);
        this.Duration = Duration;
    }
    
    public void nhapADura(int YearManu){
        this.setDuration(YearManu);
    }
    
    @Override
    public void inThongtin() throws SQLException, ClassNotFoundException {
        try {
            // Lấy ra đối tượng Connection kết nối vào DB.
            //Connection con = SQLServerConnUtils_SQLJDBC.getSQLServerConnection();
            // Tạo đối tượng Statement.
            //Statement statement = con.createStatement();
            Connected();
            String sql = "Select * from OldCar";
            // Thực thi câu lệnh SQL trả về đối tượng ResultSet.
            rs = stm.executeQuery(sql);
            // Duyệt trên kết quả trả về.
            while (rs.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp.
                String icarid = rs.getString(1);
                int inumber = rs.getInt(2);
                int iyear = rs.getInt(3);
                String ibrand = rs.getString(4);
                String ihaveinsu = rs.getString(5);
                int adura = rs.getInt(6);
                System.out.println("--------------------");
                System.out.println("CarID:" + icarid);
                System.out.println("NumberPlate:" + inumber);
                System.out.println("YearofManu:" + iyear);
                System.out.println("Brand:" + ibrand);
                System.out.println("HaveInsu:" + ihaveinsu);
                System.out.println("ActionDuration:" + adura);
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
