package fvadevand.cryptocurrencypricetracker;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladimir on 17.12.2017.
 */

public final class QueryUtils {

    public static final String LOG_TAG = QueryUtils.class.getSimpleName();

    private QueryUtils() {
    }

    private static List<Cryptocurrency> extractFeatureFromJson(String cryptocurrencyJSON) {

        if (TextUtils.isEmpty(cryptocurrencyJSON)) {
            return null;
        }

        List<Cryptocurrency> cryptocurrencyList = new ArrayList<>();

        try {

            JSONArray currency = new JSONArray(cryptocurrencyJSON);
            for (int i = 0; i < currency.length(); i++) {
                JSONObject currentCurrency = currency.getJSONObject(i);
                String name = currentCurrency.getString("name");
                Log.i("QueryUtils", name);
                String symbol = currentCurrency.getString("symbol");
                Double priceUSD = currentCurrency.getDouble("price_usd");
                Double percent24h = currentCurrency.getDouble("percent_change_24h");
                Double percent7d = currentCurrency.getDouble("percent_change_7d");
                int imageResourceId = getImageResourseId(symbol);
                cryptocurrencyList.add(new Cryptocurrency(name, symbol, priceUSD, percent24h, percent7d, imageResourceId));
            }

        } catch (JSONException e) {
            Log.e(LOG_TAG, "Problem parsing the cryptocurrency JSON results", e);
        }

        return cryptocurrencyList;
    }

