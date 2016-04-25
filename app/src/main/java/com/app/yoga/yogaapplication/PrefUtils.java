package com.app.yoga.yogaapplication;

import android.content.Context;

/**
 * Created by Lenovo on 4/24/2016.
 */
public class PrefUtils {
    public static void setCurrentUser(User currentUser, Context context){
        ComplexPreferences complexPreferences= ComplexPreferences.getComplexPreferences(context,"user_prefs",0);
        complexPreferences.putObject("current_user_value", currentUser);
        complexPreferences.commit();
    }

    public static User getCurrentUser(Context context){
        ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(context,"user_prefs",0);
        User currentUser = complexPreferences.getObject("current_user_value", User.class);
        return currentUser;
    }

    public static void clearCurrentUser(Context context){
        ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(context,"user_prefs",0);
        complexPreferences.clearObject();
        complexPreferences.commit();
    }
}
