package com.github.lawdcoder.restaurants.repository;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.github.lawdcoder.restaurants.domain.menu;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class menuRepository {

    private CqlSession session;

    public menuRepository(CqlSession session){this.session = session;}

    public Flux<menu> getAll() {
        return Flux.from(session.executeReactive("SELECT * FROM restaurants.menu"))
                .map(row -> new menu(row.getInt("menuId"),row.getInt("resId"), row.getDouble("price"),row.getString("name"))
                );
    }

    public Mono<menu> get(String menuId){
        return Mono.from(session.executeReactive("SELECT * FROM restaurants.menu WHERE menuId = " +menuId))
                .map(row -> new menu(row.getInt("menuId"),row.getInt("resId"), row.getDouble("price"),row.getString("name"))
                );
    }

    public Mono<menu> getId(int menuId) {
        return Mono.from(session.executeReactive("SELECT * FROM restaurants.menu WHERE menuId = " +menuId))
                .map(row -> new menu(row.getInt("menuId"),row.getInt("resId"), row.getDouble("price"),row.getString("name"))
                );
    }

    public menu create(menu menu){
        SimpleStatement statement = SimpleStatement.builder("INSERT INTO restaurants.menu (menuId, resId, price, name) values (?, ?, ?,?)")
                .addPositionalValues(menu.getMenuId(), menu.getresId(),menu.getPrice(), menu.getName())
                .build();
        Flux.from(session.executeReactive(statement)).subscribe();
        return menu;
    }


    public Mono<menu> delete(menu menu){
        SimpleStatement statement = SimpleStatement.builder("DELETE FROM restaurants.menu where menuId = ?")
                .addPositionalValue(menu.getMenuId())
                .build();
        Flux.from(session.executeReactive(statement)).subscribe();
        return Mono.just(menu);
    }
}
