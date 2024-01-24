package org.dbms.database.QueryManager;

import org.dbms.utils.Constant;

public class WhereManager {
    public static void whereManager(StringBuilder output, String condition) {
        condition = conditionFormatter(condition);
        if (output.isEmpty()) {
            output.append(" WHERE ").append(condition);
        } else {
            output.append(" AND ").append(condition);
        }
    }

    public static void whereManager(StringBuilder output, String logicalOperator, String... conditions) {
        logicalOperator = logicalOperator.toUpperCase();
        if (!logicalOperator.equals("OR") && !logicalOperator.equals("AND")) {
            throw new IllegalStateException(Constant.ErrorException.INVALID_FORMAT);
        }

        if (output.isEmpty()) {
            output.append(" WHERE ");
        } else {
            output.append(" ").append(logicalOperator).append(" ");
        }

        for (int i = 0; i < conditions.length; i++) {
            String condition = conditionFormatter(conditions[i]);
            output.append(condition);
            if (i < conditions.length - 1) {
                output.append(" ").append(logicalOperator).append(" ");
            }
        }
    }

    public static String conditionFormatter(String condition) {
        StringBuilder output = new StringBuilder();
        String[] parts = condition.split("[=<>]");

        if (parts.length == 2) {
            String columnName = parts[0].trim();
            String columnValue = parts[1].trim();

            try {
                Integer.parseInt(columnValue);
                return condition;
            } catch (NumberFormatException e) {
                output.append(columnName).append(" = '").append(columnValue).append("'");
                return output.toString();
            }
        } else {
            throw new IllegalArgumentException("Invalid parameter format: " + condition);
        }
    }
}
