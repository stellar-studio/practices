package dev.practice.order.domain.item;

import java.util.List;

public interface ItemReader {
    Item getItemBy(String itemToken);
    List<ItemDocument.ItemOptionGroupDocument> getItemOptionSeries(Item item);
}
