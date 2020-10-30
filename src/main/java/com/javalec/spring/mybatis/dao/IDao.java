package com.javalec.spring.mybatis.dao;

import java.util.ArrayList;

import com.javalec.spring.mybatis.dto.ContentDto;

public interface IDao
{
	public ArrayList<ContentDto> listDao();
	public void writeDao(String mWriter, String mContent);
	public ContentDto viewDao(String strId);
	public void deleteDao(String bId);
}
