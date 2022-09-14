package com.example.finbit_android_app;

import Models.Employee;

import android.graphics.drawable.Icon;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.text.BreakIterator;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    private List<Employee> data;

    public EmployeeAdapter(List<Employee> data) {
        this.data = data;
    }

    @NonNull
    @NotNull
    @Override
    public EmployeeAdapter.EmployeeViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, parent, false);

        return new EmployeeViewHolder(inflatedView);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull @NotNull EmployeeAdapter.EmployeeViewHolder holder, int position) {
        holder.id.setText(""+data.get(position).getemployeeId());
        holder.age.setText(""+data.get(position).getEmployeeAge());
        holder.name.setText(data.get(position).getEmployeeName());
        holder.salary.setText(""+data.get(position).getEmployeeSalary());
        holder.image.setImageIcon(Icon.createWithContentUri(""+data.get(position).getProfileImage()));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class EmployeeViewHolder extends RecyclerView.ViewHolder{
        public final TextView id;
        private final TextView name;

        private final TextView salary;

        private final TextView age;
private final ImageView image;
        public EmployeeViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            id =            itemView.findViewById(R.id.id);
            name=            itemView.findViewById(R.id.name);
            salary=            itemView.findViewById(R.id.salary);
            age=            itemView.findViewById(R.id.age);
            image=  itemView.findViewById(R.id.image);
        }

    }

}
