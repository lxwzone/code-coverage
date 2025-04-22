package org.test;

public class HelloServiceTest {


    @org.junit.Test
    public void testRun() {
        HelloService helloService = new HelloService();
        helloService.run();
    }
}
