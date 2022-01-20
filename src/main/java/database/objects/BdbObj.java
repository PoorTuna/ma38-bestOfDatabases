package database.objects;

import database.tables.Table;
import lombok.Data;

import java.lang.reflect.Field;
import java.util.Arrays;

@Data
public class BdbObj {

    private String xd = "monkey";

    public String getXd() {
        return xd;
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
                temp.append(field.getType()).append(":").append(field.getName()).append("=").append(field.get(this).toString()).append(",");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return temp.toString();
    }

    public static void main(String[] args) {
        BdbObj bdbObj = new BdbObj();
        System.out.println(bdbObj.getVariables());

    }

}


