package org.dbms.database.QueryManager;

public class SelectManager {
    public static void selectManager(StringBuilder output, String... columns) {
        output.append("SELECT ");
        for (int i = 0; i < columns.length; i++) {
            output.append(columns[i]);
            if (i < columns.length - 1) {
                output.append(", ");
            }
        }
    }
}
