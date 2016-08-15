package com.pub.api.utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class PubObjectUtil {

	public static boolean isEmpty(Object object) {
		boolean empty;

		if (object instanceof String) {
			empty = StringUtils.isEmpty((String) object);
		} else if (object instanceof StringBuffer) {
			empty = ((StringBuffer) object).length() == 0;
		} else if (object instanceof StringBuilder) {
			empty = ((StringBuilder) object).length() == 0;
		} else if (object instanceof Collection && ((Collection<?>) object).isEmpty()) {
			empty = true;
		} else if (object instanceof Map && ((Map<?, ?>) object).isEmpty()) {
			empty = true;
		} else if (object != null && object.getClass().isArray() && Array.getLength(object) == 0) {
			empty = true;
		} else {
			empty = (object == null);
		}
		return empty;
	}

	public static <T> T ifNull(T obj, T objDefault) {
		if (isEmpty(obj)) {
			return objDefault;
		}
		return obj;
	}

	public static <T> List<T> getUniqueElemetsFromList(List<T> list) {
		return new ArrayList<>(new HashSet<>(list));
	}

	public static <T> List<T> listIfNull(List<T> list) {
		return isEmpty(list) ? new ArrayList<>() : list;
	}
}
