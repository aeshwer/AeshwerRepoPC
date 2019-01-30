package com.trading.commons.persistence.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.hibernate.dialect.H2Dialect;
import org.hibernate.dialect.MySQL5Dialect;
import org.hibernate.dialect.MySQLDialect;
import org.hibernate.dialect.Oracle10gDialect;
import org.hibernate.dialect.SQLServerDialect;

import com.google.inject.Inject;

public class DatabaseConfigUtil {
	
	@Inject
	public DatabaseConfigUtil() {
	}

	  private static final Map<String, String> DB_TYPE_TO_DIALECT_MAPPING = new HashMap<>();

	  private static final Map<String, String> DB_TYPE_TO_DRIVER_MAPPING = new HashMap<>();

	  private static final Map<String, String> DB_TYPE_TO_URL_MAPPING = new HashMap<>();

	  public static final String DB_ORACLE = "oracle";

	  public static final String DB_ORACLE_12C = "oracle12c";

	  public static final String DB_SQLSERVER = "sqlserver";

	  public static final String DB_H2 = "h2";
	  
	  public static final String DB_MYSQL = "mysql";

	  public static final String ENCRYPTION_KEY = "MKV2015";

	  static {
	    DB_TYPE_TO_DIALECT_MAPPING.put(DB_ORACLE, Oracle10gDialect.class.getName());
	    DB_TYPE_TO_DIALECT_MAPPING.put(DB_ORACLE_12C, Oracle10gDialect.class.getName());
	    DB_TYPE_TO_DIALECT_MAPPING.put(DB_SQLSERVER, SQLServerDialect.class.getName());
	    DB_TYPE_TO_DIALECT_MAPPING.put(DB_H2, H2Dialect.class.getName());
	    DB_TYPE_TO_DIALECT_MAPPING.put(DB_MYSQL, MySQL5Dialect.class.getName());

	    DB_TYPE_TO_DRIVER_MAPPING.put(DB_ORACLE, "oracle.jdbc.driver.OracleDriver");
	    DB_TYPE_TO_DRIVER_MAPPING.put(DB_ORACLE_12C, "oracle.jdbc.driver.OracleDriver");
	    DB_TYPE_TO_DRIVER_MAPPING.put(DB_SQLSERVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    DB_TYPE_TO_DRIVER_MAPPING.put(DB_H2, "org.h2.Driver");
	    DB_TYPE_TO_DRIVER_MAPPING.put(DB_MYSQL, "com.mysql.jdbc.Driver");

	    DB_TYPE_TO_URL_MAPPING.put(DB_ORACLE, "jdbc:oracle:thin:@##host##:##port##:##servicename##");
	    DB_TYPE_TO_URL_MAPPING.put(
	        DB_ORACLE_12C, "jdbc:oracle:thin:@//##host##:##port##/##servicename##");
	    DB_TYPE_TO_URL_MAPPING.put(DB_SQLSERVER, "jdbc:sqlserver://##host####instancename##:##port##");
	    DB_TYPE_TO_URL_MAPPING.put(DB_H2, "jdbc:h2:mem:test");
	    DB_TYPE_TO_URL_MAPPING.put(DB_MYSQL, "jdbc:mysql://##host##:##port##/##servicename##");
	  }

	  public String getDialect(final String type) {
	    return Optional.ofNullable(type)
	        .map(t -> DB_TYPE_TO_DIALECT_MAPPING.get(t.toLowerCase()))
	        .orElse(null);
	  }

	  public String getDriver(final String type) {
	    return Optional.ofNullable(type)
	        .map(t -> DB_TYPE_TO_DRIVER_MAPPING.get(t.toLowerCase()))
	        .orElse(null);
	  }

	  public String getDatabaseUrl(
	      final String type,
	      final String host,
	      final String port,
	      final String serviceName,
	      final String instanceName) {
		  
		  System.out.println(type+ host+port+serviceName+instanceName);
	    return Optional.ofNullable(type)
	        .map(
	            t ->
	                DB_TYPE_TO_URL_MAPPING
	                    .get(t.toLowerCase())
	                    .replace("##host##", Optional.ofNullable(host).orElse(""))
	                    .replace("##port##", Optional.ofNullable(port).orElse(""))
	                    .replace("##servicename##", Optional.ofNullable(serviceName).orElse(""))
	                    .replace(
	                        "##instancename##", "\\" + Optional.ofNullable(instanceName).orElse("")))
	        .orElseThrow(
	            () ->
	                new RuntimeException("Invalid DB Type provided in configuration : " + type));
	  }
}
