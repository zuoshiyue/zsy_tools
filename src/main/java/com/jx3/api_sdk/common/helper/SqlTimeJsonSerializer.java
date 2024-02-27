package com.jx3.api_sdk.common.helper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.jx3.api_sdk.common.JacksonDateFormat;

import java.io.IOException;
import java.sql.Time;

public class SqlTimeJsonSerializer extends JsonSerializer<Time> {

    public static final JacksonDateFormat DATE_FORMAT = new JacksonDateFormat(SqlTimeJsonDeserializer.DATE_PATTERN);

    @Override
    public void serialize(Time date, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeString(date != null ? DATE_FORMAT.format(date) : "null");
    }
}
