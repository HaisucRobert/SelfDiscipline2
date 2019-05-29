package info.androidhive.selfdiscipline;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerItem> {

    private List<Food> allFoodToDisplay;

    public RecyclerAdapter(List<Food> allFoodToDisplay) {
        if(null == allFoodToDisplay) {
            this.allFoodToDisplay = new ArrayList<>();
        } else {
            this.allFoodToDisplay = allFoodToDisplay;
        }
    }

    @NonNull
    @Override
    public RecyclerItem onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.meal_item, viewGroup,false);
        return new RecyclerItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerItem recyclerItem, int position) {
        Food food = allFoodToDisplay.get(position);
        recyclerItem.itemKcalorii.setText(food.getKCALORII().toString());
        recyclerItem.itemName.setText(food.getNAME());
    }

    @Override
    public int getItemCount() {
        return allFoodToDisplay.size();
    }

    class RecyclerItem extends RecyclerView.ViewHolder {

        public TextView itemName, itemKcalorii;

        public RecyclerItem(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.item_nume);
            itemKcalorii = itemView.findViewById(R.id.item_kcalorii);
        }
    }
}
