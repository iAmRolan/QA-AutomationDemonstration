package Pages.WebPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Rolan Abdualiev , Dec 2021
 * @project QA-AutomationDemonstration
 */
public class SearchDashboardPage {

    @FindBy(css = "div.css-1schass > input")
    private static WebElement searchInput;

    @FindBy(css = "div.css-3tu9gd > div:nth-child(1)")
    private static WebElement dashboardFound;

    // Getters.
    public WebElement getSearchInput(){
        return searchInput;
    }

    public WebElement getDashboardFound(){
        return dashboardFound;
    }
}
