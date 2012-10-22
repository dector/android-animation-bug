package com.example.android_anim_bug;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

public class MyActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button button = (Button) findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				TranslateAnimation animation = new TranslateAnimation(200, 200, -100, 100);
				animation.setDuration(2000);
				animation.setAnimationListener(new Animation.AnimationListener() {
					@Override
					public void onAnimationStart(Animation animation) {
						Log.d("Animation", "Animation started");
					}

					@Override
					public void onAnimationEnd(Animation animation) {
						// Will never executed
						Log.d("Animation", "Animation finished");
					}

					@Override
					public void onAnimationRepeat(Animation animation) {
					}
				});
				view.startAnimation(animation);
			}
		});
	}
}
