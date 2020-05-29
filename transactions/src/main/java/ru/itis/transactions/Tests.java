package ru.itis.transactions;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Tests {

    @MyTransaction
    public String t1(String uuid, String string) {
        System.out.println("Method t1, uuid was = " + uuid);
        return string;
    }

    @MyTransaction
    public void t2(String uuid) {
        System.out.println("T2");
    }

    @MyTransaction
    public int t3(String uuid) {
        return 5;
    }
}
