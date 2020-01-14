package com.thesetediousthings.modelbuddy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * An activity representing a single Recipe detail screen. This
 * activity is only used on narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link RecipeListActivity}.
 */
public class RecipeDetailActivity extends AppCompatActivity {

    private int recipeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        Recipe aRecipe = Recipes.ITEM_MAP.get(getIntent().getStringExtra(BasicItem.ARG_ITEM_ID));
        recipeId = aRecipe.getItemId();

        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        toolbar.setTitle(aRecipe.getName());
        setSupportActionBar(toolbar);

        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own detail action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
         */

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //

        /*
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(BasicItem.ARG_ITEM_ID,
                    getIntent().getStringExtra(RecipeDetailFragment.ARG_ITEM_ID));
            RecipeDetailFragment fragment = new RecipeDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.recipe_detail_container, fragment)
                    .commit();
        }
         */

        //getSupportFragmentManager().get

        View recyclerView = findViewById(R.id.ingredient_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            navigateUpTo(new Intent(this, RecipeListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        //Which ingredients belong to this recipe?
        recyclerView.setAdapter(new RecipeDetailActivity.SimpleItemRecyclerViewAdapter(this, Ingredients.getIngredientsByRecipe(recipeId)));
    }

    public static class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<RecipeDetailActivity.SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final RecipeDetailActivity mParentActivity;
        private final List<Ingredient> mValues;

        SimpleItemRecyclerViewAdapter(RecipeDetailActivity parent,
                                      List<Ingredient> items) {
            mValues = items;
            mParentActivity = parent;
            //mTwoPane = twoPane;
        }

        @Override
        public RecipeDetailActivity.SimpleItemRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.ingredient_list_content, parent, false);
            return new RecipeDetailActivity.SimpleItemRecyclerViewAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final RecipeDetailActivity.SimpleItemRecyclerViewAdapter.ViewHolder holder, int position) {

            String part = Integer.toString(mValues.get(position).getPart());

            holder.mPartView.setText(part);
            holder.mPaintView.setText(mValues.get(position).getPaint().getCode());

            //holder.itemView.setTag(mValues.get(position));
            //holder.itemView.setOnClickListener(mOnClickListener);
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            final TextView mPartView;
            final TextView mPaintView;

            ViewHolder(View view) {
                super(view);
                mPartView = (TextView) view.findViewById(R.id.ingredient_part);
                mPaintView = (TextView) view.findViewById(R.id.ingredient_paint);
            }
        }
    }


}
