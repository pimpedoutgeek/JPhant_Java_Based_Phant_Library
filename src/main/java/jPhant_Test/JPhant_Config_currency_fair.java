package jPhant_Test;

/**
 * Created by davidb on 3/25/15.
 */
public class JPhant_Config_currency_fair implements JPhant.JPhant.JPhantConfig {
    // *** Enter Public/Private/Delete Keys below *** //

	private static final String sPHANT_PUBLIC_KEY 	= "yApEDDLqE3sga0JAKowj";
	private static final String sPHANT_PRIVATE_KEY 	= "4WgMKKvNM7tmqDG659eM";

    //private static final String sPHANT_DELETE_KEY = "y33z18M8AjS5yz3vJnLY";

    // *** Enter your Field Names below (Case Sensitive!) in SAME ORDER as Phant Returns *** //
    // *** For Example: public enum Fields { Id, Temperature, Pressure, Humidity, WindSpeed };
    public enum Fields { userid, currencyfrom, currencyto, amountsell, amountbuy, rate, timeplaced, originatingcountry }

    // *** If running your own Phant Server, enter URL below *** //
    private static final String sPHANT_BASE_URL = "https://data.sparkfun.com/";

    // *** If you're behind a Firewall/Proxy Server, enter ProxyHost:ProxyPort below, otherwise leave blank *** //
    // *** Example: sPROXYHOST_AND_PORT = "CompanyProxyServer:8080"; *** //
    private static final String sPROXYHOST_AND_PORT = "";

    // *** getMethod can return GET or POST (POST is recommended so PrivateKey & Data are encrypted in transit) *** //
    public JPhant.JPhant.JPhantConfig.Method getMethod() { return JPhant.JPhant.JPhantConfig.Method.POST; }

    // *** *** *** *** Don't touch anything below this Line *** *** *** //
    public String getBaseURL() { return sPHANT_BASE_URL; }
    public String getProxyHostAndPort() { return sPROXYHOST_AND_PORT; }
    public String getPublicKey() { return sPHANT_PUBLIC_KEY; }
    public String getPrivateKey() { return sPHANT_PRIVATE_KEY; }
    //public String getDeleteKey() { return sPHANT_DELETE_KEY; }
    public String[] getFields() { String[] asFields = new String[Fields.values().length]; for(int x=0 ; x<Fields.values().length ; x++) { asFields[x] = Fields.values()[x].toString(); } return asFields; }
}
