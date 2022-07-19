package com.example.PageObjects;

import com.example.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class B_OrganizationPage extends BaseClass {
    public static WebDriver weBdriver;

    public B_OrganizationPage(WebDriver ldriver){
        this.weBdriver=ldriver;
        PageFactory.initElements(ldriver,this);
    }

    public void clickOrganizationsMenu(){
        WebElement orgSearchMenu=weBdriver.findElement(By.id("organizationSearchMenuOption"));
        orgSearchMenu.click();
    }

    public void typeIntoCTEPID(){
        WebElement ctepID=weBdriver.findElement(By.id("ctepID"));
        ctepID.click();
        ctepID.sendKeys("OH029");
    }

    public void selectOrganizationType(){
        WebElement orgType=weBdriver.findElement(By.id("functionalRole"));
        orgType.click();
        WebElement dropdown = weBdriver.findElement(By.id("functionalRole"));
        dropdown.findElement(By.xpath("//option[. = 'Participating Site']")).click();
    }

    public void clickSearch(){
        WebElement searchBtn=weBdriver.findElement(By.cssSelector(".search"));
        searchBtn.click();
    }

    public void assertion_method(){
        String assertText="Case Western Reserve University";
        System.out.println(weBdriver.findElement(By.cssSelector("tr.odd > td:nth-of-type(3)")).getText());
        Assert.assertTrue(assertText.equals(weBdriver.findElement(By.cssSelector("tr.odd > td:nth-of-type(3)")).getText()));
        //String assertText="7434";
        //Assert.assertTrue(assertText.equals(weBdriver.findElement(By.cssSelector(".odd > td:nth-child(1)")).getText()));
        //WebElement searchText=weBdriver.findElement(By.cssSelector("#row > tbody > tr > td:nth-child(3)"));//"tr.odd > td:nth-of-type(3)"));
        //Assert.assertEquals(searchText,"Case Western Reserve University");
    }

    public void clickLogout(){
        WebElement logout=weBdriver.findElement(By.cssSelector("#userarea > a"));
        logout.click();
    }
}
