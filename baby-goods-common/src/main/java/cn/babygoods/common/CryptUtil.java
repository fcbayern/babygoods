package cn.babygoods.common;

import java.security.MessageDigest;

/**
 * Created by Vincent on 2017/3/30.
 */
public class CryptUtil {
    private static final String hexDigits[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public static String MD5Encode(String origin, String charsetname) {
        String resultStr = new String(origin);
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname))
                resultStr = byteArrayToHexString(md.digest(resultStr.getBytes()));
            else
                resultStr = byteArrayToHexString(md.digest(resultStr.getBytes(charsetname)));
        } catch (Exception exception) {
        }
        return resultStr;
    }

    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
            resultSb.append(byteToHexString(b[i]));

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }
}
