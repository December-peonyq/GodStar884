package com.vondear.tools.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.vondear.rxtools.activity.ActivityBase;
import com.vondear.rxtools.view.heart.RxHeartLayout;
import com.vondear.rxtools.view.likeview.RxShineButton;
import com.vondear.tools.R;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityLike extends ActivityBase {

    RxShineButton mRxShineButton;
    RxShineButton porterShapeImageView1;
    RxShineButton porterShapeImageView2;
    RxShineButton porterShapeImageView3;
    @BindView(R.id.po_image0)
    RxShineButton mPoImage0;
    @BindView(R.id.po_image1)
    RxShineButton mPoImage1;
    @BindView(R.id.po_image2)
    RxShineButton mPoImage2;
    @BindView(R.id.po_image3)
    RxShineButton mPoImage3;
    @BindView(R.id.ll_top)
    LinearLayout mLlTop;
    @BindView(R.id.wrapper)
    LinearLayout mWrapper;
    @BindView(R.id.po_image8)
    RxShineButton mPoImage8;
    @BindView(R.id.love)
    ImageView mLove;
    @BindView(R.id.ll_control)
    LinearLayout mLlControl;
    @BindView(R.id.ll_bottom)
    LinearLayout mLlBottom;
    @BindView(R.id.heart_layout)
    RxHeartLayout mRxHeartLayout;
    @BindView(R.id.tv_hv)
    TextView mTvHv;
    @BindView(R.id.activity_like)
    RelativeLayout mActivityLike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like);
        ButterKnife.bind(this);

        mRxShineButton = (RxShineButton) findViewById(R.id.po_image0);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.wrapper);

        if (mRxShineButton != null)
            mRxShineButton.init(this);
        porterShapeImageView1 = (RxShineButton) findViewById(R.id.po_image1);
        if (porterShapeImageView1 != null)
            porterShapeImageView1.init(this);
        porterShapeImageView2 = (RxShineButton) findViewById(R.id.po_image2);
        if (porterShapeImageView2 != null)
            porterShapeImageView2.init(this);
        porterShapeImageView3 = (RxShineButton) findViewById(R.id.po_image3);
        if (porterShapeImageView3 != null)
            porterShapeImageView3.init(this);

        RxShineButton rxShineButtonJava = new RxShineButton(this);

        rxShineButtonJava.setBtnColor(Color.GRAY);
        rxShineButtonJava.setBtnFillColor(Color.RED);
        rxShineButtonJava.setShapeResource(R.raw.heart);
        rxShineButtonJava.setAllowRandomColor(true);
        rxShineButtonJava.setShineSize(100);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(100, 100);
        rxShineButtonJava.setLayoutParams(layoutParams);
        if (linearLayout != null) {
            linearLayout.addView(rxShineButtonJava);
        }


        mRxShineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        mRxShineButton.setOnCheckStateChangeListener(new RxShineButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(View view, boolean checked) {
            }
        });

        porterShapeImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        porterShapeImageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

    }

    private Random random = new Random();

    @OnClick(R.id.love)
    public void onClick() {
        mRxHeartLayout.post(new Runnable() {
            @Override
            public void run() {
                int rgb = Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255));
                mRxHeartLayout.addHeart(rgb);
            }
        });
    }
}
