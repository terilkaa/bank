package org.bank.people;

import java.util.Random;

public class OwnerIdService {

    public int createOwnerId(){

        Random rnd = new Random();
        Integer num = (rnd.nextInt(10000));
        return num;
    }
}
