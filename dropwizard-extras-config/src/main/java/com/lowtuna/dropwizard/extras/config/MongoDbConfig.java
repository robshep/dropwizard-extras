package com.lowtuna.dropwizard.extras.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.mongodb.DB;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = false, include = JsonTypeInfo.As.EXTERNAL_PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = MongoDbPropertiesConfig.class, name = "properties"),
        @JsonSubTypes.Type(value = MongoDbUriConfig.class, name = "url")
})

@JsonIgnoreProperties(ignoreUnknown = true, value = "type")
public abstract class MongoDbConfig {
    public abstract DB instance();
}
