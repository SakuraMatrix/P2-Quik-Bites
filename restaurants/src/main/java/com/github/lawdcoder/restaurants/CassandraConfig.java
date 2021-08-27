package com.github.lawdcoder.restaurants;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractReactiveCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;

import java.util.Arrays;
import java.util.List;


@Configuration
@EnableReactiveCassandraRepositories

public class CassandraConfig extends AbstractReactiveCassandraConfiguration {
    String keyspace = "restaurant";
    String keyspace1 = "menu";


    @Override
    protected String getKeyspaceName(){
        return keyspace;
    }
    @Override
    protected String getContactPoints(){
        return "localhost";
    }
    @Override
    public SchemaAction getSchemaAction(){
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        CreateKeyspaceSpecification specification = CreateKeyspaceSpecification.createKeyspace(keyspace)
                .ifNotExists()
                .with(KeyspaceOption.DURABLE_WRITES, true);
        return Arrays.asList(specification);
    }
}