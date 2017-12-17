package fvadevand.cryptocurrencypricetracker;

import android.util.ArrayMap;
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
                int imageResourceId = getImageResourseId(symbol);
                cryptocurrencyList.add(new Cryptocurrency(name, symbol, priceUSD, percent24h, percent7d, imageResourceId));
            }

        } catch (JSONException e) {
            Log.e("QueryUtils", "Problem parsing the cryptocurrency JSON results", e);
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

}
