package com.pashkan.vktoyandexmusic.yandex.api.data.resources.upload;

import com.google.gson.annotations.SerializedName;

public class YandexDiskUploadUrlResponse {
    @SerializedName("href")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "YandexDiskUploadUrlResponse{" +
                "url='" + url + '\'' +
                '}';
    }
}
