package org.bank.account;

import com.google.inject.Inject;

public abstract class AccFactory {
    @Inject
    AccountNumService accountNumService;

}