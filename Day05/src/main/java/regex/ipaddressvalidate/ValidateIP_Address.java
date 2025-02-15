package regex.ipaddressvalidate;

import java.util.regex.*;

public class ValidateIP_Address {
    public static void main(String[] args) {
        String[] testIPs = {
                "255.255.255.255",
                "192.168.1",
                "192.168.1.300",
                "abc.def.gha.bcd"
        };

        for (String ip : testIPs) {
            System.out.println(ip + " -> " + isValidIPAddress(ip));
        }
    }

    public static boolean isValidIPAddress(String ip) {

        String regex =
                "^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}" +
                        "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$";


        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ip);

        return matcher.matches();
    }
}
