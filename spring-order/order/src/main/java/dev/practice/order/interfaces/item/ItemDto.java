package dev.practice.order.interfaces.item;

import dev.practice.order.domain.item.Item;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

public class ItemDto {
    // 외부에서 Json 형태로 넘어올 객체들의 Structure 에 대한 사전 정의

    @Getter
    @Setter
    @ToString
    public static class RegisterItemRequest {
        private String partnerToken;
        private String itemName;
        private Long itemPrice;
        private List<RegisterItemOptionGroupRequest> itemOptionGroupList;
    }

    @Getter
    @Setter
    @ToString
    public static class RegisterItemOptionGroupRequest {
        private Integer ordering;
        private String itemOptionGroupName;
        private List<RegisterItemOptionRequest> itemOptionList;
    }

    @Getter
    @Setter
    @ToString
    public static class RegisterItemOptionRequest {
        private Integer ordering;
        private String itemOptionName;
        private Long itemOptionPrice;
    }

    @Getter
    @Builder
    @ToString
    public static class RegisterResponse {
        private final String itemToken;
    }

    @Getter
    @Setter
    @ToString
    public static class ChangeStatusItemRequest {
        private String itemToken;
    }

    @Getter
    @Builder
    @ToString
    public static class Main {
        private final String itemToken;
        private final Long partnerId;
        private final String itemName;
        private final Long itemPrice;
        private final Item.Status status;
        private final List<ItemOptionGroupDocument> itemOptionGroupList;
    }

    @Getter
    @Builder
    @ToString
    public static class ItemOptionGroupDocument {
        private final Integer ordering;
        private final String itemOptionGroupName;
        private final List<ItemOptionDocument> itemOptionList;
    }

    @Getter
    @Builder
    @ToString
    public static class ItemOptionDocument {
        private final Integer ordering;
        private final String itemOptionName;
        private final Long itemOptionPrice;
    }
}
