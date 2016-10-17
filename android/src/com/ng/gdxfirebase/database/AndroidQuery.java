package com.ng.gdxfirebase.database;

import com.ng.gdxfirebase.database.Query;

/**
 * Created by Personal on 10/17/2016.
 */

public class AndroidQuery implements Query {

    com.google.firebase.database.Query query;

    public AndroidQuery(com.google.firebase.database.Query query){
        this.query=query;


    }


}
