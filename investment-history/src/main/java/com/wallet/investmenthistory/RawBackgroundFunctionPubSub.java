package com.wallet.investmenthistory;

import com.google.cloud.functions.Context;
import com.google.cloud.functions.RawBackgroundFunction;
import com.wallet.investmenthistory.service.GreetingService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named("job")
@ApplicationScoped
public class RawBackgroundFunctionPubSub implements RawBackgroundFunction {

    final GreetingService greetingService;

    public RawBackgroundFunctionPubSub(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @Override
    public void accept(String event, Context context) throws Exception {
        System.out.println("PubSub event: " + event);
        System.out.println("Be polite, say " + greetingService.hello());
    }
}
