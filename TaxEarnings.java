package tax;

public class TaxEarnings {
    public static int taxEarning(int earnings) {
        int tax = earnings * 6 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            // если расходы оказались больше, то налог посчитается отрицательным
            return 0;
        }
    }
}
