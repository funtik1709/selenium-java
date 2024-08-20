package testcase;

import org.testng.annotations.Test;

@Test(groups="mainTest")
public class GroupTest {


    @Test(priority=1, groups="headerTest")
    public void testOne() {
        System.out.println("Test One. Before Class Run");
    }

    @Test(priority=2,groups="headerTest")
    public void testTwo() {
        System.out.println("Test Two");
    }

    @Test(priority=3, groups="headerTest")
    public void testThree() {
        System.out.println("Test Three");
    }

    @Test(priority=4, groups="searchTest")
    public void testFour() {
        System.out.println("Test Four");
    }

    @Test(priority=5, groups="searchTest")
    public void testFive() {
        System.out.println("Test Five");
    }

    @Test(priority=6, groups={"searchTest","carouselTest"})
    public void testSix() {
        System.out.println("Test Six");
    }

    @Test(priority=7, groups="carouselTest")
    public void testSeven() {
        System.out.println("Test Seven");
    }
}
