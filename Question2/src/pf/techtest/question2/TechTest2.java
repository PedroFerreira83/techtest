
package pf.techtest.question2;

/**
 *
 * @author Pedro Ferreira
 */
public class TechTest2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(fixSpelling("hostleworld"));
      
    }

    public static String fixSpelling(String name) {
        String wordToCheck = new String(name);
        /* in order to compare strings we should use the method equals 
        instead of "==" comparator that is used for objects or simple types.*/
        if (wordToCheck.equals("hostleworld")) {
            name = "hostelworld";
        } /* the else bellow makes an infinit loop in cases that name string is
        not equal to "hostleworld" */
        /* else {
            fixSpelling(name);
        }*/
        return name;
    }
}
