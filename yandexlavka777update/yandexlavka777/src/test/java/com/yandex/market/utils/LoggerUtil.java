package com.yandex.market.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtil {
    private static final Logger logger = LogManager.getLogger(LoggerUtil.class);

    public static void logInfo(String message) {
        logger.info(message);
    }

    // Добавляем метод для логирования ошибок
    public static void logError(String message) {
        logger.error(message);
    }

    // Можно также добавить метод для предупреждений
    public static void logWarning(String message) {
        logger.warn(message);
    }

}