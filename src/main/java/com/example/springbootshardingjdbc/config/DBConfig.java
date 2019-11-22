package com.example.springbootshardingjdbc.config;

import com.dangdang.ddframe.rdb.sharding.id.generator.IdGenerator;
import com.dangdang.ddframe.rdb.sharding.id.generator.self.CommonSelfIdGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 *
 *@author wb-wys567063
 *@version $ Id: DBConfig.java, v 0.1 2019年11月21日 16:42 wb-wys567063 Exp $
 */
@Configuration
public class DBConfig {
    @Bean
    public IdGenerator getIdGenerator() {
        return new CommonSelfIdGenerator();
    }
}
