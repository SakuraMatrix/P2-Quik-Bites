package com.github.JonathanAGomez.drivers.repository;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.github.JonathanAGomez.drivers.domain.Driver;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class DriverRepository {

    private CqlSession session;

    public DriverRepository(CqlSession session){this.session = session;}


    public Flux<Driver> getAll(){
        return Flux.from(session.executeReactive("SELECT * FROM quikbites.drivers"))
                .map(row->new Driver(row.getInt("id"), row.getString("name")));
    }

    public Mono<Driver> get(String id){
        return Mono.from(session.executeReactive("SELECT * FROM quikbutes.drivers WHERE id = " +id))
                .map(row -> new Driver(row.getInt("id"), row.getString("name")));
    }

    public Mono<Driver> get(int id){
        return Mono.from(session.executeReactive("SELECT * FROM quikbutes.drivers WHERE id = " +id))
                .map(row -> new Driver(row.getInt("id"), row.getString("name")));
    }

    public Driver create(Driver driver){
        SimpleStatement statement = SimpleStatement.builder("INSERT INTO quikbites.drivers (id, name) values (?, ?)")
                .addPositionalValues(driver.getId(), driver.getName()).build();
        Flux.from(session.executeReactive(statement)).subscribe();
        return driver;
    }
}