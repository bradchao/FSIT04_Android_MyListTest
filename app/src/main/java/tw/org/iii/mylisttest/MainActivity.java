package tw.org.iii.mylisttest;

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
        data.add(data0);

        HashMap<String,String> data1 = new HashMap<>();
        data1.put(from[0], "LayoutTest");
        data1.put(from[1], "練習版面配置");
        data.add(data1);

        HashMap<String,String> data2 = new HashMap<>();
        data2.put(from[0], "GuessNumber");
        data2.put(from[1], "猜數字遊戲");
        data.add(data2);

        adapter = new SimpleAdapter(this,
                data, R.layout.item_layout,
                from, to);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Log.v("brad", "Click:" + position);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {
                Log.v("brad", "LongClick:" + position);
                return true;
            }
        });



    }

    public void addItem(View view) {
        HashMap<String,String> data2 = new HashMap<>();
        data2.put(from[0], "new data");
        data2.put(from[1], "OK");
        data.add(data2);

        adapter.notifyDataSetChanged();

    }
}
