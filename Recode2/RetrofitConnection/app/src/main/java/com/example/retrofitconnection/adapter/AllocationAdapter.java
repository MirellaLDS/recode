package com.example.retrofitconnection.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitconnection.R;
import com.example.retrofitconnection.model.Allocation;

import java.util.List;

public class AllocationAdapter extends RecyclerView.Adapter<AllocationAdapter.AllocationHolder>{

    private final LayoutInflater mInflater;
    private List<Allocation> allocationList;

    public AllocationAdapter(Context context, List<Allocation> allocationList) {
        this.mInflater = LayoutInflater.from(context);
        this.allocationList = allocationList;
    }

    @NonNull
    @Override
    public AllocationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.layout_alloction_item, parent, false);
        return new AllocationHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllocationHolder holder, int position) {
        Allocation allocation = allocationList.get(position);
        holder.courseName.setText(allocation.getCourse().getName());
        holder.professorName.setText(allocation.getProfessor().getName());
        holder.dayWeek.setText(allocation.getDayOfWeek());
    }

    @Override
    public int getItemCount() {
        return allocationList.size();
    }

    class AllocationHolder extends RecyclerView.ViewHolder {

        TextView professorName, courseName, dayWeek ;

        public AllocationHolder(@NonNull View itemView) {
            super(itemView);

            professorName = itemView.findViewById(R.id.tv_professor_name);
            courseName = itemView.findViewById(R.id.tv_course_name);
            dayWeek = itemView.findViewById(R.id.tv_week_day);

        }
    }

}
