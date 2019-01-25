package com.uigitdev.instagramdirectchat;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class Animations {

    private ObjectAnimator objectAnimator;
    private Context context;
    private Animation animation;

    public Animations(Context context) {
        this.context = context;
    }

    public void openFunctionsAnim(ImageButton imageButton) {
        objectAnimator = ObjectAnimator.ofFloat(imageButton, "rotation", 0f, 45f);
        objectAnimator.setDuration(200);
        objectAnimator.start();
    }

    public void closeFunctionsAnim(ImageButton imageButton) {
        objectAnimator = ObjectAnimator.ofFloat(imageButton, "rotation", 45f, 0f);
        objectAnimator.setDuration(200);
        objectAnimator.start();
    }

    public void hideStoryAnim(ImageButton imageButton) {
        animation = AnimationUtils.loadAnimation(context, R.anim.story_zoom_out);
        imageButton.setAnimation(animation);
    }

    public void showStoryAnim(ImageButton imageButton) {
        animation = AnimationUtils.loadAnimation(context, R.anim.story_zoom_in);
        imageButton.setAnimation(animation);
    }

    public void showFunctionsAnim(RelativeLayout relativeLayout) {
        ObjectAnimator animation = ObjectAnimator.ofFloat(relativeLayout, "translationX", 100f, 0f);
        animation.setDuration(200);
        animation.start();
    }

    public void hideFunctionsAnim(RelativeLayout relativeLayout, final ImageButton imageButton, final ImageButton imageButton1) {
        final ObjectAnimator animation = ObjectAnimator.ofFloat(relativeLayout, "translationX", 0f, 120f);
        animation.setDuration(250);
        animation.start();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                imageButton.setVisibility(View.INVISIBLE);
                imageButton1.setVisibility(View.GONE);
            }
        }, 250);
    }
}
