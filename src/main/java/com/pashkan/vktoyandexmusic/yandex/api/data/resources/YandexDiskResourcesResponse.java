package com.pashkan.vktoyandexmusic.yandex.api.data.resources;

import java.util.List;

public class YandexDiskResourcesResponse {
    private List<YandexDiskResource> items;

    public List<YandexDiskResource> getItems() {
        return items;
    }

    public void setItems(List<YandexDiskResource> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "YandexDiskResourcesResponse{" +
                "items=" + items +
                '}';
    }
}
