package com.uxin.udf;

import org.apache.commons.lang.StringUtils;

import com.aliyun.odps.udf.UDF;

public class RightPad extends UDF {

	public String evaluate(String str, Long length, String paddingstr) {
		if (length == null) {
			return null;
		} else if (length == 0L) {
			return "";
		} else {
			int len = (int) ((long) length);
			return StringUtils.rightPad(str, len, paddingstr);
		}
	}

}
