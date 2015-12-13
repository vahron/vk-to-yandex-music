package com.pashkan.vktoyandexmusic.vk.api.data;

import com.google.gson.JsonObject;

public class VkResponseWrapper {
    private JsonObject response;

    public JsonObject getResponse() {
        return response;
    }

    public void setResponse(JsonObject response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "VkResponseWrapper{" +
                "response=" + response +
                '}';
    }
}
