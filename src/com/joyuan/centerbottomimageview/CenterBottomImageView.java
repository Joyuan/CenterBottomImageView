package com.joyuan.centerbottomimageview;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.ImageView;

/***
 * 高度一定的imageview，在不拉伸图片的前提下，宽度充满屏幕，高度截取上面部分。
 * 
 * @author Joyuan
 * 
 */
public class CenterBottomImageView extends ImageView {
	public CenterBottomImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setScaleType(ScaleType.MATRIX);
	}

	public CenterBottomImageView(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
		setScaleType(ScaleType.MATRIX);
	}

	public CenterBottomImageView(Context context) {
		super(context);
		setScaleType(ScaleType.MATRIX);
	}

	@Override
	protected boolean setFrame(int l, int t, int r, int b) {
		if (getDrawable() == null) {
			return super.setFrame(l, t, r, b);
		}
		Matrix matrix = getImageMatrix();
		float scaleWidth = getWidth()
				/ (float) getDrawable().getIntrinsicWidth();
		float scaleHeight = getHeight()
				/ (float) getDrawable().getIntrinsicHeight();
		float scaleFactor = (scaleWidth > scaleHeight) ? scaleWidth
				: scaleHeight;
		matrix.setScale(scaleFactor, scaleFactor, 0, 0);
		matrix.postTranslate(0, -getHeight());
		setImageMatrix(matrix);
		return super.setFrame(l, t, r, b);
	}
}
