package com.javalec.spring.mybatis.dto;

public class ContentDto
{
	private int mId;
	private String mWriter;
	private String mContent;
	
	public ContentDto()
	{
	}

	public ContentDto(int mId, String mWriter, String mContent)
	{
		this.mId = mId;
		this.mWriter = mWriter;
		this.mContent = mContent;
	}

	public int getmId()
	{
		return mId;
	}

	public void setmId(int mId)
	{
		this.mId = mId;
	}

	public String getmWriter()
	{
		return mWriter;
	}

	public void setmWriter(String mWriter)
	{
		this.mWriter = mWriter;
	}

	public String getmContent()
	{
		return mContent;
	}

	public void setmContent(String mContent)
	{
		this.mContent = mContent;
	}

	@Override
	public String toString()
	{
		return "클래스명 : [ContentDto], 필드[mId : " + mId + ", mWriter : " + mWriter + ", mContent : " + mContent + "]";
	}

}
