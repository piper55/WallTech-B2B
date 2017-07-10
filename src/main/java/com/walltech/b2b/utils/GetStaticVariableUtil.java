package com.walltech.b2b.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by zeddwang on 2017/7/5.
 */
@Component
public class GetStaticVariableUtil {
    public static String homeUrl;
    public static String resourceUrl;

    @Value(value = "${homeUrl}")
    public static void setHomeUrl(String homeUrl) {
        GetStaticVariableUtil.homeUrl = homeUrl;
    }
    @Value(value = "${resourceUrl}")
    public static void setResourceUrl(String resourceUrl) {
        GetStaticVariableUtil.resourceUrl = resourceUrl;
    }
}
