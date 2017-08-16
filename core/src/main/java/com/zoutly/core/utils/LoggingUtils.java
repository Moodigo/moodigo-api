package com.zoutly.core.utils;

import org.apache.log4j.Logger;

public class LoggingUtils {
    public static Logger getLogger(Class clazz) {
        return Logger.getLogger(clazz);
    }
}
