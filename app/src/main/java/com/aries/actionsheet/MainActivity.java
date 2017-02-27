package com.aries.actionsheet;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.aries.ui.widget.action.sheet.UIActionSheetView;

public class MainActivity extends AppCompatActivity {

    String[] items = new String[]{"item0", "item1", "item2", "item3", "item4", "item5", "item6"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_normal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new UIActionSheetView(MainActivity.this)
                        .setTitle("UIActionSheetView-normal")
                        .setCancelMessage("取消")
                        .setItems(R.array.arrays_items_action, onActionSheetItemLister)
                        .show();
            }
        });
        findViewById(R.id.btn_normalColor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new UIActionSheetView(MainActivity.this)
                        .setTitle("UIActionSheetView-变色")
                        .setTitleColorResoure(R.color.colorItems)
                        .setCancelMessage("取消")
                        .setCancelColorResource(R.color.colorAccent)
                        .setItems(R.array.arrays_items_action, onActionSheetItemLister)
                        .setItemsTextColorResource(R.color.colorAccent)
                        .setItemTextColor(2, Color.parseColor("#000000"))
                        .setItemTextColorResource(5,R.color.colorItems)
                        .show();
            }
        });
        findViewById(R.id.btn_noTitle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new UIActionSheetView(MainActivity.this)
                        .setCancelMessage("取消")
                        .setItems(R.array.arrays_items_action, onActionSheetItemLister)
                        .show();
            }
        });
    }

    private UIActionSheetView.OnSheetItemListener onActionSheetItemLister = new UIActionSheetView.OnSheetItemListener() {
        @Override
        public void onClick(int item) {
            Toast.makeText(MainActivity.this, "item position:" + item, Toast.LENGTH_SHORT).show();
        }
    };
}
