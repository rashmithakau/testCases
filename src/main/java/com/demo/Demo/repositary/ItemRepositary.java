package com.demo.Demo.repositary;

import com.demo.Demo.entiry.ItemEntity;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ItemRepositary extends JpaRepository<ItemEntity,Integer> {
    boolean getItemEntityByItemName(String itemName);

    boolean existsByItemName(String itemName);

    ItemEntity findItemEntityByItemName(String itemName);

    List<ItemEntity> findAllByItemNameEqualsAndActiveStateEquals(String itemName,boolean activeStatus);

    List<ItemEntity> findAllByActiveState(boolean activeState);
    Page<ItemEntity> findAllByActiveState(boolean activeState, Pageable pageable);

    int countAllByActiveState(boolean activeStatus);
}
