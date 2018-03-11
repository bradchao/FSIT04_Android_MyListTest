package tw.org.iii.mylisttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

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
        SimpleAdapter adapter = new SimpleAdapter(this,
                null, R.layout.xx, from, to);


        listView.setAdapter(adapter);
    }

}
