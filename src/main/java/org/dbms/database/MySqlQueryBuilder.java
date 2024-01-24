package org.dbms.database;


import org.dbms.utils.Constant.ErrorException;
import org.dbms.database.QueryManager.*;

public class MySqlQueryBuilder implements MysqlBuilder {
    private final StringBuilder selectClause = new StringBuilder();
    private final StringBuilder fromClause = new StringBuilder();
    private final StringBuilder whereClause = new StringBuilder();
    private final StringBuilder joinClause = new StringBuilder();
    private final StringBuilder orderByClause = new StringBuilder();
    private final StringBuilder groupByClause = new StringBuilder();

    @Override
    public QueryBuilder select(String... columns) {
        SelectManager.selectManager(selectClause, columns);
        return this;
    }

    @Override
    public QueryBuilder from(String table) {
        FromManager.fromManager(fromClause, table);
        return this;
    }

    @Override
    public QueryBuilder where(String logicalOperator, String... conditions) {
        WhereManager.whereManager(whereClause, logicalOperator, conditions);
        return this;
    }

    @Override
    public QueryBuilder where(String condition) {
        WhereManager.whereManager(whereClause, condition);
        return this;
    }

    @Override
    public QueryBuilder innerJoin(String table, String onCondition) {
        InnerJoinManager.innerJoinManager(joinClause, table, onCondition);
        return this;
    }

    @Override
    public QueryBuilder leftJoin(String table, String onCondition) {
        LeftJoinManager.leftJoinManager(joinClause, table, onCondition);
        return this;
    }

    @Override
    public QueryBuilder orderBy(String... columns) {
        OrderByManager.orderByManager(orderByClause, columns);
        return this;
    }

    @Override
    public QueryBuilder orderBy(String order, String column) {
        OrderByManager.orderByManager(orderByClause, order, column);
        return this;
    }

    @Override
    public QueryBuilder groupBy(String... columns) {
        GroupByManager.groupManager(groupByClause, columns);
        return this;
    }

    @Override
    public String build() {

        if (selectClause.isEmpty()) {
            throw new IllegalStateException(ErrorException.SELECT_CLAUSE_NOT_FOUND);
        }
        if (fromClause.isEmpty()) {
            throw new IllegalStateException(ErrorException.FROM_CLAUSE_NOT_FOUND);
        }
        return String.valueOf(selectClause) + fromClause + joinClause + whereClause + groupByClause + orderByClause;
    }
}