package fvadevand.cryptocurrencypricetracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;


import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Cryptocurrency> cryptocurrencyList = QueryUtils.extractCryptocurrency();
        CryptocurrencyAdapter cryptocurrencyAdapter = new CryptocurrencyAdapter(this, cryptocurrencyList);

        ListView listView = findViewById(R.id.list_view_currency);
        listView.setAdapter(cryptocurrencyAdapter);

    }
}
