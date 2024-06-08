package dev.practice.order.infrastructure.item;

import dev.practice.order.common.exception.EntityNotFoundException;
import dev.practice.order.domain.item.Item;
import dev.practice.order.domain.item.ItemDocument;
import dev.practice.order.domain.item.ItemReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class ItemReaderImpl implements ItemReader {
    private final ItemRepository itemRepository;

    @Override
    public Item getItemBy(String itemToken) {
        return itemRepository.findByItemToken(itemToken)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<ItemDocument.ItemOptionGroupDocument> getItemOptionSeries(Item item) {
        // Item<Aggregate Root> -> ItemOptionGroup -> ItemOption
        // ItemOptionGroup Entity List(Element: ItemOption Entity) → ItemOptionGroup Document List(Element: ItemOption Document) 로 변환하는 과정

        var itemOptionGroupList = item.getItemOptionGroupList();
        return itemOptionGroupList.stream()
                .map(itemOptionGroup -> {
                    var itemOptionList = itemOptionGroup.getItemOptionList(); //ItemOptionGroup Entity 로 부터 ItemOption Entity List Read(조회-수신)

                    //get Entity from ItemOptionList → switch Entity to Document → collect Documents to List
                    var itemOptionDocumentList = itemOptionList.stream()
                            .map(ItemDocument.ItemOptionDocument::new)
                            .collect(Collectors.toList());

                    //ItemOptionGroup Entity 와 ItemOption Document List 를 제공하여 ItemOptionGroupDocument 로 반출(return)
                    return new ItemDocument.ItemOptionGroupDocument(itemOptionGroup, itemOptionDocumentList);
                }).collect(Collectors.toList());
    }
}
