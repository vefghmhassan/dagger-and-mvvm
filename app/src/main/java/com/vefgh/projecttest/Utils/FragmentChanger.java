package com.vefgh.projecttest.Utils;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import com.vefgh.projecttest.R;


public class FragmentChanger {
    private static int idContent = R.id.content;
    private static AppCompatActivity baseActivity;
    private static Fragment baseFragment;

    public static FragmentChanger init(AppCompatActivity activity) {
        baseActivity = activity;
        return new FragmentChanger();
    }

    public FragmentChanger init(AppCompatActivity activity, int id) {
        baseActivity = activity;
        idContent = id;
        return new FragmentChanger();


    }

    public static FragmentChanger init(Fragment activity) {
        baseFragment = activity;
        return new FragmentChanger();
    }

    public FragmentChanger init(Fragment activity, int id) {
        baseFragment = activity;
        idContent = id;
        return new FragmentChanger();


    }

    public void setCommit(Fragment fragment) {

        baseActivity.getSupportFragmentManager().beginTransaction().replace(idContent, fragment).commit();

    }

    public void setCommitBackStack(Fragment fragment, String b) {

        baseActivity.getSupportFragmentManager().beginTransaction().replace(idContent, fragment).addToBackStack(b).commit();

    }

    public void setChildCommit(Fragment fragment) {

        Fragment oldFragment = baseFragment.getChildFragmentManager().findFragmentById(idContent);
        if (oldFragment != fragment)
            if (baseFragment != null) {
                baseFragment.getChildFragmentManager().beginTransaction().replace(idContent, fragment).commit();
            }
    }


    public void setChildCommitBackStack(Fragment fragment, String b) {
        if (baseFragment != null) {
            baseFragment.getChildFragmentManager().beginTransaction().replace(idContent, fragment).addToBackStack(b).commit();
        }
    }
    public Fragment getfindFragment(){

       return baseActivity.getSupportFragmentManager().findFragmentById(idContent);
    }

}
