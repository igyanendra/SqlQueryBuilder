package org.dbms.database.QueryManager;

public class FromManager {
    public static void fromManager(StringBuilder output, String table){
        output.append(" FROM ").append(table);
    }
}
