package fvadevand.cryptocurrencypricetracker;

/**
 * Created by Vladimir on 17.12.2017.
 */

public class Cryptocurrency {

    private String mName;
    private String mSymbol;
    private double mPriceUSD;
    private double mPercentChange24h;
    private double mPercentChange7d;
    private int mImageResourceId;

    public Cryptocurrency(String name,
                          String symbol,
                          double priceUSD,
                          double percentChange24h,
                          double percentChange7d,
                          int imageResourceId) {
        mName = name;
        mSymbol = symbol;
        mPriceUSD = priceUSD;
        mPercentChange24h = percentChange24h;
        mPercentChange7d = percentChange7d;
        mImageResourceId = imageResourceId;
    }

    public String getName() {
        return mName;
    }

    public String getSymbol() {
        return mSymbol;
    }

    public double getPriceUSD() {
        return mPriceUSD;
    }

    public double getPercentChange24h() {
        return mPercentChange24h;
    }

    public double getPercentChange7d() {
        return mPercentChange7d;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }
}
