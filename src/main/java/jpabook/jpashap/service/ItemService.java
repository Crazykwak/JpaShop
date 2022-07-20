package jpabook.jpashap.service;

import jpabook.jpashap.entity.item.Item;
import jpabook.jpashap.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    @Transactional
    public void updateItem(Long itemId, UpdateItemDto itemDto) {
        Item item = itemRepository.findOne(itemId);
        Optional.ofNullable(itemDto.getName())
                .ifPresent((name) -> item.setName(name));
        Optional.ofNullable(itemDto.getPrice())
                .ifPresent((price) -> item.setPrice(price));
        Optional.ofNullable(itemDto.getStockQuantity())
                .ifPresent((quantity) -> item.setStockQuantity(quantity));

    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}
