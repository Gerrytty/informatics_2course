package ru.itis.transactions;

import org.springframework.stereotype.Service;

@Service
public class Tests {

    @MyTransaction
    public String t1(String uuid, String string) {
        System.out.println("Method t1, uuid was = " + uuid);
        return string;
    }

}
