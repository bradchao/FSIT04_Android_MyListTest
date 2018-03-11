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
        LinkedList<HashMap<String,String>> data = new LinkedList<>();
        HashMap<String,String> data0 = new HashMap<>();
        data0.put("brad1", "test1");
        data.add(data0);

        String[] from = {"brad1"};
        int[] to = {R.id.item_title};


        SimpleAdapter adapter = new SimpleAdapter(this,
                data, R.layout.item_layout,
                from, to);


        listView.setAdapter(adapter);
    }

}
