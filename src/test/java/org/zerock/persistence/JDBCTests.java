package org.zerock.persistence;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;


@Log4j
public class JDBCTests {
	
	static {
		try{Class.forName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	@Test
	public void testConnection() {
			String url = "jdbc:log4jdbc:oracle:thin:@db202102021120_high?TNS_ADMIN=/home/opc/wallet/teamwallet";
			String user = "admin";
			String password = "Fivefivefive5";
		
		try(
				Connection con =
					DriverManager.getConnection(url,user,password);
				){
			assertNotNull(con);
		}catch(Exception e) {
			fail(e.getMessage());
			log.info(e);
		}
		
		
	}

}
