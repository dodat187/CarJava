/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex02_25072018_car;

import java.util.ArrayList;

/**
 *
 * @author doduy
 */
public class RandomID {

    public RandomID() {
    }

//Phuong thuc xu ly
    public static ArrayList generate(int number) {

//Khai bao thanh phan trung gian
        ArrayList tmp = new ArrayList();
        int count = 0;
        int value;
        boolean flag;
        while (count < number) {
            flag = false;
            value = (int) (Math.random() * 10000);//Gia su cac gia tri nam trong khoang tu 1 den 100
            for (int i = 0; i < tmp.size(); i++) {
                if (((Integer) tmp.get(i)).intValue() == value) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                tmp.add(value);
                count++;
            }
        }
        return tmp;
    }

    public static void main(String[] args) {
        ArrayList arrInt = RandomID.generate(1);
        System.out.print(arrInt);
    }

}
