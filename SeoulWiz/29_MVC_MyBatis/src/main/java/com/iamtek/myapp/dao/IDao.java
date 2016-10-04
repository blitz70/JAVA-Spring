package com.iamtek.myapp.dao;

import java.util.ArrayList;

import com.iamtek.myapp.dto.ContentDto;

public interface IDao {
	
	public ArrayList<ContentDto> list();
	public void write(String writer, String content);
	public ContentDto view(String id);
	public void delete(String id);
	
}
