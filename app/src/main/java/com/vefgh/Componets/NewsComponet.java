package com.vefgh.Componets;

import com.vefgh.projecttest.Moduls.NewsModule;
import com.vefgh.projecttest.ViewModels.NewsViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NewsModule.class})
public interface NewsComponet {
    void inject(NewsViewModel news);
}
