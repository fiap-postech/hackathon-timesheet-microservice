package br.com.fiap.hackathon.driven.mysql.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaAuditing
@EnableJpaRepositories("br.com.fiap.hackathon.driven.mysql.repository")
@EntityScan("br.com.fiap.hackathon.driven.mysql.model")
@ComponentScan("br.com.fiap.hackathon.driven.mysql")
public class MySQLConfiguration {
}

