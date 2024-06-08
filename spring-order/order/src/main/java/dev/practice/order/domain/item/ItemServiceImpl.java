package dev.practice.order.domain.item;

import dev.practice.order.domain.partner.PartnerReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final PartnerReader partnerReader;
    private final ItemStore itemStore;
    private final ItemReader itemReader;
    private  final ItemOptionSeriesFactory itemOptionSeriesFactory;

    @Override
    @Transactional
    public String registerItem(ItemCommand.RegisterItemRequest command, String partnerToken) {
        var partner = partnerReader.getPartner(partnerToken);
        var initItem = command.toEntity(partner.getId());
        var item = itemStore.store(initItem);
        itemOptionSeriesFactory.store(command, item);
        return item.getItemToken();
    }

    @Override
    public void changeStatusToOnSale(String itemToken) {
        var item =itemReader.getItemBy(itemToken);
        item.changeStatusToOnSales();
        itemStore.store(item);
    }

    @Override
    public void changeStatusToEndSale(String itemToken) {
        var item =itemReader.getItemBy(itemToken);
        item.changeStatusToEndSales();
        itemStore.store(item);
    }

    @Override
    @Transactional(readOnly = true)
    public ItemDocument.Main retrieveItemDocument(String itemToken) {
        var item = itemReader.getItemBy(itemToken);
        var itemOptionGroupDocumentList = itemReader.getItemOptionSeries(item);
        return new ItemDocument.Main(item, itemOptionGroupDocumentList);
    }
}
