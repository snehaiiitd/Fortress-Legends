//dependencies has to be added by the TA
public class TestRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Controller1Test.class);

        // Print test results
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println("Test successful: " + result.wasSuccessful());
    }
}
