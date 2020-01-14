package com.thesetediousthings.modelbuddy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
//import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PaintListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        */
        //To be able to init Paints
        View recyclerView = findViewById(R.id.paint_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "New Item", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. Use NavUtils to allow users
            // to navigate up one level in the application structure. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new PaintListActivity.SimpleItemRecyclerViewAdapter(this, Paints.ITEMS));
    }

    public static class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<PaintListActivity.SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final PaintListActivity mParentActivity;
        private final List<Paint> mValues;

        private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Paint item = (Paint) view.getTag();

                    Context context = view.getContext();
                    Intent intent = new Intent(context, PaintDetailActivity.class);
                    intent.putExtra(BasicItem.ARG_ITEM_ID, item.getItemIdStr());

                    context.startActivity(intent);
                }
        };

        SimpleItemRecyclerViewAdapter(PaintListActivity parent, List<Paint> items) {
            mValues = items;
            mParentActivity = parent;
        }

        @Override
        public PaintListActivity.SimpleItemRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.paint_list_content, parent, false);
            return new PaintListActivity.SimpleItemRecyclerViewAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final PaintListActivity.SimpleItemRecyclerViewAdapter.ViewHolder holder, int position) {
            String code = mValues.get(position).getCode();
            holder.mCodeView.setText(code);
            holder.mNameView.setText(mValues.get(position).getName());
            int remain = mValues.get(position).getRemaining();
            holder.mRemainingView.setText(remain + "%");
            //holder.mRemainingView.setTextColor();
            holder.mQtyView.setText(mValues.get(position).getQty() + "");
            boolean ntb = mValues.get(position).isNeedToBuy();
            if (ntb) {
                holder.mNeedToBuyView.setText("Y");
            }
            else {
                holder.mNeedToBuyView.setText("N");
            }

            PaintFactory paintFactory = PaintFactory.getInstance();
            VendorPaint reference = paintFactory.getVendorPaintByKey(VendorPaint.CODE, code);

            //holder.mPaintImageView.setImageResource(mParentActivity.getResources().getIdentifier("a123.jpg", "mipmap", mParentActivity.getPackageName()));

            DownloadImageTask dit = new DownloadImageTask(holder.mPaintImageView);
            String url = reference.generateImageUrl(VendorPaint.SKU);
            dit.execute(url);

            holder.itemView.setTag(mValues.get(position));
            holder.itemView.setOnClickListener(mOnClickListener);
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            final TextView mCodeView;
            final TextView mNameView;
            final TextView mRemainingView;
            final TextView mQtyView;
            final TextView mNeedToBuyView;
            final ImageView mPaintImageView;

            ViewHolder(View view) {
                super(view);
                mCodeView = (TextView) view.findViewById(R.id.code);
                mNameView = (TextView) view.findViewById(R.id.name);
                mRemainingView = (TextView) view.findViewById(R.id.remaining);
                mQtyView = (TextView) view.findViewById(R.id.qty);
                mNeedToBuyView = (TextView) view.findViewById(R.id.needToBuy);
                mPaintImageView = view.findViewById(R.id.paint_image);
            }
        }
    }
}