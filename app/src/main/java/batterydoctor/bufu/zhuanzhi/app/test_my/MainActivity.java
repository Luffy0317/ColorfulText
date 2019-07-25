package batterydoctor.bufu.zhuanzhi.app.test_my;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

public class MainActivity extends AppCompatActivity {

    private ScrollBgView mSbv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSbv = findViewById(R.id.sbv);

        mSbv.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View view, int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7) {
                int width = mSbv.getWidth();
                Log.e("getWidth",width+"____");
                ObjectAnimator animator = ObjectAnimator.ofFloat(mSbv, "moveX", 0 ,-width*2);
                animator.setDuration(7 * 1000);
                animator.setInterpolator(new LinearInterpolator());
                animator.setRepeatCount(-1);
                animator.start();
            }
        });
    }
}
