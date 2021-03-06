package com.example.classplus.RecyclerviewController;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.classplus.R;


public class SubjectItemViewHolder extends RecyclerView.ViewHolder {

    protected TextView name;
    protected TextView totalStudentCount;
    protected Button timetable;
    protected Button chatManager;

    public SubjectItemViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.tv_subjectitem_name);
        totalStudentCount = itemView.findViewById(R.id.tv_subjectitem_totalcount);
        timetable = itemView.findViewById(R.id.bnt_subjectitem_timetable);
        chatManager = itemView.findViewById(R.id.bnt_subjectitem_teamchat);

    }
}
