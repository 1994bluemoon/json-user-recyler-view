package vinova.henry.com.jsonuserrecyclerview.Activities;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import vinova.henry.com.jsonuserrecyclerview.Adapters.UserAdapter;
import vinova.henry.com.jsonuserrecyclerview.Models.User;
import vinova.henry.com.jsonuserrecyclerview.Models.UserResult;
import vinova.henry.com.jsonuserrecyclerview.R;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    public static final String SERVER_URL = "https://lit-basin-20477.herokuapp.com/users?page=0&limit=10";


    public UserAdapter adapter;
    List<User> users;
    @BindView(R.id.rcv_main)
    RecyclerView rcvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        new GetUserTask(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

        adapter = new UserAdapter(users, this);
        rcvMain.setAdapter(adapter);
        rcvMain.setLayoutManager(new LinearLayoutManager(this));
    }

    static class GetUserTask extends AsyncTask<Void, Void, List<User>> {
        @SuppressLint("StaticFieldLeak")
        private MainActivity activity;

        GetUserTask(MainActivity activity) {
            this.activity = activity;
        }

        @Override
        protected List<User> doInBackground(Void... voids) {
            String jsonResult = getJSON(SERVER_URL, 10 * 1000);
            Log.d(TAG, jsonResult);
            UserResult result = new Gson().fromJson(jsonResult, UserResult.class);
            return result.getUsers();
        }

        @Override
        protected void onPostExecute(List<User> users) {
            super.onPostExecute(users);
            activity.adapter.setUsers(users);
            activity.adapter.notifyDataSetChanged();
        }

        public static String getJSON(String url, int timeout) {
            HttpURLConnection c = null;
            try {
                URL u = new URL(url);
                c = (HttpURLConnection) u.openConnection();
                c.setRequestMethod("GET");
                c.setRequestProperty("Content-length", "0");
                c.setUseCaches(false);
                c.setAllowUserInteraction(false);
                c.setConnectTimeout(timeout);
                c.setReadTimeout(timeout);
                c.connect();
                int status = c.getResponseCode();

                switch (status) {
                    case 200:
                    case 201:
                        BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
                        StringBuilder sb = new StringBuilder();
                        String line;
                        while ((line = br.readLine()) != null) {
                            sb.append(line).append("\n");
                        }
                        br.close();
                        return sb.toString();
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return null;
        }
    }
}
