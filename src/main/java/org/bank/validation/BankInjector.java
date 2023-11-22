package org.bank.validation;

import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;
import org.bank.json.IJsonGenerator;
import org.bank.json.JsonGson;
import org.bank.print.ConsoleLog;
import org.bank.print.ILogger;

public class BankInjector extends AbstractModule {
    private final EventBus eventBus = new EventBus();
    protected void configure()
    {
        this.bind(ILogger.class).to(ConsoleLog.class);
        this.bind(IJsonGenerator.class).to(JsonGson.class);
        this.bind(EventBus.class).toInstance(eventBus);
        bindListener(Matchers.any(), new TypeListener() {
            public <I> void hear(TypeLiteral<I> type, TypeEncounter<I> encounter) {
                encounter.register(new InjectionListener<I>(){
                    public void afterInjection(I i) {
                        eventBus.register(i);
                    }
                });
            }
        });
    }
}