package com.library_base.http;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.DateTypeAdapter;

import java.util.Date;

/**
 * Created by Administrator on 2019/5/22 0022.
 */

public class JsonConvertor {
    private static Gson gson = null;

    private JsonConvertor() {
    }

    public static Gson getInstance() {
        if (gson == null) {
            gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .registerTypeAdapter(Date.class, new DateTypeAdapter())
                    .create();
        }
        return gson;
    }
}

