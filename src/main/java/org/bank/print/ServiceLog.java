package org.bank.print;

import org.bank.account.BaseAcc;

public class ServiceLog {
    private ILogger printService;

    public ServiceLog()
    {
        this.printService = new ConsoleLog();
    }
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
