package org.bank.factories;

import org.bank.account.BaseAcc;
import org.bank.account.StudentAcc;
import org.bank.json.objects.BaseAccJsonSerialObj;
import org.bank.json.objects.StudentAccJsonSerialObj;

public class StudentAccJsonSerialFactory extends BaseAccJsonSerialFactory {
    public StudentAccJsonSerialObj createStudentAcc(StudentAcc acc){
        return new StudentAccJsonSerialObj(acc.getOwner().getId(), acc.getAccountNum(), acc.getBalance());
    }

}
