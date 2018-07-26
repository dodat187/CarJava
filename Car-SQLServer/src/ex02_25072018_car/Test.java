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
public class Test {

    public static void main(String[] args) {
        String str = "Car#13";
        int nextID = Integer.valueOf(str.substring(4, str.length()));
        System.out.println(str.substring(4, str.length()));
        System.out.println(str.substring(0, 4) + (nextID+1));
        
    }
}
