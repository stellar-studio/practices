package dev.practice.order.domain.item;

import dev.practice.order.domain.item.option.ItemOption;
import dev.practice.order.domain.item.optionGroup.ItemOptionGroup;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

public class ItemDocument {

    @Getter
    @ToString
    public static class Main {
        private final String itemToken;
        private final Long partnerId;
        private final String itemName;
        private final Long itemPrice;
        private final Item.Status status;
        private final List<ItemOptionGroupDocument> itemOptionGroupList;

        public Main(Item item, List<ItemOptionGroupDocument> itemOptionGroupDocumentList) {
            this.itemToken = item.getItemToken();
            this.partnerId = item.getPartnerId();
            this.itemName = item.getItemName();
            this.itemPrice = item.getItemPrice();
            this.status = item.getStatus();
            this.itemOptionGroupList = itemOptionGroupDocumentList;
        }
    }

    @Getter
    @ToString
    public static class ItemOptionGroupDocument {
        private final Integer ordering;
        private final String itemOptionGroupName;
        private final List<ItemOptionDocument> itemOptionList;

        public ItemOptionGroupDocument(ItemOptionGroup itemOptionGroup, List<ItemOptionDocument> itemOptionList) {
            this.ordering = itemOptionGroup.getOrdering();
            this.itemOptionGroupName = itemOptionGroup.getItemOptionGroupName();
            this.itemOptionList = itemOptionList;
        }
    }

    @Getter
    @ToString
    public static class ItemOptionDocument {
        private final Integer ordering;
        private final String itemOptionName;
        private final Long itemOptionPrice;

        public ItemOptionDocument(ItemOption itemOption) {
            this.ordering = itemOption.getOrdering();
            this.itemOptionName = itemOption.getItemOptionName();
            this.itemOptionPrice = itemOption.getItemOptionPrice();
        }
    }
}