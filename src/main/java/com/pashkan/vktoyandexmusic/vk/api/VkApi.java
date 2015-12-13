package com.pashkan.vktoyandexmusic.vk.api;

import com.google.gson.Gson;
import com.pashkan.vktoyandexmusic.vk.api.data.VkAudioDescription;
import com.pashkan.vktoyandexmusic.vk.api.data.VkAudiosResponse;
import com.pashkan.vktoyandexmusic.vk.api.data.VkResponseWrapper;
import com.pashkan.vktoyandexmusic.vk.auth.VkAuthConfiguration;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class VkApi {
    private final String VK_API_URL = "https://api.vk.com/method/";
    private final Gson gson = new Gson();

    @Autowired
    VkAuthConfiguration authConfiguration;

    public List<VkAudioDescription> getUserAudio() {
        Optional<String> rawResponse = rawAudioGet(authConfiguration.getUserId(), 0, 0);
        if (rawResponse.isPresent()) {
            VkResponseWrapper response = gson.fromJson(rawResponse.get(), VkResponseWrapper.class);
            VkAudiosResponse audiosResponse = gson.fromJson(response.getResponse(), VkAudiosResponse.class);
            if (audiosResponse.getItems() != null) {
                return audiosResponse.getItems();
            }
        }
        return new LinkedList<>();
    }

    private Optional<String> rawAudioGet(String owner, int offset, int count) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("owner_id", owner);
        parameters.put("offset", Integer.toString(offset));
        parameters.put("count", Integer.toString(count));
        parameters.put("need_user", "0");
        parameters.put("v", "5.40");
        return rawCall("audio.get", parameters);
    }

    private Optional<String> rawCall(String methodName, Map<String, String> parameters) {
        try {
            URIBuilder builder = new URIBuilder(VK_API_URL + methodName);
            parameters.entrySet().stream().forEach(entry -> builder.addParameter(entry.getKey(), entry.getValue()));
            builder.addParameter("access_token", authConfiguration.getAccessToken());
            return Optional.of(Request.Get(builder.build())
                    .connectTimeout(60_000)
                    .socketTimeout(60_000)
                    .execute().returnContent().asString());
        } catch (Throwable t) {
            return Optional.empty();
        }
    }
}
