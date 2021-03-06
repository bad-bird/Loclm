package com.sublime.loclm.app;

import android.Manifest;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.tbruyelle.rxpermissions2.RxPermissions;

/**
 * Created by goonerdroid
 * on 21/11/17.
 */

public abstract class BaseActivity extends AppCompatActivity {


    @Override public void onStart() {
        super.onStart();
        //sets portrait mode for entire application.
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //requests permission for accessing location.
        new RxPermissions(this)
                .request(Manifest.permission.ACCESS_FINE_LOCATION)
                .subscribe(granted -> {
                    if (granted) {
                        onLocationPermissionGranted();
                    } else {
                        Toast.makeText(BaseActivity.this,
                                "We,need this permission to fetch location updates", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    protected abstract void onLocationPermissionGranted();
}
