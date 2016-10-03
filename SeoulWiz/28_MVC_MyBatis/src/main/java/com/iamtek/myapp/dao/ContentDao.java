package com.iamtek.myapp.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.iamtek.myapp.dto.ContentDto;

public class ContentDao {
	
	private JdbcTemplate template;
	private String sql;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public ArrayList<ContentDto> list() {
		sql = "SELECT * FROM mydb.board ORDER BY mId desc";
		return (ArrayList<ContentDto>) template.query(sql, new BeanPropertyRowMapper<ContentDto>(ContentDto.class));
	}

	public void write(final String writer, final String content) {
		sql = "INSERT INTO mydb.board (mWriter, mContent) VALUES (?, ?)";
		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, writer);
				ps.setString(2, content);
			}
		});
	}

	public void delete(final String id) {
		sql = "DELETE FROM mydb.board WHERE mId="+id;
		template.update(sql);
	}

	public ContentDto content(final String id) {
		sql = "SELECT * FROM mydb.board WHERE mId="+id;
		return template.queryForObject(sql, new BeanPropertyRowMapper<ContentDto>(ContentDto.class));
	}

}
