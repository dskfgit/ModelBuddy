package com.thesetediousthings.modelbuddy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_launch);
    }

    public void onClickBuilds(View v) {
        Context context = v.getContext();
        Intent intent = new Intent(context, BuildListActivity.class);
        context.startActivity(intent);
    }

    public void onClickPaints(View v) {
        Context context = v.getContext();
        Intent intent = new Intent(context, PaintListActivity.class);
        context.startActivity(intent);
    }

    public void onClickRecipes(View v) {
        Context context = v.getContext();
        Intent intent = new Intent(context, RecipeListActivity.class);
        context.startActivity(intent);
    }

}
