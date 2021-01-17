package com.codingtask.datasnapshot.parser;

import com.codingtask.datasnapshot.entity.ReconData;
import com.codingtask.datasnapshot.exception.LineParseException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Logger;

public class ReconDataParser {
    private static final Logger logger = Logger.getLogger(ReconDataParser.class.getName());

    public static ReconData parse(String line) throws ParseException {
        if(!line.trim().isEmpty()) {
            String[] metadata = line.split(",");
            if(metadata.length==4) {
                String id = metadata[0];
                String name = metadata[1];
                String description = metadata[2];
                Calendar timestamp = Calendar.getInstance();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
                timestamp.setTime(dateFormat.parse(metadata[3]));
                return new ReconData(id, name, description, timestamp);
            }else{
                throw new LineParseException("Line can not be parsed");
            }
        }else{
            throw new LineParseException("Empty Line");
        }
    }
}
