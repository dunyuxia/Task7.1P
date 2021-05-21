package com.example.notesapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>
{
	private final ArrayList<Note> notes;
	private final AllNotesActivity activity;

	MyAdapter(ArrayList<Note> notes, AllNotesActivity activity)
	{
		this.notes = new ArrayList<>();
		this.notes.addAll(notes);
		this.activity = activity;
	}

	@Override
	public void onBindViewHolder(@NonNull MyViewHolder holder, final int position)
	{
		holder.setContent(notes.get(position).getContent());
		holder.itemView.setOnClickListener(v ->
		{
			if (activity != null)
				activity.onNote(notes.get(position));
		});
	}

	@Override
	public int getItemCount()
	{
		return notes.size();
	}

	@NonNull
	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
	{
		return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_note, parent, false));
	}
}