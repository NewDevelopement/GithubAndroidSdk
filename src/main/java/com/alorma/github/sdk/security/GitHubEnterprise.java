package com.alorma.github.sdk.security;

import com.alorma.github.basesdk.ApiClient;
import com.alorma.github.basesdk.client.credentials.GithubDeveloperCredentials;

/**
 * Created by Bernat on 08/07/2014.
 */
public class GitHubEnterprise implements ApiClient {

    private String endpoint;

    public GitHubEnterprise(String endpoint){
        if (GithubDeveloperCredentials.getInstance().getProvider() == null) {
            throw new IllegalArgumentException("Credentials provider cannot be null");
        }
        this.endpoint = endpoint;
    }

    @Override
    public String getApiOauthUrlEndpoint() {
        return endpoint;
    }

    @Override
    public String getApiEndpoint() {
        return endpoint + "/api/v3/";
    }

    @Override
    public String getType() {
        return "github";
    }

}
