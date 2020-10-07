package com.shui.server.utils;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.concurrent.ThreadLocalRandom;

/**
 *  随机数生成util
 */
public class RandomUtil {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
    // ThreadLocalRandom 高并发下保证线程安全，相比Random
    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    /**
     *  生成订单编号-方式一
     */
    public static String generateOrderCode(){
        // 时间戳 + 4位随机数流水号
        return sdf.format(DateTime.now().toDate()) + generateNumber(4);
    }

    // num位随机数流水号
    public static String generateNumber(final int num){
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= num; i++){
            sb.append(random.nextInt(9)); // 0～9
        }
        return sb.toString();
    }

}