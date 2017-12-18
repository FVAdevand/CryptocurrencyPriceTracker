package fvadevand.cryptocurrencypricetracker;

import android.app.LoaderManager;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Cryptocurrency>> {

    private static final String USGS_REQUEST_URL = "https://api.coinmarketcap.com/v1/ticker/?limit=10";
    private static final int CRYPTOCURRENCY_LOADER_ID = 1;
    private CryptocurrencyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdapter = new CryptocurrencyAdapter(this, new ArrayList<Cryptocurrency>());

        ListView listView = findViewById(R.id.list_view_currency);
        listView.setAdapter(mAdapter);

        getLoaderManager().initLoader(CRYPTOCURRENCY_LOADER_ID, null, this);

    }


    @Override
    public Loader<List<Cryptocurrency>> onCreateLoader(int i, Bundle bundle) {
        return new CryptocurrencyLoader(this, USGS_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<Cryptocurrency>> loader, List<Cryptocurrency> cryptocurrencies) {
        mAdapter.clear();
        if (cryptocurrencies != null && !cryptocurrencies.isEmpty()) {
            mAdapter.addAll(cryptocurrencies);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Cryptocurrency>> loader) {
        mAdapter.clear();
    }
}
