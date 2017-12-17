package fvadevand.cryptocurrencypricetracker;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladimir on 17.12.2017.
 */

public final class QueryUtils {

    private static final String SAMPLE_JSON_RESPONSE = "[\n" +
            "    {\n" +
            "        \"id\": \"bitcoin\", \n" +
            "        \"name\": \"Bitcoin\", \n" +
            "        \"symbol\": \"BTC\", \n" +
            "        \"rank\": \"1\", \n" +
            "        \"price_usd\": \"19563.6\", \n" +
            "        \"price_btc\": \"1.0\", \n" +
            "        \"24h_volume_usd\": \"14102500000.0\", \n" +
            "        \"market_cap_usd\": \"327641136673\", \n" +
            "        \"available_supply\": \"16747487.0\", \n" +
            "        \"total_supply\": \"16747487.0\", \n" +
            "        \"max_supply\": \"21000000.0\", \n" +
            "        \"percent_change_1h\": \"-0.19\", \n" +
            "        \"percent_change_24h\": \"3.85\", \n" +
            "        \"percent_change_7d\": \"29.8\", \n" +
            "        \"last_updated\": \"1513526955\"\n" +
            "    }, \n" +
            "    {\n" +
            "        \"id\": \"ethereum\", \n" +
            "        \"name\": \"Ethereum\", \n" +
            "        \"symbol\": \"ETH\", \n" +
            "        \"rank\": \"2\", \n" +
            "        \"price_usd\": \"717.451\", \n" +
            "        \"price_btc\": \"0.036731\", \n" +
            "        \"24h_volume_usd\": \"2182870000.0\", \n" +
            "        \"market_cap_usd\": \"69160723992.0\", \n" +
            "        \"available_supply\": \"96397836.0\", \n" +
            "        \"total_supply\": \"96397836.0\", \n" +
            "        \"max_supply\": null, \n" +
            "        \"percent_change_1h\": \"0.31\", \n" +
            "        \"percent_change_24h\": \"3.74\", \n" +
            "        \"percent_change_7d\": \"59.52\", \n" +
            "        \"last_updated\": \"1513526959\"\n" +
            "    }, \n" +
            "    {\n" +
            "        \"id\": \"bitcoin-cash\", \n" +
            "        \"name\": \"Bitcoin Cash\", \n" +
            "        \"symbol\": \"BCH\", \n" +
            "        \"rank\": \"3\", \n" +
            "        \"price_usd\": \"1856.74\", \n" +
            "        \"price_btc\": \"0.0950589\", \n" +
            "        \"24h_volume_usd\": \"1072420000.0\", \n" +
            "        \"market_cap_usd\": \"31305750444.0\", \n" +
            "        \"available_supply\": \"16860600.0\", \n" +
            "        \"total_supply\": \"16860600.0\", \n" +
            "        \"max_supply\": \"21000000.0\", \n" +
            "        \"percent_change_1h\": \"0.05\", \n" +
            "        \"percent_change_24h\": \"3.53\", \n" +
            "        \"percent_change_7d\": \"40.13\", \n" +
            "        \"last_updated\": \"1513526993\"\n" +
            "    }, \n" +
            "    {\n" +
            "        \"id\": \"ripple\", \n" +
            "        \"name\": \"Ripple\", \n" +
            "        \"symbol\": \"XRP\", \n" +
            "        \"rank\": \"4\", \n" +
            "        \"price_usd\": \"0.7376\", \n" +
            "        \"price_btc\": \"0.00003776\", \n" +
            "        \"24h_volume_usd\": \"980083000.0\", \n" +
            "        \"market_cap_usd\": \"28573993239.0\", \n" +
            "        \"available_supply\": \"38739144847.0\", \n" +
            "        \"total_supply\": \"99993093880.0\", \n" +
            "        \"max_supply\": \"100000000000\", \n" +
            "        \"percent_change_1h\": \"0.85\", \n" +
            "        \"percent_change_24h\": \"-3.8\", \n" +
            "        \"percent_change_7d\": \"210.42\", \n" +
            "        \"last_updated\": \"1513526941\"\n" +
            "    }, \n" +
            "    {\n" +
            "        \"id\": \"litecoin\", \n" +
            "        \"name\": \"Litecoin\", \n" +
            "        \"symbol\": \"LTC\", \n" +
            "        \"rank\": \"5\", \n" +
            "        \"price_usd\": \"322.559\", \n" +
            "        \"price_btc\": \"0.0165139\", \n" +
            "        \"24h_volume_usd\": \"1821990000.0\", \n" +
            "        \"market_cap_usd\": \"17530979448.0\", \n" +
            "        \"available_supply\": \"54349683.0\", \n" +
            "        \"total_supply\": \"54349683.0\", \n" +
            "        \"max_supply\": \"84000000.0\", \n" +
            "        \"percent_change_1h\": \"0.72\", \n" +
            "        \"percent_change_24h\": \"7.86\", \n" +
            "        \"percent_change_7d\": \"121.65\", \n" +
            "        \"last_updated\": \"1513526943\"\n" +
            "    }, \n" +
            "    {\n" +
            "        \"id\": \"cardano\", \n" +
            "        \"name\": \"Cardano\", \n" +
            "        \"symbol\": \"ADA\", \n" +
            "        \"rank\": \"6\", \n" +
            "        \"price_usd\": \"0.537699\", \n" +
            "        \"price_btc\": \"0.00002753\", \n" +
            "        \"24h_volume_usd\": \"866732000.0\", \n" +
            "        \"market_cap_usd\": \"13940959901.0\", \n" +
            "        \"available_supply\": \"25927070538.0\", \n" +
            "        \"total_supply\": \"31112483745.0\", \n" +
            "        \"max_supply\": \"45000000000.0\", \n" +
            "        \"percent_change_1h\": \"8.18\", \n" +
            "        \"percent_change_24h\": \"96.12\", \n" +
            "        \"percent_change_7d\": \"384.87\", \n" +
            "        \"last_updated\": \"1513527004\"\n" +
            "    }, \n" +
            "    {\n" +
            "        \"id\": \"iota\", \n" +
            "        \"name\": \"IOTA\", \n" +
            "        \"symbol\": \"MIOTA\", \n" +
            "        \"rank\": \"7\", \n" +
            "        \"price_usd\": \"3.61751\", \n" +
            "        \"price_btc\": \"0.0001852\", \n" +
            "        \"24h_volume_usd\": \"289474000.0\", \n" +
            "        \"market_cap_usd\": \"10054978594.0\", \n" +
            "        \"available_supply\": \"2779530283.0\", \n" +
            "        \"total_supply\": \"2779530283.0\", \n" +
            "        \"max_supply\": \"2779530283.0\", \n" +
            "        \"percent_change_1h\": \"-1.88\", \n" +
            "        \"percent_change_24h\": \"-1.19\", \n" +
            "        \"percent_change_7d\": \"-15.61\", \n" +
            "        \"last_updated\": \"1513526988\"\n" +
            "    }, \n" +
            "    {\n" +
            "        \"id\": \"dash\", \n" +
            "        \"name\": \"Dash\", \n" +
            "        \"symbol\": \"DASH\", \n" +
            "        \"rank\": \"8\", \n" +
            "        \"price_usd\": \"1107.54\", \n" +
            "        \"price_btc\": \"0.0567023\", \n" +
            "        \"24h_volume_usd\": \"446923000.0\", \n" +
            "        \"market_cap_usd\": \"8593086014.0\", \n" +
            "        \"available_supply\": \"7758714.0\", \n" +
            "        \"total_supply\": \"7758714.0\", \n" +
            "        \"max_supply\": \"18900000.0\", \n" +
            "        \"percent_change_1h\": \"3.89\", \n" +
            "        \"percent_change_24h\": \"22.18\", \n" +
            "        \"percent_change_7d\": \"60.18\", \n" +
            "        \"last_updated\": \"1513526944\"\n" +
            "    }, \n" +
            "    {\n" +
            "        \"id\": \"nem\", \n" +
            "        \"name\": \"NEM\", \n" +
            "        \"symbol\": \"XEM\", \n" +
            "        \"rank\": \"9\", \n" +
            "        \"price_usd\": \"0.692906\", \n" +
            "        \"price_btc\": \"0.00003547\", \n" +
            "        \"24h_volume_usd\": \"89553800.0\", \n" +
            "        \"market_cap_usd\": \"6236153999.0\", \n" +
            "        \"available_supply\": \"8999999999.0\", \n" +
            "        \"total_supply\": \"8999999999.0\", \n" +
            "        \"max_supply\": null, \n" +
            "        \"percent_change_1h\": \"2.01\", \n" +
            "        \"percent_change_24h\": \"7.53\", \n" +
            "        \"percent_change_7d\": \"73.77\", \n" +
            "        \"last_updated\": \"1513526953\"\n" +
            "    }, \n" +
            "    {\n" +
            "        \"id\": \"monero\", \n" +
            "        \"name\": \"Monero\", \n" +
            "        \"symbol\": \"XMR\", \n" +
            "        \"rank\": \"10\", \n" +
            "        \"price_usd\": \"349.185\", \n" +
            "        \"price_btc\": \"0.0178771\", \n" +
            "        \"24h_volume_usd\": \"274975000.0\", \n" +
            "        \"market_cap_usd\": \"5406001954.0\", \n" +
            "        \"available_supply\": \"15481770.0\", \n" +
            "        \"total_supply\": \"15481770.0\", \n" +
            "        \"max_supply\": null, \n" +
            "        \"percent_change_1h\": \"0.19\", \n" +
            "        \"percent_change_24h\": \"8.93\", \n" +
            "        \"percent_change_7d\": \"42.52\", \n" +
            "        \"last_updated\": \"1513526947\"\n" +
            "    }\n" +
            "]";


    private QueryUtils() {
    }

    public static List<Cryptocurrency> extractCryptocurrency() {


        ArrayList<Cryptocurrency> cryptocurrencyList = new ArrayList<>();

        try {

            JSONArray currency = new JSONArray(SAMPLE_JSON_RESPONSE);
            for (int i = 0; i < currency.length(); i++) {
                JSONObject currentCurrency = currency.getJSONObject(i);
                String name = currentCurrency.getString("name");
                Log.i("QueryUtils", name);
                String symbol = currentCurrency.getString("symbol");
                Double priceUSD = currentCurrency.getDouble("price_usd");
                Double percent24h = currentCurrency.getDouble("percent_change_24h");
                Double percent7d = currentCurrency.getDouble("percent_change_7d");
                cryptocurrencyList.add(new Cryptocurrency(name, symbol, priceUSD, percent24h, percent7d, R.drawable.btc));
            }

        } catch (JSONException e) {
            Log.e("QueryUtils", "Problem parsing the cryptocurrency JSON results", e);
        }

        return cryptocurrencyList;
    }

}
