package fvadevand.cryptocurrencypricetracker;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by Vladimir on 18.12.2017.
 */

public class CryptocurrencyLoader extends AsyncTaskLoader<List<Cryptocurrency>> {

    private static final String LOG_TAG = CryptocurrencyLoader.class.getName();
    private String mUrl;

    public CryptocurrencyLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Cryptocurrency> loadInBackground() {
        if (mUrl == null) {
            return null;
        }
        List<Cryptocurrency> cryptocurrencies = QueryUtils.fetchCryptocurrencyData(mUrl);
        return cryptocurrencies;
    }

}
