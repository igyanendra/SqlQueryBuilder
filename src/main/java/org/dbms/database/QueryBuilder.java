package org.dbms.database;

public interface QueryBuilder {
    QueryBuilder select(String... columns);
    QueryBuilder from(String table);

    QueryBuilder where(String logicalOperator, String... condition);

    QueryBuilder where(String condition);

    QueryBuilder innerJoin(String table, String onCondition);

    QueryBuilder leftJoin(String table, String onCondition);

    QueryBuilder orderBy(String... columns);

    QueryBuilder orderBy(String order, String column);

    QueryBuilder groupBy(String... columns);

    String build();
}