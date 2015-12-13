package com.pashkan.vktoyandexmusic.yandex.api;

import com.google.gson.Gson;
import com.pashkan.vktoyandexmusic.yandex.api.data.resources.YandexDiskResource;
import com.pashkan.vktoyandexmusic.yandex.api.data.resources.YandexDiskResourcesResponse;
import com.pashkan.vktoyandexmusic.yandex.api.data.resources.YandexDiskResourcesWrapper;
import com.pashkan.vktoyandexmusic.yandex.api.data.resources.upload.YandexDiskUploadUrlResponse;
import com.pashkan.vktoyandexmusic.yandex.auth.YandexAuthConfiguration;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class YandexDiskApi {
    private String YANDEX_DISK_API_URL = "https://cloud-api.yandex.net/v1/disk/";
    private String APPLICATION_FOLDER_PATH = "app:/";
    private final Gson gson = new Gson();

    @Autowired
    YandexAuthConfiguration authConfiguration;

    public Optional<String> getUploadUrl(String filename) {
        Optional<String> urlRaw = rawCall("resources/upload");
        if (urlRaw.isPresent()) {
            YandexDiskUploadUrlResponse urlResponse = gson.fromJson(urlRaw.get(), YandexDiskUploadUrlResponse.class);
            return Optional.of(urlResponse.getUrl());
        }
        return Optional.empty();
    }

    public List<YandexDiskResource> getResources() {
        Optional<String> resourcesRaw = getResourcesRaw();
        if (resourcesRaw.isPresent()) {
            YandexDiskResourcesWrapper wrapper = gson.fromJson(resourcesRaw.get(), YandexDiskResourcesWrapper.class);
            YandexDiskResourcesResponse resources = gson.fromJson(wrapper.getResource(), YandexDiskResourcesResponse.class);
            return resources.getItems();
        }
        return new LinkedList<>();
    }

    private Optional<String> getResourcesRaw() {
        return getResourcesRaw(APPLICATION_FOLDER_PATH);
    }

    private Optional<String> getResourcesRaw(String path) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("path", path);
        return rawCall("resources", parameters);
    }

    private Optional<String> rawCall(String methodPath) {
        return rawCall(methodPath, new HashMap<>());
    }

    private Optional<String> rawCall(String methodPath, Map<String, String> parameters) {
        try {
            URIBuilder builder = new URIBuilder(YANDEX_DISK_API_URL + methodPath);
            parameters.entrySet().stream().forEach(entry -> builder.addParameter(entry.getKey(), entry.getValue()));
            return Optional.of(Request.Get(builder.build())
                    .connectTimeout(60_000)
                    .socketTimeout(60_000)
                    .addHeader("Authorization", "OAuth " + authConfiguration.getAccessToken())
                    .execute().returnContent().asString());
        } catch (Throwable t) {
            return Optional.empty();
        }
    }
}
