package reflection.advancedlevel.jsonrepresentation;

import java.lang.reflect.Field;

public class JsonConverter {
    public static String toJson(Object obj) {
        if (obj == null) {
            return "null";
        }

        StringBuilder json = new StringBuilder("{");
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true); // Allow access to private fields
            try {
                String fieldName = fields[i].getName();
                Object fieldValue = fields[i].get(obj);

                json.append("\"").append(fieldName).append("\": ");

                if (fieldValue instanceof String) {
                    json.append("\"").append(fieldValue).append("\"");
                } else {
                    json.append(fieldValue);
                }

                if (i < fields.length - 1) {
                    json.append(", ");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        json.append("}");
        return json.toString();
    }
}

