package com.vefgh.projecttest.Moduls;

import com.vefgh.projecttest.Repository.NewsRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
@Module
public class NewsModule {
    @Provides
    @Singleton
    NewsRepository newsRepository() {
        return new NewsRepository();
    }
}
