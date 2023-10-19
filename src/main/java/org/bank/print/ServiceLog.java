package org.bank.print;

import com.google.inject.Inject;
import org.bank.account.BaseAcc;

public class ServiceLog {

    @Inject
    private ILogger printService;

    public void balanceLog(BaseAcc acc)
    {
        this.printService.balanceLog(acc);
    }

    public void debug(String message) {
        this.printService.debug(message);
    }

    public void accNumLog(BaseAcc acc)
    {
        this.printService.accNumLog(acc);
    }
}
