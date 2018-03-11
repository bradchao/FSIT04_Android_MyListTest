package tw.org.iii.mylisttest;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.HashMap;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private LinkedList<HashMap<String,String>> data;
    private SimpleAdapter adapter;
    private String[] from = {"title", "cont"};
    private int[] to = {R.id.item_title, R.id.item_cont};
    private int removeIndex = -1;
    private int dataIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);
        data = new LinkedList<>();
        initListView();
    }

    private void initListView(){
        HashMap<String,String> data0 = new HashMap<>();
        data0.put(from[0], "Hello, World");
        data0.put(from[1], "hello, World");
        data0.put("index", "" + dataIndex++);
        data0.put("detail", "我是詳細資料");
        data.add(data0);

        HashMap<String,String> data1 = new HashMap<>();
        data1.put(from[0], "LayoutTest");
        data1.put(from[1], "練習版面配置");
        data1.put("index", "" + dataIndex++);
        data1.put("detail", "我是詳細資料");
        data.add(data1);

        HashMap<String,String> data2 = new HashMap<>();
        data2.put(from[0], "GuessNumber");
        data2.put(from[1], "猜數字遊戲");
        data2.put("index", "" + dataIndex++);
        data2.put("detail", "我是詳細資料");
        data.add(data2);

        adapter = new SimpleAdapter(this,
                data, R.layout.item_layout,
                from, to);

        listView.setAdapter(adapter);

        // show detail
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //Log.v("brad", "Click:" + position);
                gotoDetail(position);
            }
        });

        // del item
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {
                //Log.v("brad", "LongClick:" + position);
                //removeItem(position);
                removeIndex = position;
                showDelDialog();
                return true;
            }
        });



    }

    private void gotoDetail(int position){
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("index", data.get(position).get("index"));
        intent.putExtra("title", data.get(position).get("title"));
        intent.putExtra("cont", data.get(position).get("cont"));
        intent.putExtra("detail", data.get(position).get("detail"));
        startActivity(intent);
    }


    private void showDelDialog(){
        new AlertDialog.Builder(this)
                .setCancelable(false)
                .setTitle("確認一下")
                .setMessage("是否刪除" +
                        data.get(removeIndex).get(from[0]) + "?")
                .setPositiveButton("確定刪除", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Log.v("brad", "index = " + removeIndex);
                        removeItem(removeIndex);
                    }
                })
                .setNegativeButton("放棄刪除", null)
                .show();

    }


    private void removeItem(int index){
        removeIndex = -1;
        data.remove(index);
        adapter.notifyDataSetChanged();
    }

    public void addItem(View view) {
        HashMap<String,String> data2 = new HashMap<>();
        data2.put(from[0], "new data");
        data2.put(from[1], "OK");
        data2.put("index", "" + dataIndex++);
        data2.put("detail", "我是詳細資料");
        data.add(data2);

        adapter.notifyDataSetChanged();

    }
}
