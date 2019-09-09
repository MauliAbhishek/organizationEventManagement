package com.organization.management.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.organization.management.controller.ResourcesController;

public class CommonUtil {
	 private static final Logger logger = LoggerFactory.getLogger(CommonUtil.class);

	public static Timestamp convertDate(String stringDate) {
		logger.info("Source Start Date =" + stringDate);
		Date parsedTimeStamp = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			parsedTimeStamp = dateFormat.parse(stringDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		logger.info("Post formated Start Date =" + parsedTimeStamp.getTime());
		return new Timestamp(parsedTimeStamp.getTime());

	}
	
	public static java.sql.Date convertUtilToSql(java.util.Date uDate) {
		java.sql.Date sDate = new java.sql.Date(uDate.getTime());
		return sDate;
	}

}
