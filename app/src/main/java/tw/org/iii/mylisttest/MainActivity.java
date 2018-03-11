package tw.org.iii.mylisttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);
        initListView();
    }

    private void initListView(){
        String[] from = {"title", "cont"};
        int[] to = {R.id.item_title, R.id.item_cont};

        LinkedList<HashMap<String,String>> data = new LinkedList<>();
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

        SimpleAdapter adapter = new SimpleAdapter(this,
                data, R.layout.item_layout,
                from, to);

        listView.setAdapter(adapter);
    }

}
