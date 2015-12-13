package com.pashkan.vktoyandexmusic.vk.api.data;

import java.util.List;

public class VkAudiosResponse {
    private int count;
    private List<VkAudioDescription> items;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<VkAudioDescription> getItems() {
        return items;
    }

    public void setItems(List<VkAudioDescription> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "VkAudiosResponse{" +
                "count=" + count +
                ", items=" + items +
                '}';
    }
}
