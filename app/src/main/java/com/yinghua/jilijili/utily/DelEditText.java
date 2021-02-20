package com.yinghua.jilijili.utily;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatEditText;

import com.yinghua.jilijili.R;

public class DelEditText extends AppCompatEditText {

    private Context context;
    private Drawable drawableDel;


    public DelEditText(Context context, AttributeSet attrs, Context context1) {
        super(context, attrs);
        this.context = context1;
        inti();
    }

    private void inti() {
        drawableDel = context.getResources().getDrawable(R.drawable.ic_baseline_clear_24);
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                setDrawable();
            }
        });
    }

    private void setDrawable() {
        if(length()<1){
            setCompoundDrawablesWithIntrinsicBounds(null,null,null,null);
        }else{
            setCompoundDrawablesWithIntrinsicBounds(null, null, drawableDel, null);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(drawableDel!=null&&event.getAction()==MotionEvent.ACTION_UP){
            int eventX= (int) event.getRawX();
            int eventY= (int) event.getRawY();
            Rect rect = new Rect();
            getGlobalVisibleRect(rect);
            rect.left=rect.right-100;
            if(rect.contains(eventX,eventY)){
                setText("");
            }

        }
        return super.onTouchEvent(event);
    }
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

}
