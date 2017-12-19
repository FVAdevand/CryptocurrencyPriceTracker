package fvadevand.cryptocurrencypricetracker;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by Vladimir on 17.12.2017.
 */

public class CryptocurrencyAdapter extends ArrayAdapter<Cryptocurrency> {

    private static final String LOG_TAG = CryptocurrencyAdapter.class.getSimpleName();


    public CryptocurrencyAdapter(@NonNull Context context, @NonNull List<Cryptocurrency> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Cryptocurrency currentCryptocurrency = getItem(position);

        TextView nameTextView = listItemView.findViewById(R.id.name_text_view);
        nameTextView.setText(currentCryptocurrency.getName());

        TextView symbolVextView = listItemView.findViewById(R.id.symbol_text_view);
        symbolVextView.setText(currentCryptocurrency.getSymbol());

        TextView priceUsdTextView = listItemView.findViewById(R.id.priceUSD_text_view);
        String priceUSD = formatPrice(currentCryptocurrency.getPriceUSD());
        priceUsdTextView.setText(priceUSD);

        TextView percent24hTextView = listItemView.findViewById(R.id.percent24h_text_view);
        double percent24h = currentCryptocurrency.getPercentChange24h();
        setColor(percent24hTextView, percent24h);
        String percent24hString = formatPercent(percent24h);
        percent24hTextView.setText(percent24hString);

        TextView percent7dTextView = listItemView.findViewById(R.id.percent7d_text_view);
        double percent7d = currentCryptocurrency.getPercentChange7d();
        setColor(percent7dTextView, percent7d);
        String percent7dString = formatPercent(percent7d);
        percent7dTextView.setText(percent7dString);

        ImageView iconImageView = listItemView.findViewById(R.id.list_item_icon);
        iconImageView.setImageResource(currentCryptocurrency.getImageResourceId());

        return listItemView;

    }

    private String formatPrice(double price) {
        DecimalFormat priceFormat = new DecimalFormat("###,###,###.###'$'");
        return priceFormat.format(price);
    }

    private String formatPercent(double percent) {
        DecimalFormat percentFormat = new DecimalFormat("0.0#'%'");
        return percentFormat.format(percent);
    }

    private void setColor(TextView textView, double number) {
        if (number < 0) {
            textView.setTextColor(getContext().getResources().getColor(R.color.colorNegativeNumber));
        } else {
            textView.setTextColor(getContext().getResources().getColor(R.color.colorPositiveNumber));
        }
    }
}
