package org.bank.validation;

import com.google.inject.AbstractModule;
import org.bank.print.ConsoleLog;
import org.bank.print.ILogger;

public class BankInejctor extends AbstractModule {
    protected void configure()
    {
        this.bind(ILogger.class).to(ConsoleLog.class);
    }
}
