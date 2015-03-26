package jPhant_Test;

import JPhant.JPhant;

/**
 * Created by davidb on 3/25/15.
 */
public class JPhant_Currency_Fair_Test {
    
    
    public static void main(String[] sArgs) {
        // Configure
        final JPhant jPhant1 = new JPhant(new JPhant_Config_currency_fair());

       
        System.out.println("Manual URL: "+jPhant1.getsPhantURL()+"streams/"+jPhant1.getsPublicKey());

        System.out.println("---------------------------------");
        System.out.println("Test Clear & Stats");
        jPhant1.clear();
        System.out.println("\tStatus="+jPhant1.getStatus().toString());
        System.out.println("\tVerify PageCount==0 and Used==0 above...");
        System.out.println();

        System.out.println("---------------------------------");
        System.out.println("AddData and Verify");
        final String sID = "1";
//		final String sDATA = "!\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~'";
//		final String sDATA = "Blagh";
        final String[] SDATA = {
                "134256",
                "EUR",
                "GBP",
                String.valueOf(1000),
                String.valueOf(747.1),
                String.valueOf(0.7471),
                "24-JAN-15 10:27:44",
                "FR"
        };

        final String[] SFIELDS = new String[] { "userid", "currencyfrom", "currencyto", "amountsell", "amountbuy", "rate", "timeplaced", "originatingcountry" };
        
//        String[][] aasAddData = jPhant1.toStringArrayOfStringArrays(null);
        
        /*String[][] aasAddData = new String[][] {{ "userid", "currencyfrom", "currencyto", "amountsell", "amountbuy", "rate", "timeplaced", "originatingcountry" },
                                                { "134256", "EUR", "GBP", String.valueOf(1000), String.valueOf(747.1), String.valueOf(0.7471), "24-JAN-15 10:27:44", "FR" }};*/

        String[][] aasAddData = new String[2][SDATA.length];

        for (int j=0; j<SDATA.length; j++) {
            aasAddData[0][j] = SFIELDS[j];
            aasAddData[1][j] = SDATA[j];
        }
        
        final boolean bTest = jPhant1.addData(aasAddData);
        System.out.println("\tbTest="+bTest);
//		aasAddData[1] = new String[] { sDATA, sID };
        System.out.println("\tAddData: "+jPhant1.toStringArrayListOfStringArrayLists(aasAddData).toString());
        jPhant1.addData(aasAddData);
        final String[][] aasReturnData = jPhant1.getData();
        System.out.println("\tRcvd:'"+jPhant1.toStringArrayListOfStringArrayLists(aasReturnData).toString()+"'");
        /*System.out.println("\tSent:'"+sTest+"'");
        System.out.println("\tRecv:'"+aasReturnData[1][0]+"'");
        System.out.println("\t"+sTest.equals(aasReturnData[1][0]));
        System.out.println();*/
//        final String[][] aasGetData = jPhant1.getData();
        System.out.println("\tGetData: "+jPhant1.toStringArrayListOfStringArrayLists(aasReturnData).toString());
        System.out.println("\tVerify AddData & GetData are identical above (w/ addition of timstamp)...");
        System.out.println("\tData Identical="+(aasAddData[0][0].equals(aasReturnData[0][0]) && aasAddData[0][1].equals(aasReturnData[0][1]) && aasAddData[1][0].equals(aasReturnData[1][0]) && aasAddData[1][1].equals(aasReturnData[1][1])));
        //System.out.println("\tData Identical="+(aasAddData[0][0].equals(aasGetData[0][0])+", "+aasAddData[0][1].equals(aasGetData[0][1])+", "+aasAddData[1][0].equals(aasGetData[1][0])+", "+aasAddData[1][1].equals(aasGetData[1][1])));
        System.out.println("\tStatus="+jPhant1.getStatus().toString());
        System.out.println("\tVerify PageCount==1 and Used>0 above...");

        System.out.println("\tTest Get Rate Limits...");
        System.out.println("\t\tgetXRateLimitLimit()="+jPhant1.getXRateLimitLimit());
        System.out.println("\t\tgetXRateLimitRemaining()="+jPhant1.getXRateLimitRemaining());
        System.out.println("\t\tgetXRateLimitReset()="+jPhant1.getXRateLimitReset());
        System.out.println();

        for(String[] asRow : aasReturnData) {
            for(String sField : asRow) {
                System.out.print(sField+", ");
            }
            System.out.println();
        }

        System.out.println("---------------------------------");
        System.out.println("AddData until PageCount==2 and Verify Page2");
        String sBigData = "";
        /*while(sBigData.length()<10000) {
            sBigData += SDATA[0];
        }*/
        int iID = 1;
        JPhant.Stats sStats = jPhant1.getStatus();

        System.out.println("\tTest Get Rate Limits...");
        System.out.println("\t\tgetXRateLimitLimit()="+jPhant1.getXRateLimitLimit());
        System.out.println("\t\tgetXRateLimitRemaining()="+jPhant1.getXRateLimitRemaining());
        System.out.println("\t\tgetXRateLimitReset()="+jPhant1.getXRateLimitReset());
        System.out.println();

        System.out.println("---------------------------------");
        System.out.println("Clear & Stats");
        jPhant1.clear();
        System.out.println("\tStatus="+jPhant1.getStatus().toString());
        System.out.println();
    }
}
