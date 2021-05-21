package com.example.notesapp;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

class MyViewHolder extends RecyclerView.ViewHolder
{
	private final TextView content;

	MyViewHolder(View v)
	{
		super(v);
		content = v.findViewById(R.id.note);
	}

	void setContent(String content)
	{
		this.content.setText(content);
	}
}