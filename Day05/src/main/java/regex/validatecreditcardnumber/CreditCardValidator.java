package regex.validatecreditcardnumber;

import java.util.regex.*;

public class CreditCardValidator {
    public static void main(String[] args) {
        String[] testCards = {

                "5500000000000004",  // MasterCard
                "4012888888881881",  // Visa

                "1234567890123456",
                "4111111111111",
                "51111111111111117"
        };

        for (String card : testCards) {
            System.out.println(card + " -> " + isValidCreditCard(card));
        }
    }

    public static boolean isValidCreditCard(String cardNumber) {

        String regex = "^(4\\d{15}|5\\d{15})$";


        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cardNumber);

        return matcher.matches();
    }
}
