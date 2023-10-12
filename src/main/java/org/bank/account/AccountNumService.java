package org.bank.account;

import java.util.Random;

public class AccountNumService {
    public String accNum () {
        Random rnd = new Random();
        StringBuilder num = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            num.append(rnd.nextInt(10));
        }
        return num.toString();
    }
}
