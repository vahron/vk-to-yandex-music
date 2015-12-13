package com.pashkan.vktoyandexmusic;

import com.pashkan.vktoyandexmusic.vk.api.VkApi;
import com.pashkan.vktoyandexmusic.vk.auth.VkAuthConfiguration;
import com.pashkan.vktoyandexmusic.yandex.api.YandexDiskApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mibbim on 13.12.2015.
 */
@RestController
public class RestServlet {
    @Autowired
    private VkAuthConfiguration authConfiguration;

    @Autowired
    private VkApi vkApi;

    @Autowired
    private YandexDiskApi yandexDiskApi;

    @RequestMapping("/debug")
    String action() {
        return yandexDiskApi.getUploadUrl("test.txt").toString();
    }
}
