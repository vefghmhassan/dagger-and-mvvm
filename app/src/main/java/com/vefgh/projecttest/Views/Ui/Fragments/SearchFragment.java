package com.vefgh.projecttest.Views.Ui.Fragments;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vefgh.projecttest.Adapters.NewsInfoAdapters.AdapterSearch;
import com.vefgh.projecttest.Models.Search;
import com.vefgh.projecttest.R;
import com.vefgh.projecttest.ViewModels.SearchViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {


    @BindView(R.id.input_search)
    EditText inputSearch;
    @BindView(R.id.recycle_search)
    RecyclerView recycleSearch;
    SearchViewModel searchViewModel;
    List<Search.ResultBean> listSearch = new ArrayList<>();
    AdapterSearch adapterSearch;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        searchViewModel = ViewModelProviders.of(this).get(SearchViewModel.class);
        recycleSearch.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterSearch = new AdapterSearch(listSearch);
        recycleSearch.setAdapter(adapterSearch);
        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                listSearch.clear();
                searchProduct(String.valueOf(s));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void searchProduct(String search) {

        searchViewModel.getsearch(search).observe(this, new Observer<Search>() {
            @Override
            public void onChanged(Search search) {
                listSearch.addAll(search.getResult());
                adapterSearch.notifyDataSetChanged();
            }
        });
    }
}
