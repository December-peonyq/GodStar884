package com.vondear.tools.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import com.vondear.rxtools.RxActivityUtils;
import com.vondear.rxtools.RxBarUtils;
import com.vondear.rxtools.activity.ActivityBase;
import com.vondear.rxtools.view.RxShoppingView;
import com.vondear.tools.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityShoppingView extends ActivityBase {

    @BindView(R.id.sv_1)
    RxShoppingView mSv1;
    @BindView(R.id.sv_2)
    RxShoppingView mSv2;
    @BindView(R.id.btn_take_out)
    Button mBtnTakeOut;
    @BindView(R.id.activity_shopping_view)
    LinearLayout mActivityShoppingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RxBarUtils.noTitle(this);
        setContentView(R.layout.activity_shopping_view);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_take_out)
    public void onClick() {
        RxActivityUtils.skipActivity(mContext, ActivityELMe.class);
    }
}
