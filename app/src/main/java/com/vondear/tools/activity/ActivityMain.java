package com.vondear.tools.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.vondear.rxtools.RxImageUtils;
import com.vondear.rxtools.RxRecyclerViewDivider;
import com.vondear.rxtools.activity.ActivityCodeTool;
import com.vondear.tools.R;
import com.vondear.tools.adapter.AdapterRecyclerViewMain;
import com.vondear.tools.bean.ModelMainItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityMain extends AppCompatActivity {

    //双击返回键 退出
    //----------------------------------------------------------------------------------------------
    private static final int TIME_INTERVAL = 2000; // # milliseconds, desired time passed between two back presses.
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    private List<ModelMainItem> mData;
    private int mColumnCount = 3;
    private Context context;
    private long mBackPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        context = this;
        initData();
        initView();
    }

    private void initData() {
        mData = new ArrayList<>();
        mData.add(new ModelMainItem("RxPhotoUtils操作UZrop裁剪图片", R.drawable.elves_ball, ActivityRxPhoto.class));
        mData.add(new ModelMainItem("二维码与条形码的扫描与生成", R.drawable.circle_qr_code, ActivityCodeTool.class));
        mData.add(new ModelMainItem("WebView的封装可播放视频", R.drawable.webpage, com.vondear.rxtools.activity.ActivityWebView.class));
        mData.add(new ModelMainItem("常用的Dialog展示", R.drawable.icon_dialog, ActivityDialog.class));
        mData.add(new ModelMainItem("图片的缩放艺术", R.drawable.circle_scale_icon, ActivityRxScaleImageView.class));
        mData.add(new ModelMainItem("RxTextUtils操作Demo", R.drawable.icon_text, ActivityTextUtils.class));
        mData.add(new ModelMainItem("进度条的艺术", R.drawable.circle_bar, ActivityProgressBar.class));
        mData.add(new ModelMainItem("加载的艺术", R.drawable.circle_loading_icon, ActivityLoading.class));
        mData.add(new ModelMainItem("添加购物车控件", R.drawable.shop_cart, ActivityShoppingView.class));
        mData.add(new ModelMainItem("点赞控件", R.drawable.heart_circle, ActivityLike.class));
        mData.add(new ModelMainItem("网速控件", R.drawable.net_speed, ActivityNetSpeed.class));
        mData.add(new ModelMainItem("验证码", R.drawable.circle_captcha, ActivityRxCaptcha.class));
        mData.add(new ModelMainItem("横向滑动选择控件", R.drawable.bookshelf, ActivityWheelHorizontal.class));
        mData.add(new ModelMainItem("横向左右自动滚动的ImageView", R.drawable.two_way, ActivityAutoImageView.class));
        mData.add(new ModelMainItem("SlidingDrawerSingle使用", R.drawable.up_down, ActivitySlidingDrawerSingle.class));
        mData.add(new ModelMainItem("RxSeekBar", R.drawable.circle_seek, ActivitySeekBar.class));
        mData.add(new ModelMainItem("登录界面", R.drawable.circle_clound, ActivityLoginAct.class));
        mData.add(new ModelMainItem("PopupView的使用", R.drawable.bullet, ActivityPopupView.class));
        mData.add(new ModelMainItem("RxToast的使用", R.drawable.rx_toast, ActivityRxToast.class));
        mData.add(new ModelMainItem("RunTextView的使用", R.drawable.wrap_text, ActivityRunTextView.class));
        mData.add(new ModelMainItem("选座控件", R.drawable.seat, ActivitySeat.class));
        mData.add(new ModelMainItem("银行卡组堆叠控件", R.drawable.credit_card, ActivityCardStack.class));
        mData.add(new ModelMainItem("联系人侧边快速导航", R.drawable.circle_phone, ActivityContact.class));
        mData.add(new ModelMainItem("GPS原生定位", R.drawable.circle_gps_icon, ActivityLocation.class));
        mData.add(new ModelMainItem("app检测更新与安装", R.mipmap.ic_launcher, ActivitySplash.class));
    }

    private void initView() {
        if (mColumnCount <= 1) {
            recyclerview.setLayoutManager(new LinearLayoutManager(context));
        } else {
            recyclerview.setLayoutManager(new GridLayoutManager(context, mColumnCount));
        }

        recyclerview.addItemDecoration(new RxRecyclerViewDivider(RxImageUtils.dp2px(context, 5f)));
        AdapterRecyclerViewMain recyclerViewMain = new AdapterRecyclerViewMain(mData);

        recyclerview.setAdapter(recyclerViewMain);
    }

    @Override
    public void onBackPressed() {
        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
            super.onBackPressed();
            return;
        } else {
            Toast.makeText(getBaseContext(), "再次点击返回键退出", Toast.LENGTH_SHORT).show();
        }
        mBackPressed = System.currentTimeMillis();
    }
    //==============================================================================================
}
