package fvadevand.cryptocurrencypricetracker;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String USGS_REQUEST_URL = "https://api.coinmarketcap.com/v1/ticker/?limit=10";
    private CryptocurrencyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdapter = new CryptocurrencyAdapter(this, new ArrayList<Cryptocurrency>());

        ListView listView = findViewById(R.id.list_view_currency);
        listView.setAdapter(mAdapter);

        CryptocurrencyAsyncTask task = new CryptocurrencyAsyncTask();
        task.execute(USGS_REQUEST_URL);

    }

    private class CryptocurrencyAsyncTask extends AsyncTask<String, Void, List<Cryptocurrency>> {

        @Override
        protected List<Cryptocurrency> doInBackground(String... urls) {
            if (urls.length < 1 || urls[0] == null) {
                return null;
            }
            List<Cryptocurrency> result = QueryUtils.fetchCryptocurrencyData(urls[0]);
            return result;
        }

        @Override
        protected void onPostExecute(List<Cryptocurrency> cryptocurrencies) {
            mAdapter.clear();
            if (cryptocurrencies != null && !cryptocurrencies.isEmpty()) {
                mAdapter.addAll(cryptocurrencies);
            }
        }
    }
}
