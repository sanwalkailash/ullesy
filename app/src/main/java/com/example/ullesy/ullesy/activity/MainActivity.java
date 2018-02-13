package com.example.ullesy.ullesy.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.view.KeyEvent;
import android.view.View.OnKeyListener;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ullesy.ullesy.R;
import com.example.ullesy.ullesy.core.AppConstants;
import com.example.ullesy.ullesy.core.ApiResponse;
import com.example.ullesy.ullesy.model.News;
import com.example.ullesy.ullesy.rest.NewsApi;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private SearchView searchBoxInput;
    private Toast toast;

    private EditText password;
    private Button btnSubmit;
    RelativeLayout relativeLayout;
    TextView newsLineTextView;
    private RecyclerView recyclerView = null;

    private static Retrofit retrofit = null;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initial settings --
        toast = Toast.makeText(getApplicationContext(), "Hi", Toast.LENGTH_LONG);
        toast.show();
        newsLineTextView = (TextView) findViewById(R.id.newsLineTextView);


        // ui drawing--
        addAppMenuBar();
        addKeyListenerOnSearchBox();

        connectAndGetApiData();
        getGithubUserDetails("sanwalkailash");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // This method create an instance of Retrofit
    // set the base url
    public void connectAndGetApiData(){
        System.out.println("api server url ["+AppConstants.API_SERVER_URL+"]");
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(AppConstants.API_SERVER_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        NewsApi newsApi = retrofit.create(NewsApi.class);
        Call<ApiResponse> call = newsApi.getDailyNews(AppConstants.API_KEY,AppConstants.formatedDate);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                ApiResponse restApiResponse = response.body();
                System.out.println(response);
                List<News> news = (List<News>) restApiResponse.getResponse();
                System.out.println(response.body());
//                recyclerView.setAdapter(new NewsAdaptar(news, R.layout.list_news, getApplicationContext()));
                Log.d(TAG, "Number of movies received: " + news.size());
            }
            @Override
            public void onFailure(Call<ApiResponse> call, Throwable throwable) {
                Log.e(TAG, throwable.toString());
            }
        });
    }
    public void getGithubUserDetails(String username){
        System.out.println("api server url ["+AppConstants.GIT_SERVER_URL+"]");
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(AppConstants.GIT_SERVER_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        NewsApi newsApi = retrofit.create(NewsApi.class);
        Call<List<Map<String,Object>>> call = newsApi.listRepos(username);
        call.enqueue(new Callback<List<Map<String,Object>>>() {
            @Override
            public void onResponse(Call<List<Map<String,Object>>> call, Response<List<Map<String,Object>>> response) {
                List<Map<String,Object>> apiresponse = response.body();
                System.out.println(response);
                Log.d(TAG, "taged response " + response.body());
            }
            @Override
            public void onFailure(Call<List<Map<String,Object>>> call, Throwable throwable) {
                Log.e(TAG, throwable.toString());
            }
        });
    }

    public void addAppMenuBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void addKeyListenerOnSearchBox() {
        System.out.println("@addKeyListenerOnSearchBox..");
        // get edittext component
        searchBoxInput = (SearchView) findViewById(R.id.searchBoxInput);
        Log.i(TAG,searchBoxInput.getQuery().toString());

        // add a keylistener to keep track user input
        searchBoxInput.setOnKeyListener(new OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                System.out.println("Entered key is " + keyCode);
                Log.i(TAG,"event --"+event.getAction());
                // if keydown and "enter" is pressed
                if ((event.getAction() == KeyEvent.ACTION_DOWN)
                        && (keyCode == KeyEvent.KEYCODE_ENTER)) {

                    // display a floating message
                    toast.setText(searchBoxInput.getQuery());
                    toast.show();
                    return true;

                } else if ((event.getAction() == KeyEvent.ACTION_DOWN)
                        && (keyCode == KeyEvent.KEYCODE_9)) {

                    // display a floating message
                    toast.setText("Number 9 is pressed!");
                    toast.show();
                    return true;
                }

                return false;
            }
        });
    }


    public void updateNewsBackground(String newsTitle) {
        relativeLayout = new RelativeLayout(this);
//        relativeLayout.setBackgroundResource(R.drawable.view); //or whatever your image is
        setContentView(relativeLayout); //you might be forgetting this
    }

}
