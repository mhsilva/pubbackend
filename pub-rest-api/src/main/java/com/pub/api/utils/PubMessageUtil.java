package com.pub.api.utils;

import java.text.MessageFormat;

public class PubMessageUtil {
	public static String formatMessage(String message, Object... args) {
		return MessageFormat.format(message, args);
	}
}
