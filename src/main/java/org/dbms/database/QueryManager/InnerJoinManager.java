package org.dbms.database.QueryManager;

public class InnerJoinManager {
    public static void innerJoinManager(StringBuilder output, String table, String onCondition){
        output.append(" INNER JOIN ").append(table).append(" ON ").append(onCondition);
    }
}
