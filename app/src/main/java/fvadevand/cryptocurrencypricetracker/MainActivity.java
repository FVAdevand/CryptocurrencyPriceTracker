package fvadevand.cryptocurrencypricetracker;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Cryptocurrency>> {

    private static final String USGS_REQUEST_URL = "https://api.coinmarketcap.com/v1/ticker/?limit=10";
    private static final int CRYPTOCURRENCY_LOADER_ID = 1;
    private CryptocurrencyAdapter mAdapter;
    private TextView mEmptyStateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.list_view_currency);

        mEmptyStateTextView = findViewById(R.id.empty_view);
        listView.setEmptyView(mEmptyStateTextView);

        mAdapter = new CryptocurrencyAdapter(this, new ArrayList<Cryptocurrency>());
        listView.setAdapter(mAdapter);

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            getLoaderManager().initLoader(CRYPTOCURRENCY_LOADER_ID, null, this);
        } else {
            View progressBar = findViewById(R.id.progress_bar);
            progressBar.setVisibility(View.GONE);
            mEmptyStateTextView.setText(getString(R.string.no_internet_connection));
        }
    }


    @Override
    public Loader<List<Cryptocurrency>> onCreateLoader(int i, Bundle bundle) {
        return new CryptocurrencyLoader(this, USGS_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<Cryptocurrency>> loader, List<Cryptocurrency> cryptocurrencies) {
        View progressBar = findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.GONE);
        mEmptyStateTextView.setText(getString(R.string.no_cryptocurrency));
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
