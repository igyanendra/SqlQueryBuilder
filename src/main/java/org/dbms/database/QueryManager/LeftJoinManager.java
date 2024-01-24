package org.dbms.database.QueryManager;

public class LeftJoinManager {
    public static void leftJoinManager(StringBuilder output, String table, String onCondition){
        output.append(" LEFT JOIN ").append(table).append(" ON ").append(onCondition);

    }
}
