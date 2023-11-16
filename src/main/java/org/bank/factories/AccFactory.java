package org.bank.factories;

import com.google.inject.Inject;
import org.bank.account.AccountNumService;

public abstract class AccFactory {
    @Inject
    protected AccountNumService accountNumService;

}