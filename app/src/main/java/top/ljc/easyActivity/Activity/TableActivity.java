package top.ljc.easyActivity.Activity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.ArrayList;

import top.ljc.easyActivity.Adapter.TableItemAdapter;
import top.ljc.easyActivity.Data.TableItem;
import top.ljc.easyActivity.R;
import top.ljc.easyActivity.View.mToolbar;

public class TableActivity extends AppCompatActivity{

    private Context context;
    private mToolbar mToolbar;
    private RecyclerView recyclerView;
    private ArrayList<TableItem> arrayList;
    private TableItemAdapter tableItemAdapter;

    ArrayList<Integer> choices = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;

        // 实现透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        setContentView(R.layout.activity_table);

        mToolbar = (mToolbar)findViewById(R.id.toolbar_table);
        mToolbar.setOnClickBackListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mToolbar.setOnClickRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"完成",Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView = (RecyclerView)findViewById(R.id.recyclerview_table);
        arrayList = new ArrayList<>();
        arrayList.add(new TableItem("邮箱","330****766@example.com"));
        tableItemAdapter = new TableItemAdapter(arrayList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(tableItemAdapter);

        tableItemAdapter.setOnDeleteClickListener(new TableItemAdapter.OnitemClick() {
            @Override
            public void onItemClick(int position) {
                arrayList.remove(position);
                //tableItemAdapter.notifyItemRemoved(position);
                tableItemAdapter.notifyDataSetChanged();
            }
        });
        tableItemAdapter.setOnSettingClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        tableItemAdapter.setOnFooterClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMultiChoiceDialog();
            }
        });
    }

    private void showMultiChoiceDialog(){
        final String[] items = {"qq","邮箱","学号","手机号","身份证号","自定义"};
        //设置默认选择都是false
        final boolean initchoices[] = {false,false,false,false,false,false};
        choices.clear();
        AlertDialog.Builder multChoiceDialog = new AlertDialog.Builder(context);
        multChoiceDialog.setIcon(R.drawable.logo);
        multChoiceDialog.setTitle("请选择活动报名项");
        multChoiceDialog.setMultiChoiceItems(items, initchoices, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked){
                    choices.add(which);
                }else {
                    choices.remove(which);
                }
            }
        });
        multChoiceDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int size = choices.size();
                for(int i = 0;i<size;i++){
                    switch (choices.get(i)){
                        case 0:
                            arrayList.add(new TableItem("qq","11658****70"));
                            break;
                        case 1:
                            arrayList.add(new TableItem("邮箱","example@example.com"));
                            break;
                        case 2:
                            arrayList.add(new TableItem("学号","201****960"));
                            break;
                        case 3:
                            arrayList.add(new TableItem("手机号","132****4373"));
                            break;
                        case 4:
                            arrayList.add(new TableItem("身份证号","500***20000808****"));
                            break;
                        case 5:
                            arrayList.add(new TableItem("自定义","自定义填写示范"));
                            break;
                    }
                }
                tableItemAdapter.notifyDataSetChanged();
            }
        });
        multChoiceDialog.show();
    }
}
