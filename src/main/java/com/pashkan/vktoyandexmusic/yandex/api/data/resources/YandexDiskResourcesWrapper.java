package com.pashkan.vktoyandexmusic.yandex.api.data.resources;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class YandexDiskResourcesWrapper {
    @SerializedName("_embedded")
    private JsonObject resource;

    public JsonObject getResource() {
        return resource;
    }

    public void setResource(JsonObject resource) {
        this.resource = resource;
    }

    @Override
    public String toString() {
        return "YandexDiskResourcesWrapper{" +
                "resource=" + resource +
                '}';
    }
}
