package org.hakiko.supermarket.utils;

// Java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerUtil.class);

    private LoggerUtil() {
    }

    public static void logError(Throwable throwable) {
        LOGGER.error(throwable.getMessage(), throwable);
    }
    public static void logError(String message, Throwable throwable) {
        LOGGER.error(message, throwable);
    }

    public static void logInfo(String message) {
        LOGGER.info(message);
    }

}