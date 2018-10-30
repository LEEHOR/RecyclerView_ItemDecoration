package com.example.test.recycleviewstickyheader;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.view.View;

/**
 * Created by Leehor
 * on 2018/10/29
 * on 15:45
 */
public class RecyclerViewItemDecoration_section extends RecyclerView.ItemDecoration {
    private float dimension;
    private Paint paint;
    private TextPaint textPaint;
    private Resources resources;
    private Paint.FontMetrics fontMetrics;
    private int topGap;
    private DecorationCallback callback;
    private Context context;

    public RecyclerViewItemDecoration_section(Context context, DecorationCallback decorationCallback) {
        this.context = context;
        this.callback = decorationCallback;
        resources = context.getResources();
        dimension = context.getResources().getDimensionPixelOffset(R.dimen.dp_10);
        paint = new Paint();
        paint.setColor(context.getResources().getColor(R.color.left));

        textPaint = new TextPaint();
        fontMetrics = new Paint.FontMetrics();

        textPaint.setTypeface(Typeface.DEFAULT_BOLD); //加粗
        textPaint.setTextSize(80); //大小
        textPaint.setColor(resources.getColor(R.color.black));
        textPaint.getFontMetrics(fontMetrics); //字体风格
        textPaint.setTextAlign(Paint.Align.LEFT);
        textPaint.setAntiAlias(true);
        topGap = resources.getDimensionPixelOffset(R.dimen.dp_20);
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        long groupId = callback.getGroupId(childAdapterPosition);
        if (groupId < 0) return;
        if (childAdapterPosition == 0 || isFirstInGroup(childAdapterPosition)) {
            outRect.top = topGap;
        } else {
            outRect.top = 0;
        }

    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);
        float left = parent.getPaddingLeft();
        float right = parent.getPaddingRight();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = parent.getChildAt(i);
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            long groupId = callback.getGroupId(childAdapterPosition);
            if (groupId < 0) return;
            String textLine = callback.getGroupFirstLine(childAdapterPosition).toUpperCase();
            if (childAdapterPosition == 0 || isFirstInGroup(childAdapterPosition)){
                float top = view.getTop() - topGap;
                float bottom = view.getTop();
                c.drawRect(left, top, right, bottom, paint);//绘制红色矩形
                c.drawText(textLine, left, bottom, textPaint);//绘制文本
            }
        }

    }

    /**
     * 是否为同组第一个
     *
     * @param pos
     * @return
     */
    private boolean isFirstInGroup(int pos) {
        if (pos == 0) {
            return true;
        } else {
            long prevGroupId = callback.getGroupId(pos - 1);
            long groupId = callback.getGroupId(pos);
            return prevGroupId != groupId;
        }
    }

    public interface DecorationCallback {

        long getGroupId(int position);

        String getGroupFirstLine(int position);
    }
}
