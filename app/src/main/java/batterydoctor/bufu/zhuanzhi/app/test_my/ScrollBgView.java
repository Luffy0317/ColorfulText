package batterydoctor.bufu.zhuanzhi.app.test_my;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.WindowManager;
import android.widget.RelativeLayout;

/**
 * @author Luffy
 * date 2019/7/25
 */
public class ScrollBgView extends RelativeLayout {

    private Paint mPaint;
    private LinearGradient mShader;
    private Matrix mMatrix;
    private RectF mRectF;


    public float getMoveX() {
        return moveX;
    }

    public void setMoveX(float moveX) {
        this.moveX = moveX;
        invalidate();
    }

    private float moveX;

    public ScrollBgView(Context context) {
        super(context);
        init();
    }

    public ScrollBgView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ScrollBgView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mMatrix = new Matrix();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
         int measuredHeight = getMeasuredHeight();
         int measuredWidth = getMeasuredWidth();
        mRectF = new RectF(0, 0, measuredWidth, measuredHeight);
        mShader = new LinearGradient(0, 0, measuredWidth * 2, measuredHeight, new int[]{
                Color.GRAY, Color.RED,Color.GREEN, Color.BLUE,Color.YELLOW, Color.DKGRAY,},
                null, Shader.TileMode.REPEAT);
    }

    //layout在此绘制
    @Override
    protected void dispatchDraw(Canvas canvas) {
        if(mShader != null){
            if(mPaint.getShader() == null){
                mPaint.setShader(mShader);
            }
        }

        mMatrix.setTranslate(moveX,0);

        mShader.setLocalMatrix(mMatrix);
        canvas.drawRoundRect(mRectF,dpToPx(getContext(),8),dpToPx(getContext(),8),mPaint);
        super.dispatchDraw(canvas);
    }

    public int dpToPx(Context context,float dpValue) {//dp转换为px
        float scale=context.getResources().getDisplayMetrics().density;//获得当前屏幕密度
        return (int)(dpValue*scale+0.5f);
    }
}
