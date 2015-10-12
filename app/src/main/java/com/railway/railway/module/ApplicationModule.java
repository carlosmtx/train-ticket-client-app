package com.railway.railway.module;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.railway.railway.RailwayApplication;
import com.railway.railway.business.api.API;
import com.railway.railway.business.api.RailwayAPI;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    @Provides @Singleton
    Context provideAppContext() {
        return RailwayApplication.getContext();
    }

    @Provides @Inject @Singleton
    RequestQueue provideRequestQueue(Context context) {
        return Volley.newRequestQueue(context);
    }

    @Provides @Inject
    API provideAPI(RequestQueue queue) {
        return new RailwayAPI(queue);
    }
    @Singleton @Provides
    ExecutorService provideThreadPool() {
        return Executors.newFixedThreadPool(10);
    }
}
