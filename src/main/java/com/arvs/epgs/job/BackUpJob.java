package com.arvs.epgs.job;

import java.io.IOException;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.arvs.epgs.util.DatabaseUtil;

public class BackUpJob extends QuartzJobBean {
	 private static final Logger logger = LoggerFactory.getLogger(BackUpJob.class);
	@Autowired
	private DatabaseUtil databaseUtil;

	@Override
	protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		// TODO Auto-generated method stub
		logger.info("Executing Job with key {}", jobExecutionContext.getJobDetail().getKey());
		//String filenameBackup = "Backup"+(new java.util.Date()).toString()+".sql";
		JobDataMap jobDataMap = jobExecutionContext.getMergedJobDataMap();
		String filename = jobDataMap.getString("filename");
		try {
			String s =(databaseUtil.backup("epgs", "epgs", "epgs", "backup_sql\\filename.sql")==true)?"True":"False";
			System.out.println("out:"+s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
