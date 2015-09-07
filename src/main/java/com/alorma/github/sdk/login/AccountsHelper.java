package com.alorma.github.sdk.login;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by Bernat on 02/04/2015.
 */
public class AccountsHelper {
    private static final String ACCOUNT_SCOPES = "ACCOUNT_SCOPES";
    private static final String USER_PIC = "USER_PIC";
    private static final String USER_MAIL = "USER_MAIL";
    private static final String USER_NAME = "USER_NAME";
    private static final String API_HOSTNAME = "API_HOSTNAME";

    public static Bundle buildBundle(String name, String mail, String avatar, String scope, String currentHostname) {
        Bundle userData = new Bundle();

        userData.putString(AccountsHelper.ACCOUNT_SCOPES, scope);
        userData.putString(AccountsHelper.USER_PIC, avatar);
        userData.putString(AccountsHelper.USER_MAIL, mail);
        userData.putString(AccountsHelper.USER_NAME, name);

        if (currentHostname != null) {
            userData.putString(API_HOSTNAME, currentHostname);
        }

        return userData;
    }

    public static String getUserAvatar(Context context, Account account) {
        AccountManager manager = AccountManager.get(context);
        return manager.getUserData(account, USER_PIC);
    }

    public static String getUserMail(Context context, Account account) {
        AccountManager manager = AccountManager.get(context);
        return manager.getUserData(account, USER_MAIL);
    }

    public static String getUserName(Context context, Account account) {
        AccountManager manager = AccountManager.get(context);
        return manager.getUserData(account, USER_NAME);
    }

    public static String getUserScopes(Context context, Account account) {
        AccountManager manager = AccountManager.get(context);
        return manager.getUserData(account, ACCOUNT_SCOPES);
    }

    public static String getUserToken(Context context, Account account) {
        AccountManager manager = AccountManager.get(context);
        return manager.getUserData(account, AccountManager.KEY_AUTHTOKEN);
    }

    public static String getUserHostname(Context context, Account account) {
        AccountManager manager = AccountManager.get(context);
        return manager.getUserData(account, API_HOSTNAME);
    }
}
