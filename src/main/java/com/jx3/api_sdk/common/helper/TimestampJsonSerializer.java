package com.jx3.api_sdk.common.helper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.jx3.api_sdk.common.JacksonDateFormat;

import java.io.IOException;
import java.sql.Timestamp;

public class TimestampJsonSerializer extends JsonSerializer<Timestamp> {

    public static final JacksonDateFormat DATE_FORMAT = new JacksonDateFormat(TimestampJsonDeserializer.DATE_PATTERN);

    @Override
    public void serialize(Timestamp date, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeString(date != null ? DATE_FORMAT.format(date) : "null");
    }
}