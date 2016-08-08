package i_nterface.kdas.uitest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Interface on 04/08/16.
 */
public class RVadapter extends RecyclerView.Adapter<RVadapter.ViewHolder>{



    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView cardtext;
        public TextView adapterdate;
        private Context context;

        public ViewHolder(Context context, View itemView) {
            super(itemView);

            this.cardtext = (TextView)itemView.findViewById(R.id.card_text_view);
            this.adapterdate = (TextView)itemView.findViewById(R.id.textView);
            this.context = context;
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            int pos = getLayoutPosition();
            Toast.makeText(context, "" + cardtext.getText() + pos + "", Toast.LENGTH_SHORT).show();

            if (pos == 0) {
                Intent i = new Intent(context, Main2Activity.class);
                context.startActivity(i);
            }

        }
    }



        private List<dataset> mdata;
        private Context mcontext;

        public RVadapter(Context context, List<dataset> mdataset){
            mdata = mdataset;
            mcontext = context;
        }

        private Context getContext(){
            return mcontext;
        }


    @Override
    public RVadapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View rowView = inflater.inflate(R.layout.rrow, parent,false);
        ViewHolder viewHolder = new ViewHolder(getContext(), rowView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RVadapter.ViewHolder holder, int position) {
        dataset data = mdata.get(position);

        TextView cardtextview = holder.cardtext;
        cardtextview.setText(data.event);
        //TextView mdate = holder.adapterdate;
        holder.adapterdate.setText(data.date);

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }
}
