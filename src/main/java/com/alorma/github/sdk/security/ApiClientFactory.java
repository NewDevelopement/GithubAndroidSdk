package com.alorma.github.sdk.security;

import android.content.Context;
import android.text.TextUtils;

import com.alorma.github.basesdk.ApiClient;
import com.alorma.github.basesdk.client.StoreCredentials;

/**
 * Created by a557114 on 07/09/2015.
 */
public class ApiClientFactory {

    public static ApiClient getApiClient(Context context) {
        StoreCredentials credentials = new StoreCredentials(context);
        String hostname = credentials.hostname();
        if (TextUtils.isEmpty(hostname)) {
            return new GitHub();
        } else {
            return new GitHubEnterprise(hostname);
        }
    }

}
