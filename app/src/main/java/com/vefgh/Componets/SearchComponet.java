package com.vefgh.Componets;


import com.vefgh.projecttest.Moduls.SearchModule;
import com.vefgh.projecttest.ViewModels.SearchViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {SearchModule.class})
public interface SearchComponet {
    void inject(SearchViewModel searchViewModel);
}