    private static int getImageResourseId(String key) {

        ArrayMap<String, Integer> imageResourceIdMap = new ArrayMap<>();
        imageResourceIdMap.put("ACT", R.drawable.act);
        imageResourceIdMap.put("ADA", R.drawable.ada);
        imageResourceIdMap.put("ADX", R.drawable.adx);
        imageResourceIdMap.put("AE", R.drawable.ae);
        imageResourceIdMap.put("AION", R.drawable.aion);
        imageResourceIdMap.put("AMP", R.drawable.amp);
        imageResourceIdMap.put("ANT", R.drawable.ant);
        imageResourceIdMap.put("ARDR", R.drawable.ardr);
        imageResourceIdMap.put("ARK", R.drawable.ark);
        imageResourceIdMap.put("BAT", R.drawable.bat);
        imageResourceIdMap.put("BCC", R.drawable.bcc);
        imageResourceIdMap.put("BCH", R.drawable.bch);
        imageResourceIdMap.put("BCN", R.drawable.bcn);
        imageResourceIdMap.put("BDL", R.drawable.bdl);
        imageResourceIdMap.put("BLOCK", R.drawable.block);
        imageResourceIdMap.put("BNB", R.drawable.bnb);
        imageResourceIdMap.put("BNT", R.drawable.bnt);
        imageResourceIdMap.put("BQ", R.drawable.bq);
        imageResourceIdMap.put("BQX", R.drawable.bqx);
        imageResourceIdMap.put("BTC", R.drawable.btc);
        imageResourceIdMap.put("BTCD", R.drawable.btcd);
        imageResourceIdMap.put("BTG", R.drawable.btg);
        imageResourceIdMap.put("BTM", R.drawable.btm);
        imageResourceIdMap.put("BTS", R.drawable.bts);
        imageResourceIdMap.put("BTX", R.drawable.btx);
        imageResourceIdMap.put("CVC", R.drawable.cvc);
        imageResourceIdMap.put("DASH", R.drawable.dash);
        imageResourceIdMap.put("DATA", R.drawable.data);
        imageResourceIdMap.put("DCN", R.drawable.dcn);
        imageResourceIdMap.put("DCR", R.drawable.dcr);
        imageResourceIdMap.put("DGB", R.drawable.dgb);
        imageResourceIdMap.put("DGD", R.drawable.dgd);
        imageResourceIdMap.put("DOGE", R.drawable.doge);
        imageResourceIdMap.put("DRGN", R.drawable.drgn);
        imageResourceIdMap.put("EDG", R.drawable.edg);
        imageResourceIdMap.put("EDOGE", R.drawable.edoge);
        imageResourceIdMap.put("EMC", R.drawable.emc);
        imageResourceIdMap.put("EMC2", R.drawable.emc2);
        imageResourceIdMap.put("EOS", R.drawable.eos);
        imageResourceIdMap.put("ETC", R.drawable.etc);
        imageResourceIdMap.put("ETH", R.drawable.eth);
        imageResourceIdMap.put("ETHOS", R.drawable.ethos);
        imageResourceIdMap.put("ETP", R.drawable.etp);
        imageResourceIdMap.put("EXMO", R.drawable.exmo);
        imageResourceIdMap.put("FAIR", R.drawable.fair);
        imageResourceIdMap.put("FCT", R.drawable.fct);
        imageResourceIdMap.put("FIL", R.drawable.fil);
        imageResourceIdMap.put("FUN", R.drawable.fun);
        imageResourceIdMap.put("GAME", R.drawable.game);
        imageResourceIdMap.put("GBYTE", R.drawable.gbyte);
        imageResourceIdMap.put("GNO", R.drawable.gno);
        imageResourceIdMap.put("GNT", R.drawable.gnt);
        imageResourceIdMap.put("GRS", R.drawable.grs);
        imageResourceIdMap.put("GUP", R.drawable.gup);
        imageResourceIdMap.put("GXS", R.drawable.gxs);
        imageResourceIdMap.put("HSR", R.drawable.hsr);
        imageResourceIdMap.put("ICN", R.drawable.icn);
        imageResourceIdMap.put("KCS", R.drawable.kcs);
        imageResourceIdMap.put("KMD", R.drawable.kmd);
        imageResourceIdMap.put("KNC", R.drawable.knc);
        imageResourceIdMap.put("KRB", R.drawable.krb);
        imageResourceIdMap.put("LKK", R.drawable.lkk);
        imageResourceIdMap.put("LRC", R.drawable.lrc);
        imageResourceIdMap.put("LSK", R.drawable.lsk);
        imageResourceIdMap.put("LTC", R.drawable.ltc);
        imageResourceIdMap.put("MAID", R.drawable.maid);
        imageResourceIdMap.put("MANA", R.drawable.mana);
        imageResourceIdMap.put("MCAP", R.drawable.mcap);
        imageResourceIdMap.put("MCO", R.drawable.mco);
        imageResourceIdMap.put("MIOTA", R.drawable.miota);
        imageResourceIdMap.put("MLN", R.drawable.mln);
        imageResourceIdMap.put("MNX", R.drawable.mnx);
        imageResourceIdMap.put("MONA", R.drawable.mona);
        imageResourceIdMap.put("MTL", R.drawable.mtl);
        imageResourceIdMap.put("MUSIC", R.drawable.music);
        imageResourceIdMap.put("NAV", R.drawable.nav);
        imageResourceIdMap.put("NEBL", R.drawable.nebl);
        imageResourceIdMap.put("NEO", R.drawable.neo);
        imageResourceIdMap.put("NLG", R.drawable.nlg);
        imageResourceIdMap.put("NMC", R.drawable.nmc);
        imageResourceIdMap.put("NXT", R.drawable.nxt);
        imageResourceIdMap.put("OMG", R.drawable.omg);
        imageResourceIdMap.put("PART", R.drawable.part);
        imageResourceIdMap.put("PAY", R.drawable.pay);
        imageResourceIdMap.put("PIVX", R.drawable.pivx);
        imageResourceIdMap.put("POT", R.drawable.pot);
        imageResourceIdMap.put("PPC", R.drawable.ppc);
        imageResourceIdMap.put("PPT", R.drawable.ppt);
        imageResourceIdMap.put("PURA", R.drawable.pura);
        imageResourceIdMap.put("QASH", R.drawable.qash);
        imageResourceIdMap.put("QIWI", R.drawable.qiwi);
        imageResourceIdMap.put("QTUM", R.drawable.qtum);
        imageResourceIdMap.put("RDN", R.drawable.rdn);
        imageResourceIdMap.put("REP", R.drawable.rep);
        imageResourceIdMap.put("RHOC", R.drawable.rhoc);
        imageResourceIdMap.put("RLC", R.drawable.rlc);
        imageResourceIdMap.put("SALT", R.drawable.salt);
        imageResourceIdMap.put("SAN", R.drawable.san);
        imageResourceIdMap.put("SBERBANK", R.drawable.sberbank);
        imageResourceIdMap.put("SC", R.drawable.sc);
        imageResourceIdMap.put("SKY", R.drawable.sky);
        imageResourceIdMap.put("SMART", R.drawable.smart);
        imageResourceIdMap.put("SNGLS", R.drawable.sngls);
        imageResourceIdMap.put("SNT", R.drawable.snt);
        imageResourceIdMap.put("STEEM", R.drawable.steem);
        imageResourceIdMap.put("STORJ", R.drawable.storj);
        imageResourceIdMap.put("STRAT", R.drawable.strat);
        imageResourceIdMap.put("SUB", R.drawable.sub);
        imageResourceIdMap.put("TAAS", R.drawable.taas);
        imageResourceIdMap.put("TKN", R.drawable.tkn);
        imageResourceIdMap.put("TRX", R.drawable.trx);
        imageResourceIdMap.put("UBQ", R.drawable.ubq);
        imageResourceIdMap.put("USDT", R.drawable.usdt);
        imageResourceIdMap.put("VEN", R.drawable.ven);
        imageResourceIdMap.put("VERI", R.drawable.veri);
        imageResourceIdMap.put("VTC", R.drawable.vtc);
        imageResourceIdMap.put("WAVES", R.drawable.waves);
        imageResourceIdMap.put("WTC", R.drawable.wtc);
        imageResourceIdMap.put("XCP", R.drawable.xcp);
        imageResourceIdMap.put("XEM", R.drawable.xem);
        imageResourceIdMap.put("XLM", R.drawable.xlm);
        imageResourceIdMap.put("XMR", R.drawable.xmr);
        imageResourceIdMap.put("XRB", R.drawable.xrb);
        imageResourceIdMap.put("XRP", R.drawable.xrp);
        imageResourceIdMap.put("XTZ", R.drawable.xtz);
        imageResourceIdMap.put("XUC", R.drawable.xuc);
        imageResourceIdMap.put("XVG", R.drawable.xvg);
        imageResourceIdMap.put("XZC", R.drawable.xzc);
        imageResourceIdMap.put("ZEC", R.drawable.zec);
        imageResourceIdMap.put("ZEN", R.drawable.zen);
        imageResourceIdMap.put("ZRX", R.drawable.zrx);

        if (imageResourceIdMap.containsKey(key)) {
            return imageResourceIdMap.get(key);
        }
        return R.drawable.no_image_available;
    }

    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Problem building the URL", e);
        }
        return url;
    }

    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        if (url == null) {
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;

        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(15000);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the earthquake JSON results.", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    public static List<Cryptocurrency> fetchCryptocurrencyData(String requestURL) {
        URL url = createUrl(requestURL);

        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem making the HTTP request.", e);
        }

        List<Cryptocurrency> cryptocurrencies = extractFeatureFromJson(jsonResponse);

        return cryptocurrencies;
    }

}
