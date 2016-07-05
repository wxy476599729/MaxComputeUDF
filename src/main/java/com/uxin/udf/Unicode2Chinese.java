package com.uxin.udf;

import com.aliyun.odps.udf.UDF;

public class Unicode2Chinese extends UDF {

	public String evaluate(String utfString) {
		if (utfString == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		int i = -1;
		int pos = 0;
		while ((i = utfString.indexOf("\\u", pos)) != -1) {
			sb.append(utfString.substring(pos, i));
			if (i + 5 < utfString.length()) {
				pos = i + 6;
				sb.append((char) Integer.parseInt(utfString.substring(i + 2, i + 6), 16));
			}
		}
		return sb.toString();
	}

}
