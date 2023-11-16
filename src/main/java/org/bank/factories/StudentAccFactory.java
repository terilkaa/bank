package org.bank.factories;

import org.bank.account.StudentAcc;
import org.bank.factories.AccFactory;
import org.bank.people.Owner;

public class StudentAccFactory extends AccFactory {

    public StudentAcc createStudentAcc(Owner owner, double balance){
        return new StudentAcc(owner, accountNumService.accNum(), balance);
    }
}
