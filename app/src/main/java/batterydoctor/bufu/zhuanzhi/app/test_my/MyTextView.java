package batterydoctor.bufu.zhuanzhi.app.test_my;

import android.content.Context;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * @author Luffy
 * date 2019/7/25
 */
public class MyTextView extends TextView {
    private Shader mShader;
    private int mHeight;
    private int mWidth;

    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mHeight = getMeasuredHeight();
        mWidth = getMeasuredWidth();
        init();
    }

    private void init() {
        mShader = new LinearGradient(0, 0, mWidth, mHeight, new int[]{Color.BLUE, Color.YELLOW,Color.GREEN}, new float[]{0,0.4f,0.8f},Shader.TileMode.REPEAT);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        if(mShader != null){
            if (getPaint().getShader() == null) {
                getPaint().setShader(mShader);
            }
        }
        super.onDraw(canvas);
    }
}
