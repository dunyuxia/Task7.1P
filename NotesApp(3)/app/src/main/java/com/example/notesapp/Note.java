package com.example.notesapp;

import java.io.Serializable;

public class Note implements Serializable
{
	private final String id;
	private String content;

	Note(String item)
	{
		String[] params = item.split("=");

		id = params[0];
		content = params[1];
	}

	public String getId()
	{
		return id;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}
}