package database.objects.dbObjExamples;

import database.objects.OrenDBObj;

public class Person<T> extends OrenDBObj{
    public String name;
    public Integer age;
    public String car;

    public Person(String primaryKey, Object primaryKeyValue, String name, Integer age, String car) {
        super(primaryKey, primaryKeyValue);
        this.name = name;
        this.age = age;
        this.car = car;
    }

}
