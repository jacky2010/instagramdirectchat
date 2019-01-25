package com.uigitdev.instagramdirectchat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    ImageButton ig_story_button;
    RelativeLayout ig_input_parent;
    RelativeLayout ig_functions_parent;
    EditText ig_input_text;
    RelativeLayout ig_direct_functions;
    ImageButton ig_micro_button;
    ImageButton ig_gallery_button;
    ImageButton ig_gif_button;
    ImageButton ig_like_button;
    ImageButton ig_plus_button;
    boolean isOpenFunctions = false;
    RelativeLayout.LayoutParams layoutParams;
    Animations animations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTypes();
    }

    public void setTypes() {
        ig_story_button = findViewById(R.id.ig_story_button);
        ig_input_parent = findViewById(R.id.ig_input_parent);
        ig_functions_parent = findViewById(R.id.ig_functions_parent);
        ig_input_text = findViewById(R.id.ig_input_text);
        ig_direct_functions = findViewById(R.id.ig_direct_functions);
        ig_micro_button = findViewById(R.id.ig_micro_button);
        ig_gallery_button = findViewById(R.id.ig_gallery_button);
        ig_gif_button = findViewById(R.id.ig_gif_button);
        ig_like_button = findViewById(R.id.ig_like_button);
        ig_plus_button = findViewById(R.id.ig_plus_button);
        layoutParams = (RelativeLayout.LayoutParams) ig_input_parent.getLayoutParams();
        animations = new Animations(getApplicationContext());
    }

    public void openVisivibility() {
        ig_direct_functions.setVisibility(View.VISIBLE);
        ig_like_button.setVisibility(View.VISIBLE);
        ig_gif_button.setVisibility(View.VISIBLE);
        ig_input_parent.setLayoutParams(layoutParams);
        ig_story_button.setVisibility(View.GONE);
        layoutParams.setMargins(50, 0, 0, 0);
        animations.openFunctionsAnim(ig_plus_button);
        animations.hideStoryAnim(ig_story_button);
        animations.showFunctionsAnim(ig_direct_functions);
    }

    public void closeVisivibility() {
        ig_story_button.setVisibility(View.VISIBLE);
        ig_input_parent.setLayoutParams(layoutParams);
        animations.closeFunctionsAnim(ig_plus_button);
        animations.showStoryAnim(ig_story_button);
        layoutParams.setMargins(0, 0, 0, 0);
        animations.hideFunctionsAnim(ig_direct_functions, ig_like_button, ig_gif_button);
    }

    public void igPlus(View view) {
        if (isOpenFunctions) {
            closeVisivibility();
            isOpenFunctions = false;

        } else {
            openVisivibility();
            isOpenFunctions = true;
        }
    }

    public void igLike(View view) {
        //todo click
    }

    public void igGif(View view) {
        //todo click
    }

    public void igGallery(View view) {
        //todo click
    }

    public void igMicro(View view) {
        //todo click
    }

    public void igInput(View view) {
        ig_direct_functions.setVisibility(View.GONE);
    }
}
