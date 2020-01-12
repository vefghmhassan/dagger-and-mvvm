package com.vefgh.Componets;

import com.vefgh.projecttest.Moduls.NewsInfoModule;
import com.vefgh.projecttest.ViewModels.NewsInfoViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NewsInfoModule.class})
public interface NewsInfoComponet {
    void  inject(NewsInfoViewModel viewModel);
}
