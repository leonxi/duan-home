package com.xiaoji.duan.aac.service.db;

public class CreateTable extends AbstractSql {

	public CreateTable() {
		initDdl();
	}

	private void initDdl() {
		ddl.add("" +
				"CREATE TABLE IF NOT EXISTS `aac_homepage` (" +
				"  `UNIONID` varchar(36) NOT NULL," +
				"  `HOME_SUBDOMAIN` varchar(64) NOT NULL," +
				"  `HOME_PREFIX` varchar(3) NOT NULL," +
				"  `HOME_PATH` varchar(512) NOT NULL," +
				"  `CREATE_TIME` date DEFAULT NULL," +
				"  PRIMARY KEY (`UNIONID`)" +
				" ) ENGINE=InnoDB DEFAULT CHARSET=utf8;" +
				"");

	}
}
