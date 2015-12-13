package com.pashkan.vktoyandexmusic.ui;

import com.pashkan.vktoyandexmusic.yandex.api.YandexDiskApi;
import com.pashkan.vktoyandexmusic.yandex.api.data.resources.YandexDiskResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class YandexDiskServlet {
    @Autowired
    private YandexDiskApi yandexDiskApi;

    @RequestMapping("/getYandexDiskResources")
    public List<YandexDiskResource> getYandexDiskResources() {
        return yandexDiskApi.getResources();
    }
}
