package com.railway.railway;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.railway.railway.business.api.API;
import com.railway.railway.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    Context provideAppContext();
    RequestQueue provideRequestQueue();
    API provideRequestAPI();
}
