package dev.practice.order.infrastructure.item.optionGroup;

import dev.practice.order.domain.item.optionGroup.ItemOptionGroup;
import dev.practice.order.domain.item.optionGroup.ItemOptionGroupStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ItemOptionGroupStoreImpl implements ItemOptionGroupStore {
    private final ItemOptionGroupRepository itemOptionGroupRepository;

    @Override
    public ItemOptionGroup store(ItemOptionGroup initItemOptionGroup) {
        return itemOptionGroupRepository.save(initItemOptionGroup);
    }
}
