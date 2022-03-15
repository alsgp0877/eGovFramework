package egoveframework.sample.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import egoveframework.sample.vo.SampleVO;

public class SampleRowMapper implements RowMapper<SampleVO>{
	
	public SampleVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		SampleVO vo1 = new SampleVO();
		vo1.setId(rs.getString("ID"));
		vo1.setTitle(rs.getString("TITLE"));
		vo1.setRegUser(rs.getString("REG_USER"));
		vo1.setContent(rs.getString("CONTENT"));
		vo1.setRegDate(rs.getDate("REG_DATE"));
		return vo1;
		
	}

}
