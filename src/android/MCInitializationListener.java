package com.salesforce.marketingcloud.cordova;

import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.MCLogListener;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.MarketingCloudSdk;
import com.salesforce.marketingcloud.registration.RegistrationManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class MCInitializationListener implements MarketingCloudSdk.InitializationListener {

    @Override
    public void complete(@NonNull InitializationStatus status) {
        if (status.isUsable()) {
            MarketingCloudSdk.requestSdk(new MarketingCloudSdk.WhenReadyListener() {
                @Override
                public void ready(@NonNull MarketingCloudSdk marketingCloudSdk) {
                    RegistrationManager registrationManager =
                            marketingCloudSdk.getRegistrationManager();
                    registrationManager.edit().addTag("Cordova").commit();
                }
            });
        }
    }
}