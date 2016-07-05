package com.uxin.udf;

import java.util.Arrays;

import com.aliyun.odps.udf.UDF;

public class SortList extends UDF {

	public String evaluate(String str, String sep) {
		if(str == null || sep == null){
			return null;
		}
		String[] arr = str.split(sep);
		Arrays.sort(arr);
		return org.apache.commons.lang.StringUtils.join(arr, sep);
	}
	
}
