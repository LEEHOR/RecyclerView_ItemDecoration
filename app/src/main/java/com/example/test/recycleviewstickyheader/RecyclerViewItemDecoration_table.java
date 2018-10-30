package com.example.test.recycleviewstickyheader;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Leehor
 * on 2018/10/29
 * on 15:45
 */
public class RecyclerViewItemDecoration_table extends RecyclerView.ItemDecoration {
    private float dimension;
    private Paint paint_left;
    private Paint paint_right;

    public RecyclerViewItemDecoration_table(Context context) {
        dimension = context.getResources().getDimensionPixelOffset(R.dimen.dp_10);
        paint_left = new Paint();
        paint_left.setColor(context.getResources().getColor(R.color.left));

        paint_right = new Paint();
        paint_right.setColor(context.getResources().getColor(R.color.right));
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount ; i++) {
            View childAt = parent.getChildAt(i);
            int childAdapterPosition = parent.getChildAdapterPosition(childAt);
            boolean isLeft = childAdapterPosition % 2 == 0;
            if (isLeft) {
                float left = childAt.getLeft();
                float right = left + dimension;
                float top = childAt.getTop();
                float bottom = childAt.getBottom();
                c.drawRect(left, top, right, bottom, paint_left);
            } else {
                float right = childAt.getRight();
                float left = right - dimension;
                float top = childAt.getTop();
                float bottom = childAt.getBottom();
                c.drawRect(left, top, right, bottom,paint_right);
            }

        }

    }
}
