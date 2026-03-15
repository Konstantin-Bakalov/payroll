package formatting;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormatter implements CurrencyFormatterInterface {

    private final Locale locale;

    public CurrencyFormatter() {
       locale = Locale.GERMANY;
    }

    public CurrencyFormatter(Locale locale) {
        this.locale = locale;
    }

    public String format(double amount) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        return formatter.format(amount);
    }
}

