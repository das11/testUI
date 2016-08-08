package i_nterface.kdas.uitest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<dataset> data = new ArrayList<dataset>();
    int dinc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = (RecyclerView)findViewById(R.id.rview);
        for (int i = 0, dinc = 40; i < 40; ++i)
        {
            //################# for updating dataset use pre instantiated ref here
            data.add(0, new dataset("", "" + dinc));
            --dinc;
        }

//        ItemClickSupport.addTo(rv).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
//            @Override
//            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
//
//                Toast.makeText(getApplicationContext(), "" + position , Toast.LENGTH_LONG).show();
//                Intent in = new Intent(MainActivity.this, Main2Activity.class);
//                startActivity(in);
//            }
//        });

        RVadapter adapter = new RVadapter(this, data);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter.notifyDataSetChanged();

    }


}
