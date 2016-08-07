package i_nterface.kdas.uitest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Interface on 04/08/16.
 */
public class RVadapter extends RecyclerView.Adapter<RVadapter.ViewHolder>{

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView cardtext;

        public ViewHolder(View itemView) {
            super(itemView);

            cardtext = (TextView)itemView.findViewById(R.id.card_text_view);
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
        ViewHolder viewHolder = new ViewHolder(rowView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RVadapter.ViewHolder holder, int position) {
        dataset data = mdata.get(position);

        TextView cardtextview = holder.cardtext;
        cardtextview.setText(data.event);

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }
}
