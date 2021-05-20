package com.learnwithvel.accessabilityeventservice;

import android.accessibilityservice.AccessibilityService;
import android.util.Log;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;

public class AccessiblityService extends AccessibilityService {

    private static final String TAG = "acce";

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        Log.d(TAG, TAG + event.toString());
    }

    @Override
    public void onInterrupt() {

    }

    private boolean handleKeyEvent(KeyEvent event) {
        int action = event.getAction();
        int keyCode = event.getKeyCode();
        if (action == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_VOLUME_DOWN:
                    //do something
                    Log.d(TAG, "handleKeyEvent: down");
                    return true;

                case KeyEvent.KEYCODE_VOLUME_UP: {
                    //do something
                    Log.d(TAG, "handleKeyEvent: up");
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    protected boolean onKeyEvent(KeyEvent event) {
        return handleKeyEvent(event);
    }
}
