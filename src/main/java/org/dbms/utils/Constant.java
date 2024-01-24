package org.dbms.utils;

public class Constant {
    public static class ErrorException{
        public static String INVALID_FORMAT = "Operator should only contain AND or OR";
        public static String SELECT_CLAUSE_NOT_FOUND = "Missing SELECT Clause";
        public static String FROM_CLAUSE_NOT_FOUND = "Missing FROM Clause";
        public static String QUERY_ALREADY_EXIST = "Query already built and immutable";
    }
}
