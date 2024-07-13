package com.wallet.investmenthistory.service;

import com.wallet.investmenthistory.RawBackgroundFunctionPubSub;
import org.junit.jupiter.api.Test;

class DownloadServiceTest {

    @Test
    void dowload() throws Exception {
        RawBackgroundFunctionPubSub rawBackgroundFunctionPubSub = new RawBackgroundFunctionPubSub(new DownloadService());
        rawBackgroundFunctionPubSub.accept(null, null);
    }
}