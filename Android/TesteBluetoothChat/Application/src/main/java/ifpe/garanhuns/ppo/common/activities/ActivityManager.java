package ifpe.garanhuns.ppo.common.activities;

import android.app.Activity;

/**
 * Created by Anna Vitória on 13/12/2016.
 */

public class ActivityManager {

    private Activity atual;
    private static ActivityManager activityManager;

    public static ActivityManager getInstance(){
        if(activityManager == null){
            activityManager = new ActivityManager();
        }
        return activityManager;
    }


    public void setAtual(Activity activity){
        atual = activity;
    }

    public Activity getAtual(){
        return atual;
    }

}
