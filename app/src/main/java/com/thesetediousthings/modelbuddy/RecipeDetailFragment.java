package com.thesetediousthings.modelbuddy;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * A fragment representing a single Recipe detail screen.
 * This fragment is either contained in a {@link RecipeListActivity}
 * in two-pane mode (on tablets) or a {@link RecipeDetailActivity}
 * on handsets.
 */
public class RecipeDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */

    private Recipe mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RecipeDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RecipeFactory recipeFactory = RecipeFactory.getInstance();

        if (getArguments().containsKey(BasicItem.ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = recipeFactory.getItems_map().get(getArguments().getString(BasicItem.ARG_ITEM_ID));
            /*
            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.getName());
            }
            */

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.recipe_detail, container, false);

        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.recipe_desc)).setText(mItem.getDesc());
            ((TextView) rootView.findViewById(R.id.recipe_volume)).setText(String.valueOf(mItem.getVolumeInMls()) + "mls");
            ((TextView) rootView.findViewById(R.id.recipe_source)).setText(mItem.getSource());
        }

        RecyclerView ingredientRecyclerView = (RecyclerView) rootView.findViewById(R.id.ingredient_list);
        assert ingredientRecyclerView != null;
        ingredientRecyclerView.setAdapter(new RecipeDetailFragment.IngredientRecyclerViewAdapter(getActivity(), mItem.getIngredients()));

        RecyclerView commentRecyclerView = (RecyclerView) rootView.findViewById(R.id.comment_list);
        assert commentRecyclerView != null;
        commentRecyclerView.setAdapter(new CommentRecyclerViewAdapter(getActivity(), mItem.getComments()));

        //recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //recyclerView.setItemAnimator(new DefaultItemAnimator());

        return rootView;
    }

    public static class IngredientRecyclerViewAdapter
            extends RecyclerView.Adapter<RecipeDetailFragment.IngredientRecyclerViewAdapter.ViewHolder> {

        private final Activity mParentActivity;
        private final List<Ingredient> mValues;

        IngredientRecyclerViewAdapter(Activity parent,
                                      List<Ingredient> items) {
            mValues = items;
            mParentActivity = parent;
            //mTwoPane = twoPane;
        }

        @Override
        public RecipeDetailFragment.IngredientRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.ingredient_list_content, parent, false);
            return new RecipeDetailFragment.IngredientRecyclerViewAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final RecipeDetailFragment.IngredientRecyclerViewAdapter.ViewHolder holder, int position) {

            Ingredient anIngredient = mValues.get(position);
            String part = Integer.toString(anIngredient.getPart());
            holder.mPartView.setText(part);
            holder.mDescView.setText(anIngredient.getPaint().getDesc());
            holder.mPaintView.setText(anIngredient.getPaint().getCode());

            //holder.itemView.setTag(mValues.get(position));
            //holder.itemView.setOnClickListener(mOnClickListener);
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            final TextView mPartView;
            final TextView mDescView;
            final TextView mPaintView;

            ViewHolder(View view) {
                super(view);
                mPartView = (TextView) view.findViewById(R.id.ingredient_part);
                mDescView = (TextView) view.findViewById(R.id.ingredient_desc);
                mPaintView = (TextView) view.findViewById(R.id.ingredient_paint);
            }
        }
    }

}
