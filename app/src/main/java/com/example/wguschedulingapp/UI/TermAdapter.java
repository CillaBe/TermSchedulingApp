package com.example.wguschedulingapp.UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wguschedulingapp.Entity.Term;
import com.example.wguschedulingapp.R;

import java.util.List;

public class TermAdapter extends RecyclerView.Adapter<TermAdapter.TermViewHolder> {
    class TermViewHolder extends RecyclerView.ViewHolder{
        private final TextView termItemView;
        private final TextView termStartView;
        private final TextView termEndView;
        private TermViewHolder(View itemView){
            super (itemView);
            termItemView = itemView.findViewById(R.id.textView2);
            termStartView = itemView.findViewById(R.id.TermStart);
            termEndView = itemView.findViewById(R.id.TermEnd);
            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    final Term current= mTerms.get(position);
                    Intent intent = new Intent(context,ViewTerm.class);
                    intent.putExtra("id",current.getTermID());
                    intent.putExtra("name",current.getTermName());
                    intent.putExtra("start",current.getTermStart());
                    intent.putExtra("end",current.getTermEnd());
                    context.startActivity(intent);


                }
            });
        }
    }
    private List<Term> mTerms;
    private final Context context;
    private final LayoutInflater mInflater;
    public TermAdapter(Context context){
        mInflater = LayoutInflater.from(context);
        this.context =context;
    }
    @NonNull
    @Override
    public TermAdapter.TermViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView=mInflater.inflate(R.layout.term_list_item,parent,false);
        return new TermViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TermAdapter.TermViewHolder holder, int position) {
        if(mTerms!=null){
            Term current=mTerms.get(position);
            String name=current.getTermName();
            String start = current.getTermStart();
            String end = current.getTermEnd();
            holder.termItemView.setText(name);
            holder.termEndView.setText(end);
            holder.termStartView.setText(start);
        }
        else{
            holder.termItemView.setText("No term name");
        }

    }
    public void setTerms (List<Term> terms){
        mTerms = terms;
        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        if (mTerms != null) {
            return mTerms.size();
        }
        else{
            return 0;
        }
    }
}
