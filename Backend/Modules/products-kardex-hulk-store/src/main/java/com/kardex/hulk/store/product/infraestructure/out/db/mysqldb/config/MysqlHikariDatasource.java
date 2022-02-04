package com.kardex.hulk.store.product.infraestructure.out.db.mysqldb.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class MysqlHikariDatasource extends HikariDataSource {

    public MysqlHikariDatasource(HikariConfig configuration) {
        super(configuration);
    }

}
