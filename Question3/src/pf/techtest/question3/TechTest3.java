package pf.techtest.question3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Pedro Ferreira
 */
public class TechTest3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {

        //test URL with 3 different dimensions and print result
        System.out.println(checkSortedList("http://www.hostelworld.com")); //Full Screen
        System.out.println(checkSortedList("http://www.hostelworld.com", 412, 732));
        System.out.println(checkSortedList("http://www.hostelworld.com", 768, 1024));
    }

    /**
     * Given URL and resolution performs a search and check if results are
     * correctly sorted
     * <p>
     * This method navigate the gets the text of each WebElement to a string
     * list and check if its correctly sorted
     * @param url contains the URL to navigate
     * @param dimension contains screen dimension and it is option. If it is not set means Full Screen.
     * @return the result of sorting validation
     */
    public static boolean checkSortedList(String url, int... dimension)  {
        // Create a new instance of Chrome driver
        WebDriver driver = new ChromeDriver();

        //set window dimension (Full Screen by default)
        if (dimension.length == 0) { // Full Screen
            driver.manage().window().maximize();
        } else {
            Dimension windowDimension = new Dimension(dimension[0], dimension[1]);
            driver.manage().window().setSize(windowDimension);
        }

        //Navigate Website
        driver.get(url);

        //find search box and set place do search
        WebElement searchBox = driver.findElement(By.id("home-search-keywords"));
        String searchString="Dublin, Ireland";
        searchBox.sendKeys(searchString);

        //wait until predictive search result is displayed
        (new WebDriverWait(driver, 5)).until((ExpectedCondition<Boolean>) (WebDriver d) -> {
            WebElement searchResult = d.findElement(By.linkText(searchString));
            return searchResult.getText().equals(searchString);
        });

        searchBox.sendKeys(Keys.TAB); //leave search list to get access to search button
        
        //click search button
        driver.findElement(By.className("orange_button")).click();

        //get all the possible Sort buttons (depends on screen resolution)
        List<WebElement> buttons = driver.findElements(By.xpath("//*[contains(@class, 'sort-button')]//span"));

        //find and click active sort button
        for (WebElement button : buttons) {
            if (button.isDisplayed()) {
                button.click();
                break;
            }
        }

        //click on sort by name option
        driver.findElement(By.id("sortByName")).click();

        //get list of all displayed Hostels
        List<WebElement> elements = driver.findElements(By.xpath("//h2/a[contains(@class, 'hwta-property-link')]"));

        //check if results are correctly sorted
        Boolean result = isSorted(elements);

        //close driver
        driver.quit();
        
        //return result of sorting validation
        return result;

    }

    /**
     * Given a List of WebElements check if elements are correctly sorted
     * <p>
     * This method gets the text of each WebElement to a string list and check
     * if its correctly sorted
     *
     * @param elements contains the list of WebElements
     * @return the result of sorting validation
     */
    public static boolean isSorted(List<WebElement> elements) {
        //get text of each element
        List<String> originalList = new ArrayList<>();
        elements.forEach(element -> originalList.add(element.getText()));

        //copy orignal list and sort it
        List<String> sortedList = new ArrayList<>(originalList);
        Collections.sort(sortedList);

        //return the result of sorting validation
        return sortedList.equals(originalList);
    }
}
