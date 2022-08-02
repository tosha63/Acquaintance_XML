package ru.shtanko.xml.entity;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Article {
    @XmlAttribute(name = "id_art")
    private String id_art;

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "code")
    private String code;

    @XmlAttribute(name = "username")
    private String username;

    @XmlAttribute(name = "guid")
    private String guid;

    public Article() {
    }

    public Article(String id_art, String name, String code, String username, String guid) {
        this.id_art = id_art;
        this.name = name;
        this.code = code;
        this.username = username;
        this.guid = guid;
    }

    public String getId_art() {
        return id_art;
    }

    public void setId_art(String id_art) {
        this.id_art = id_art;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }
}
