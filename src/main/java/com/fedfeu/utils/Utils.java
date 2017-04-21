package com.fedfeu.utils;

import java.util.ArrayList;

public class Utils {
	public static <E> ArrayList<E> makeList(Iterable<E> iter) {
		ArrayList<E> list = new ArrayList<E>();
	    for (E item : iter) {
	        list.add(item);
	    }
	    return list;
	}
}
