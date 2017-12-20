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
import java.util.List;

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
        ViewHolder viewHolder;
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.nameTextView = listItemView.findViewById(R.id.name_text_view);
            viewHolder.symbolTextView = listItemView.findViewById(R.id.symbol_text_view);
            viewHolder.priceUsdTextView = listItemView.findViewById(R.id.priceUSD_text_view);
            viewHolder.percent24hTextView = listItemView.findViewById(R.id.percent24h_text_view);
            viewHolder.percent7dTextView = listItemView.findViewById(R.id.percent7d_text_view);
            viewHolder.iconImageView = listItemView.findViewById(R.id.list_item_icon);
            listItemView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Cryptocurrency currentCryptocurrency = getItem(position);

        viewHolder.nameTextView.setText(currentCryptocurrency.getName());

        viewHolder.symbolTextView.setText(currentCryptocurrency.getSymbol());

        String priceUSD = formatPrice(currentCryptocurrency.getPriceUSD());
        viewHolder.priceUsdTextView.setText(priceUSD);

        double percent24h = currentCryptocurrency.getPercentChange24h();
        setColor(viewHolder.percent24hTextView, percent24h);
        String percent24hString = formatPercent(percent24h);
        viewHolder.percent24hTextView.setText(percent24hString);

        double percent7d = currentCryptocurrency.getPercentChange7d();
        setColor(viewHolder.percent7dTextView, percent7d);
        String percent7dString = formatPercent(percent7d);
        viewHolder.percent7dTextView.setText(percent7dString);

        viewHolder.iconImageView.setImageResource(currentCryptocurrency.getImageResourceId());

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

    static class ViewHolder {
        TextView nameTextView;
        TextView symbolTextView;
        TextView priceUsdTextView;
        TextView percent24hTextView;
        TextView percent7dTextView;
        ImageView iconImageView;
    }
}
