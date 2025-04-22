package org.test;

import java.util.ArrayList;
import java.util.List;

public class HelloService {

    private int i=0;

    public HelloService() {
        i= 11;
    }

    public void run() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
    }
}
