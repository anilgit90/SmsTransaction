package com.vrsoft.sms;

import com.vrsoft.sms.resources.Sms;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class SmsTransactionApplication extends Application<SmsTransactionConfiguration> {

    public static void main(final String[] args) throws Exception {
        new SmsTransactionApplication().run(args);
    }

    @Override
    public String getName() {
        return "SmsTransaction";
    }

    @Override
    public void initialize(final Bootstrap<SmsTransactionConfiguration> bootstrap) {

    }

    @Override
    public void run(final SmsTransactionConfiguration configuration,
                    final Environment environment) {
        final Sms sms = new Sms(configuration);
        environment.jersey().register(sms);
    }

}
