/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex02_25072018_car;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author doduy
 */
public class NewMain {

    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        Cars xe = new Cars();
        ModernCar xemoi = new ModernCar();
        MediumCar xetrung = new MediumCar();
        OldCar xecu = new OldCar();
        Scanner sc = new Scanner(System.in);
        int numb;
        System.out.println("Các chức năng tương ứng số thứ tự.");
        System.out.println("1 -- Chức năng 1: Tạo ngẫu nhiên xe.");
        System.out.println("2 -- Chức năng 2: Show dữ liệu xe trong CSDL.");
        System.out.println("3 -- Chức năng 3: Show dữ liệu xe đời mới (Modern Car).");
        System.out.println("4 -- Chức năng 4: Show dữ liệu xe đời trung (Medium Car).");
        System.out.println("5 -- Chức năng 5: Show dữ liệu xe đời cũ (Old Car).");
        System.out.println("6 -- Chức năng 6: Tạo ngẫu nhiên gói Bảo Hiểm.");
        System.out.print("Mời bạn chọn chức năng :"); //sout + tab
        numb = sc.nextInt();
        switch (numb) {
            case 1: {
                System.out.println("1 -- Chức năng 1: Tạo ngẫu nhiên xe.");
                System.out.print("Nhập số lượng xe cần nhập: ");
                int n = sc.nextInt();
                Cars car[] = new Cars[n];
                for (int i = 0; i < car.length; i++) {
                    car[i] = new Cars();
                    car[i].nhapThongtin();
                }
            }
            break;
            case 2: {
                System.out.println("2 -- Chức năng 2: Show dữ liệu xe trong CSDL.");
                System.out.println("Danh sách xe có trong CSDL là: ");
                xe.inThongtin();
            }
            break;
            case 3: {
                System.out.println("3 -- Chức năng 3: Show dữ liệu xe đời mới (Modern Car).");
                System.out.println("Danh sách xe đời mới là: ");
                xemoi.inThongtin();
            }
            break;
            case 4: {
                System.out.println("4 -- Chức năng 4: Show dữ liệu xe đời trung (Medium Car).");
                System.out.println("Danh sách xe đời trung là: ");
                xetrung.inThongtin();
            }
            break;
            case 5: {
                System.out.println("5 -- Chức năng 5: Show dữ liệu xe đời cũ (Old Car).");
                System.out.println("Danh sách xe đời cũ là: ");
                xecu.inThongtin();
            }
            break;
            case 6: {
                System.out.println("6-- Chức năng 6: Tạo ngẫu nhiên gói Bảo Hiểm");
                System.out.print("Nhập số lượng gói Bảo Hiểm : ");
                int n = sc.nextInt();
                InsurancePack isp[] = new InsurancePack[n];
                for (int i = 0; i < isp.length; i++) {
                    isp[i] = new InsurancePack();
                    //isp[i].nhapThongtin();
                }
            }
            break;
            default: {
                System.out.println("Không hợp lệ");
            }
            break;
        }
    }
}
