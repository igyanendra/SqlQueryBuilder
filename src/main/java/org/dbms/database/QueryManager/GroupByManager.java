package org.dbms.database.QueryManager;

public class GroupByManager {
    public static void groupManager(StringBuilder output, String... columns) {
        if (columns.length == 0) {
            throw new IllegalArgumentException("GROUP BY clause requires at least one column");
        }
        if (output.isEmpty()) {
            output.append(" GROUP BY ");
        } else {
            output.append(", ");
        }

        for (int i = 0; i < columns.length; i++) {
            output.append(columns[i]);
            if (i < columns.length - 1) {
                output.append(", ");
            }
        }
    }
}
