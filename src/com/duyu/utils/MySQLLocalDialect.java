package com.duyu.utils;

import org.hibernate.Hibernate;
import org.hibernate.dialect.MySQL5Dialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;

public class MySQLLocalDialect extends MySQL5Dialect {
	// 扩展汉字拼音排序
	public MySQLLocalDialect() {
		super();
		registerFunction("convert_gbk", new SQLFunctionTemplate(
				Hibernate.STRING, "convert(?1 using gbk)"));
	}
}
