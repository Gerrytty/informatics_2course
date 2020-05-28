package ru.itis.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RunCommand implements CommandLineRunner {

    private final Tests tests;

    @Autowired
    public RunCommand(Tests tests) {
        this.tests = tests;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("-----------------------------");
//        String s1 = tests.t1("1", "Hello");
//        String s2 = tests.t1("1", "Hi");
//        String s3 = tests.t1("2", "Hi!");
//        System.out.println(s1);
//        System.out.println(s2);
//        System.out.println(s3);
        tests.t2("3");
        tests.t2("3");

//        tests.t3("7");
    }
}