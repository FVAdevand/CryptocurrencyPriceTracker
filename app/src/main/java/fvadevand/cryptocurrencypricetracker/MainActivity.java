package fvadevand.cryptocurrencypricetracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Cryptocurrency> cryptocurrencyList = new ArrayList<>();
        cryptocurrencyList.add(new Cryptocurrency("Bitcoin", "BTC", 19908.101, 10.20, 38.51, R.drawable.btc));
        cryptocurrencyList.add(new Cryptocurrency("Bitcoin", "BTC", 19908.14566, 10.24, 38.51, R.drawable.btc));
        cryptocurrencyList.add(new Cryptocurrency("Bitcoin", "BTC", 19908.1, 10.256, 38.51, R.drawable.btc));

        CryptocurrencyAdapter cryptocurrencyAdapter = new CryptocurrencyAdapter(this, cryptocurrencyList);

        ListView listView = findViewById(R.id.list_view_currency);
        listView.setAdapter(cryptocurrencyAdapter);

    }
}
