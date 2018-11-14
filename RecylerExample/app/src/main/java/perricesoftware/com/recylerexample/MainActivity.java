package perricesoftware.com.recylerexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    //Create handler, creat variable
    private RecyclerView recyclerView;

    // create int array to hold all the images

    private int[] images = {
            R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five,R.drawable.six,R.drawable.seven};

    private RecyclerAdapter adapter;

    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        //init handler
        recyclerView = findViewById(R.id.recylerView);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter(images,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.app_bar_menu,menu);

        MenuItem.OnActionExpandListener onActionExpandListener = new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem menuItem) {
                Toast.makeText(MainActivity.this, "Action View Expanded", Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem menuItemtem) {
                Toast.makeText(MainActivity.this, "Action View Collapsed", Toast.LENGTH_SHORT).show();
                return true;
            }
        };

        MenuItem searchItem = menu.findItem(R.id.action_search);

        searchItem.setOnActionExpandListener(onActionExpandListener);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

          switch (item.getItemId()) {
              case R.id.action_share:
                  Toast.makeText(this, "Share option selected", Toast.LENGTH_SHORT).show();
                  return true;
              case R.id.action_settings:
                  Toast.makeText(this, "Settings option selected", Toast.LENGTH_SHORT).show();
                  return true;
              case R.id.action_contact:
                  Toast.makeText(this, "Contact option selected", Toast.LENGTH_SHORT).show();
                  return true;
              case R.id.action_print:
                  Toast.makeText(this, "Print option selected", Toast.LENGTH_SHORT).show();
                  return true;
              case R.id.action_exit:
                  Toast.makeText(this, "Exit option selected", Toast.LENGTH_SHORT).show();
                  return true;
              case R.id.action_search:
                  Toast.makeText(this, "Search option selected", Toast.LENGTH_SHORT).show();
                  return true;
              default:
                  return super.onOptionsItemSelected(item);
          }

    }



}
