package dev.practice.order.domain.item;

import dev.practice.order.domain.partner.PartnerReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final PartnerReader partnerReader;
    private final ItemStore itemStore;
    private final ItemReader itemReader;
    private final ItemOptionGroupStore itemOptionGroupStore;
    private final ItemOptionStore itemOptionStore;

    @Override
    public String registerItem(ItemCommand.RegisterItemRequest request, String partnerToken) {
        // 1. get PartnerId (search by partnerToken)
        var partner = partnerReader.getPartner(partnerToken);
        var partnerId = partner.getId();

        // 2. item store (FK Root 이므로 item 저장이 가장 먼저 선행되어야함)
        var initItem = request.toEntity(partnerId);
        var item = itemStore.store(initItem);

        // 3. itemOption, itemOptionGroup store (item FK를 가지므로 사전에 item 객체가 저장되어야만 함)
        request.getItemOptionGroupRequestList().forEach(requestItemOptionGroup -> {
            // 3-1. ItemOptionGroup store (ItemOption 을 저장하기 위해 선행되어야하여 먼저 store 하는 것)
            var initItemOptionGroup = ItemOptionGroup.builder()
                    .item(item)
                    .ordering(requestItemOptionGroup.getOrdering())
                    .itemOptionGroupName(requestItemOptionGroup.getItemOptionGroupName())
                    .build();

            // 3-2. ItemOption store
            var itemOptionGroup = itemOptionGroupStore.store(initItemOptionGroup);
            requestItemOptionGroup.getItemOptionRequestList().forEach(requestItemOption -> {
                var initItemOption = ItemOption.builder()
                        .itemOptionGroup(itemOptionGroup)
                        .ordering(requestItemOption.getOrdering())
                        .itemOptionName(requestItemOption.getItemOptionName())
                        .itemOptionPrice(requestItemOption.getItemOptionPrice())
                        .build();
                itemOptionStore.store(initItemOption);
            });
        });

    }

    @Override
    public void changeOnSale(String itemToken) {

    }

    @Override
    public void changeEndOfSale(String itemToken) {

    }

    @Override
    public ItemInfo.Main retrieveItemInfo(String itemToken) {
        return null;
    }
}
