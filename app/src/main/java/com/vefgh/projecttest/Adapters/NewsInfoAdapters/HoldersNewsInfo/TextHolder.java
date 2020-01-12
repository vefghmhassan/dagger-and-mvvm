package com.vefgh.projecttest.Adapters.NewsInfoAdapters.HoldersNewsInfo;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.vefgh.projecttest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TextHolder extends BaseHolder {
    @BindView(R.id.text)
    public TextView text;

    public TextHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);

    }
}
