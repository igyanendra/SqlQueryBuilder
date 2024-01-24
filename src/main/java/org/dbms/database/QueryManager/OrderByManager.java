package org.dbms.database.QueryManager;

public class OrderByManager {
    public static void orderByManager(StringBuilder output, String... columns){
        if(output.isEmpty()){
            output.append(" ORDER BY ");
        } else {
            output.append(", ");
        }

        for(int i = 0; i < columns.length; i++){
            output.append(columns[i]);
            if( i < columns.length - 1){
                output.append(", ");
            }
        }
    }

    public static void orderByManager(StringBuilder output, String order, String column){
        if(output.isEmpty()){
            output.append(" ORDER BY ");
        } else {
            output.append(", ");
        }
        output.append(column).append(" ").append(order);
    }
}
