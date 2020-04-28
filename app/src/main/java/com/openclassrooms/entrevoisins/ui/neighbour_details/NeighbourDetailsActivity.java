package com.openclassrooms.entrevoisins.ui.neighbour_details;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;

public class NeighbourDetailsActivity extends AppCompatActivity {
    @BindView(R.id.activity_neighbour_details_toolbar)
    public android.support.v7.widget.Toolbar mToolbar;
    @BindView(R.id.activity_neighbour_details_toolbar_btn)
    public ImageButton mToolbarButton;
    @BindView(R.id.activity_neighbour_details_toolbar_img)
    public ImageView mNeighbourAvatar;
    @BindView(R.id.activity_neighbour_details_toolbar_txt)
    public TextView mToolbarTextView;
    @BindView(R.id.infos_card_title_txt)
    public TextView mInfosCardTitleTextView;
    @BindView(R.id.activity_neighbour_details_fav_fab)
    public android.support.design.widget.FloatingActionButton mFavFab;
    @BindDrawable(R.drawable.ic_star_border_yellow_24dp)
    public Drawable mStarBorderWhite;
    @BindDrawable(R.drawable.ic_star_yellow_24dp)
    public Drawable mStarYellow;

    private NeighbourApiService mApiService;
    private Neighbour mNeighbour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neighbour_details);
        ButterKnife.bind(this);

        mApiService = DI.getNeighbourApiService();
        getNeighbour();
        configureToolbar();
        comfigureInfosCard();
        configureFavFab();
    }

    private void getNeighbour() {
        mNeighbour = getIntent().getParcelableExtra("Neighbour");
    }

    private void configureToolbar() {
        Glide.with(this).load(mNeighbour.getAvatarUrl()).into(mNeighbourAvatar);
        mToolbarTextView.setText(mNeighbour.getName());
        mToolbarButton.setOnClickListener(v -> finish());
    }

    private void comfigureInfosCard() {
        mInfosCardTitleTextView.setText(mNeighbour.getName());
    }

    private void configureFavFab() {
        if (mNeighbour.isFavoriteStatus() == true) {
            mFavFab.setImageDrawable(mStarYellow);
        } else {
            mFavFab.setImageDrawable(mStarBorderWhite);
        }

        mFavFab.setOnClickListener(v -> {
            mApiService.changeNeighbourFavoriteStatus(mNeighbour);
            mNeighbour.setFavoriteStatus(!mNeighbour.isFavoriteStatus());
            configureFavFab();

        });
    }
}
