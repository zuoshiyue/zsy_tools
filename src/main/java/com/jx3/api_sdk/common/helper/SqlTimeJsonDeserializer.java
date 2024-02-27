package com.jx3.api_sdk.common.helper;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.jx3.api_sdk.common.JacksonDateFormat;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;

public class SqlTimeJsonDeserializer extends JsonDeserializer<Time> {

    public static final String DATE_PATTERN = JacksonDateFormat.PATTERN_HHMMSS;

    @Override
    public Time deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        String date = jp.getText();
        if (date != null && !date.isEmpty()) {
            try {
                java.util.Date utilDate = JacksonDateFormat.parseDateStrictly(date, DATE_PATTERN);
                return new Time(utilDate.getTime());
            }
            catch (ParseException e) {
                throw new JsonParseException(jp, "cannot parse date string: " + date, jp.getCurrentLocation(), e);
            }
        }
        return null;
    }
}
