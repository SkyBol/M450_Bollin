package com.example;

public class Price {
    /**
     * @param baseprice Grundpreis
     * @param specialprice Sondermodellaufschlag
     * @param extraprice weitere Zusatzaustattungen
     * @param extras Anzahl Zusatzausstattungen
     * @param discount Händlerrabatt
     */
    double calculatePrice(double baseprice, double specialprice, double extraprice, int extras, double discount) {
        double addon_discount = 0;
        double result;

        if (extras >= 3)
            addon_discount = 10;
        if (extras >= 5)
            addon_discount = 15;


        // if (discount > addon_discount)
        //     addon_discount = discount;

        result = baseprice/100.0 * (100-discount)
                + specialprice
                + extraprice/100.0 * (100-addon_discount);

        return result;
    }
}
