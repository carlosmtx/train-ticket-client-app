package com.railway.railway.module;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.railway.railway.RailwayApplication;
import com.railway.railway.business.api.API;
import com.railway.railway.business.api.RailwayAPI;

import java.net.CookieHandler;
import java.net.CookieManager;

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
        CookieManager manager = new CookieManager();
        CookieHandler.setDefault(manager);
        return Volley.newRequestQueue(context);
    }

    @Provides @Singleton @Inject
    API provideAPI(RequestQueue queue) {
        return new RailwayAPI(queue);
    }

}
