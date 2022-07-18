package jpabook.jpashap.repository;

import jpabook.jpashap.entity.item.Item;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Getter
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item) {
        if(item.getId() == null) {
            em.persist(item);
        } else {
            em.merge(item);
        }
    }

    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        return em.createQuery("select i from item i", Item.class)
                .getResultList();
    }
}
