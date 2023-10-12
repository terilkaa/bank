package org.bank.account;

import org.bank.people.Owner;

public class StudentAccFactory extends AccFactory{

    public StudentAcc createStudentAcc(Owner owner, double balance){
        return new StudentAcc(owner, accountNumService.accNum(), balance);
    }
}
