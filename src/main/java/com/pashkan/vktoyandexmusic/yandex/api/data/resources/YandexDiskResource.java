package com.pashkan.vktoyandexmusic.yandex.api.data.resources;

public class YandexDiskResource {
    private String name;
    private String md5;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    @Override
    public String toString() {
        return "YandexDiskResource{" +
                "name='" + name + '\'' +
                ", md5='" + md5 + '\'' +
                '}';
    }
}
