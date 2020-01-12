package com.vefgh.projecttest.Moduls;

import com.vefgh.projecttest.Repository.SearchRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SearchModule {
    @Provides
    @Singleton
    SearchRepository searchRepository() {
        return new SearchRepository();
    }
}
