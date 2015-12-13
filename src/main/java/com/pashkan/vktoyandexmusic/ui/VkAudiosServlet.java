package com.pashkan.vktoyandexmusic.ui;

import com.pashkan.vktoyandexmusic.vk.api.VkApi;
import com.pashkan.vktoyandexmusic.vk.api.data.VkAudiosResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VkAudiosServlet {
    @Autowired
    private VkApi vkApi;

    @RequestMapping("/getVkAudios")
    public VkAudiosResponse getVkAudios() {
        VkAudiosResponse response = new VkAudiosResponse();
        response.setItems(vkApi.getUserAudio());
        response.setCount(response.getItems().size());
        return response;
    }
}
