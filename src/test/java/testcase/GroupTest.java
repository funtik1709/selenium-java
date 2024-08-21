package testcase;

import common.CommonDataSetup;
import org.testng.annotations.*;

@Test(groups="mainTest")
public class GroupTest extends CommonDataSetup {


    @AfterClass
    public void AfterClass() {
        System.out.println("Test. After Class");
    }

    @Test(priority=1,groups="headerTest")
    public void testOne() {
        System.out.println("Test One");
    }

    @Test(priority=2,groups="headerTest")
    public void testTwo() {
        System.out.println("Test Two");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Test. Before Class Run");
    }

    @Test(priority=3, groups="searchTest")
    public void testThree() {
        System.out.println("Test Three. searchTest");
    }

    @Test(priority=4, groups="searchTest")
    public void testFour() {
        System.out.println("Test Four. searchTest");
    }

    @Test(priority=5, groups="searchTest")
    public void testFive() {
        System.out.println("Test Five. searchTest");
    }

    @Test(priority=6, groups={"searchTest","carouselTest"})
    public void testSix() {
        System.out.println("Test Six. searchTest. carouselTest");
    }

    @Test(priority=7, groups="carouselTest")
    public void testSeven() {
        System.out.println("Test Seven");
    }

    @BeforeGroups(value="searchTest")
    public void testEight() {
        System.out.println("Test Eight. Before Search");
    }

    @AfterGroups(value="searchTest")
    public void testNine() {
        System.out.println("Test Nine. After Search");
    }
}
