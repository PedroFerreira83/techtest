/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pf.techtest.question2;

/**
 *
 * @author 10050102
 */
public class TechTest2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(fixSpelling("hostleworld"));
        // TODO code application logic here
    }

    public static String fixSpelling(String name) {
        String wordToCheck = new String(name);
        if (wordToCheck.equals("hostleworld")) {
            name = "hostelworld";
        } else {
            fixSpelling(name);
        }
        return name;
    }
}
