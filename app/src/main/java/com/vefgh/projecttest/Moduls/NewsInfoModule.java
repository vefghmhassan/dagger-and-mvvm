package com.vefgh.projecttest.Moduls;

import com.vefgh.projecttest.Repository.NewsInfoReporitory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NewsInfoModule {
    @Provides
    @Singleton
    NewsInfoReporitory newsInfoReporitory() {
        return new NewsInfoReporitory();
    }

}
