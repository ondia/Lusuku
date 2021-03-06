package com.example.bifam.lusuku;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CommentList extends Activity {

    ListView listView ;
    CommentDBHandler db;
    List<String> CommentList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_list);

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.listComment);

        db = new CommentDBHandler(getApplicationContext());
        List<Comment> comment = db.getAllComment();

        for (Comment cn : comment) {
            CommentList.add(String.valueOf(cn.get_id()));
            CommentList.add(cn.get_phonenumber());
            CommentList.add(cn.get_subject());
            CommentList.add(cn.get_comment());

        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1,  CommentList);


        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) listView.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                        .show();
            }
        });
    }
}
