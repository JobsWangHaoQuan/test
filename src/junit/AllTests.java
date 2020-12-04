package junit;


import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {
    public static void main (String[] args) {
        junit.textui.TestRunner.run (suite());
    }
    public static Test suite ( ) {
        TestSuite suite= new TestSuite("All JUnit Tests");
        suite.addTest(ListTest.suite());
        suite.addTest(new TestSuite(junit.money.MoneyTest.class));
        suite.addTest(junit.AllTests.suite());
        return suite;
    }
}
