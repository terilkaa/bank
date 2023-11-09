package org.bank.validation;

import com.google.inject.AbstractModule;
import org.bank.json.IJsonGenerator;
import org.bank.json.JsonGson;
import org.bank.print.ConsoleLog;
import org.bank.print.ILogger;

public class BankInjector extends AbstractModule {
    protected void configure()
    {
        this.bind(ILogger.class).to(ConsoleLog.class);
        this.bind(IJsonGenerator.class).to(JsonGson.class);
    }
}