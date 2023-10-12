package org.bank.print;

import org.bank.account.BaseAcc;

public interface ILogger {
    void balanceLog(BaseAcc acc);
    void debug(String message);

    void accNumLog(BaseAcc acc);
}
