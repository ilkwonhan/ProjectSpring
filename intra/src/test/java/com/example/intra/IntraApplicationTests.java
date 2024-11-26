package com.example.intra;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class IntraApplicationTests {

    @Autowired
    private SqlSessionTemplate sqlSession;

    @Autowired 
	JdbcTemplate jdbcTemplate;

	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521/FREE";
	private static final String USER = "champ";
	private static final String PW = "champit00";    	

	@Test
	public void test() throws Exception {
		Class.forName(DRIVER);
		
		try (Connection con = DriverManager.getConnection(URL, USER, PW)){
			System.out.println("성공");
			System.out.println(con);
		} catch (Exception e) {
			System.out.println("에러발생");
			e.printStackTrace();
		}
	}

	@Test
	public void testCount() {

		String sTemp = jdbcTemplate.queryForObject("select 'champ' from dual", String.class);
		System.out.println(sTemp);

	}

	@Test
    public void testSqlSession() {
		String sTemp = sqlSession.toString();
        System.out.println(sTemp);
    }


}
