package database.objects;

import lombok.Data;

import java.lang.reflect.Field;
import java.util.Locale;

@Data
public class BdbObj {
    private String primaryKey;

    /**
     * This function loops through the current object class and returns a description of its variables.
     *
     * @return temp : a described long string of the variables.
     */
    public String getVariables() {
        Class<?> c = this.getClass();
        StringBuilder temp = new StringBuilder();

        for (Field field : c.getDeclaredFields()) {
            try {
                temp.append(field.getType()).append(":").append(field.getName()).append("=").append(field.get(this).toString()).append(",");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return temp.toString();
    }

    public boolean validatePrimaryKey() {
        Class<?> c = this.getClass();
        for (Field field : c.getDeclaredFields()) {
            if (field.getName().toLowerCase(Locale.ROOT).equals(this.primaryKey.toLowerCase(Locale.ROOT))) {
                return true;
            }
        }
        return false;
    }

}


