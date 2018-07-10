package com.lilian;

import com.lilian.base.jpa.BaseJpaRepositoryFactoryBean;
import com.lilian.base.mongo.BaseMongoRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.lilian.repository.mysql"}, repositoryFactoryBeanClass = BaseJpaRepositoryFactoryBean.class)
@EnableMongoRepositories(basePackages = {"com.lilian.repository.mongo"}, repositoryFactoryBeanClass = BaseMongoRepositoryFactoryBean.class)
public class JpaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }
}
