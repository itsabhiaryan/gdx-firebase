package com.ng.gdxfirebase.database;

import java.util.Map;

/**
 * Created by Personal on 10/17/2016.
 */

public interface DatabaseReference extends Query {

    DatabaseReference child(String s);

    DatabaseReference push();

    public String getKey();

    void updateChildren(Map<String, Object> update);

    void setValue(Object o);

    void removeValue();

}
