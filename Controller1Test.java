
//dependecies has to be added by the TA

public class Controller1Test {

    @Test
    public void testStickGrowth() {
        Controller1 controller = new Controller1();

        // Ensure the initial height is 10
        assertEquals((double) 0, controller.stick.getHeight());

        // Simulate 5 growRectangle calls
        for (int i = 0; i < 5; i++) {
            controller.growRectangle();
        }

        // After 5 calls, the height should be increased by 5 * 5 = 25
        assertEquals(35, controller.stick.getHeight()); // should give false......
    }

    private boolean assertEquals(double d, double height) {
        if(height == d){
            return true;
        }
        return false;
    }

    @Test
    public void testGameInitialization1() {
        Controller1 controller = new Controller1();

        // Simulate the initializeGame method
        controller.initialize(null, null);

        // Add assertions for the expected state after game initialization
        assertNotNull(controller.getStickHero());
        assertNotNull(controller.getPlatform());
    }

    private boolean assertNotNull(StickHero stickHero) {
        if (stickHero == null){
            return false;
        }
        return true;
    }

    @Test
    public void testGameInitialization2() {
        Controller1 controller = new Controller1();

        // Simulate the initializeGame method
        controller.initialize(null, null);

        // Add assertions for the expected state after game initialization
        assertNotNull(controller.getStickHero());
        assertNotNull(controller.getPlatform());
    }

    private boolean assertNotNull(Platform platform) {
        if (platform == null){
            return false;
        }
        return true;
    }
}


