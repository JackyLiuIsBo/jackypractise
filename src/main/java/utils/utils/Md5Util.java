package utils.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * todo 别忘了添加注释!!!!
 *
 * @author wei.gw
 * @date 2019-06-18
 */
public class Md5Util {

    private static final Log log = LogFactory.getLog(Md5Util.class);

    public static String md5(String text) {
        MessageDigest md5 = null;
        String md5Str = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            md5Str = Hex.encodeHexString(md5.digest(text.getBytes("utf-8")));
        } catch (NoSuchAlgorithmException e) {
            log.error("md5 encode error", e);
        } catch (UnsupportedEncodingException e) {
            log.error("md5 encode error", e);
        }

        return md5Str;
    }
}
