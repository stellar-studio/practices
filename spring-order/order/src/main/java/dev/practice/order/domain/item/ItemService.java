package dev.practice.order.domain.item;

public interface ItemService {
    String registerItem(ItemCommand.RegisterItemRequest request, String partnerToken);
    void changeStatusToOnSale(String itemToken);
    void changeStatusToEndSale(String itemToken);
    ItemDocument.Main retrieveItemDocument(String itemToken);
}
