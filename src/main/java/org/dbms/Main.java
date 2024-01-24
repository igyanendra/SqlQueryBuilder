package org.dbms;

import org.dbms.database.MySqlQueryBuilder;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        MySqlQueryBuilder sqlSelect = new MySqlQueryBuilder();
        sqlSelect.select("name", "age")
                .from("users")
                .where("age < 2")
                .where("and", "name = gyanendra")
                .innerJoin("userAddress", "userAddress.userId = users.userId")
                .leftJoin("transaction", "transaction.userId = users.userId")
                .orderBy("asc", "name")
                .orderBy("age")
                .orderBy("desc", "phone")
                .groupBy("gender")
                .groupBy("age");

        System.out.println(sqlSelect.build());
    }
}

/**
 * -- EXAMPLE --
 * sqlSelect.select("name", "age")
 *                 .from("users")
 *                 .where("age < 2")
 *                 .where("and", "name = gyanendra")
 *                 .innerJoin("userAddress", "userAddress.userId = users.userId")
 *                 .leftJoin("transaction", "transaction.userId = users.userId")
 *                 .orderBy("asc", "name")
 *                 .orderBy("age")
 *                 .orderBy("desc", "phone")
 *                 .groupBy("gender")
 *                 .groupBy("age");
 *  -- OUTPUT --
 *  SELECT name, age
 *  FROM users
 *  INNER JOIN userAddress ON userAddress.userId = users.userId
 *  LEFT JOIN transaction ON transaction.userId = users.userId
 *  WHERE age < 2 AND name = 'gyanendra'
 *  GROUP BY gender, age
 *  ORDER BY name asc, age, phone desc
 */