package com.edopater.app_reforaccion_reto_1;

import android.content.Context;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TextAdapter extends RecyclerView.Adapter<TextAdapter.TextViewHolder> {

    private List<SpannableString> textList;
    private LayoutInflater inflater;

    public TextAdapter(Context context, List<SpannableString> textList) {
        this.textList = textList;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public TextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_text, parent, false);
        return new TextViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TextViewHolder holder, int position) {
        SpannableString text = textList.get(position);
        holder.textView.setText(text);
    }

    @Override
    public int getItemCount() {
        return textList.size();
    }

    static class TextViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public TextViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textViewItem);
        }
    }
}
