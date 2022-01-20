package database.objects;

import lombok.Data;

import java.lang.reflect.Field;
import java.util.Locale;

@Data
public class OrenDBObj<T> {
    private String primaryKey;
    private T primaryKeyValue;

    public OrenDBObj(String primaryKey, T primaryKeyValue) {
        this.primaryKey = primaryKey;
        this.primaryKeyValue = primaryKeyValue;
    }

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
                if (field.get(this) != null) {
                    temp.append(field.getType()).append(":").append(field.getName()).append("=").append(field.get(this).toString()).append(",");
                } else {
                    temp.append(field.getType()).append(":").append(field.getName()).append("=").append("null").append(",");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return temp.toString();
    }

    /**
     * This function loops through the current object class and returns the variables names.
     *
     * @return temp : a string of the variables.
     */
    public String getVariablesNames() {
        Class<?> c = this.getClass();
        StringBuilder temp = new StringBuilder();

        for (Field field : c.getDeclaredFields()) {
            temp.append(field.getName()).append(",");
        }
        return temp.toString();
    }

    /**
     * This function loops through the current object class and returns the variables values.
     *
     * @return temp : a string of the variables values.
     */
    public String getVariablesValues() {
        Class<?> c = this.getClass();
        StringBuilder temp = new StringBuilder();

        for (Field field : c.getDeclaredFields()) {
            try {
                if (field.get(this) != null) {
                    temp.append(field.get(this).toString()).append(",");
                } else {
                    temp.append("null").append(",");
                }
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


