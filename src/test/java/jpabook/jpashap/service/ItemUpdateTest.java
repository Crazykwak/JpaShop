package jpabook.jpashap.service;

import jpabook.jpashap.entity.item.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
public class ItemUpdateTest {

    @Autowired
    EntityManager em;

    @Test
    public void updateTest() throws Exception {
        //given
        Book book = em.find(Book.class, 1L);

        //TX
        book.setName("asdf");

        //변경감지 == dirty checking
        //TX commit


        //when

        //then

    }
}
