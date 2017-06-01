
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pf.techtest.question1;
import java.util.Arrays;
/**
 *
 * @author PF
 */
public class TechTest1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println(checkAnagrams("Punishment", "Nine Thumps"));
        System.out.println(checkAnagrams("The Morse code", "Here come dots"));
        System.out.println(checkAnagrams("Snooze alarms", "Alas! No more Zs"));
        System.out.println(checkAnagrams("Halley's Comet", "Shall yet come"));
        System.out.println(checkAnagrams("One good turn deserves another.", "Do rogues endorse that? No,never!"));
       
    }

    /**
     * Given two strings, check if they’re anagrams or not
     * <p>
     * This method always checks if two strings are anagrams and return the result
     * @param string1 the first string to check
     * @param string2 the second string to check
     * @return the result of anagram validation
     */
    public static boolean checkAnagrams(String string1, String string2) {

        //remove non char and use lower case
        String testString1= string1.replaceAll("[^a-zA-Z]","").toLowerCase();
       String testString2= string2.replaceAll("[^a-zA-Z]","").toLowerCase();         
         
        // string to array
        char[] testArray1 = testString1.toCharArray();
        char[] testArray2 = testString2.toCharArray();

        // sort arrays
        Arrays.sort(testArray1);
        Arrays.sort(testArray2);
        
        //check if arrays are equals
        return Arrays.equals(testArray1, testArray2);
    }
}
