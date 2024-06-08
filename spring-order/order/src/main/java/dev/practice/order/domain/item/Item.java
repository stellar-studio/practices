package dev.practice.order.domain.item;

import dev.practice.order.common.exception.InvalidParamException;
import dev.practice.order.common.util.TokenGenerator;
import dev.practice.order.domain.AbstractEntity;
import dev.practice.order.domain.item.optionGroup.ItemOptionGroup;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.assertj.core.util.Lists;

import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@Table(name="items")
public class Item extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String itemToken;
    private Long partnerId;
    private String itemName;
    private Long itemPrice;

    //아래 어노테이션에서 mappedBy "item"은, ItemOptionGroup 클래스 쪽 ManyToOne 선언된 변수 중 item 변수를 의미함
    //그리고 해당 변수와 동시에 선언된 JoinColumn 어노테이션 값을 기준으로 Join 을 수행하는 것
    //→ translate this line31, 32 to Human-Readable: 생성될 때, itemOptionGroupList 는 해당 클래스의 item 변수에 선언된 JoinColumn 값을 기준으로 Join 하라
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item", cascade = CascadeType.PERSIST)
    private List<ItemOptionGroup> itemOptionGroupList = Lists.newArrayList();

    @Enumerated(EnumType.STRING)
    private Status status;

    @Builder
    public Item(Long partnerId, String itemName, Long itemPrice) {
        if(partnerId == null) throw new InvalidParamException();
        if(itemName.isBlank()) throw new InvalidParamException();
        if(itemPrice == null) throw new InvalidParamException();

        this.itemToken = TokenGenerator.randomCharacter();
        this.partnerId = partnerId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;

        this.status = Status.PREPARE; //생성 시 별도 설정없이 Default 값으로 PREPARE가 저장됨.
    }

    @Getter
    @RequiredArgsConstructor
    public enum Status {
        PREPARE("판매 준비 중"),
        ON_SALES("판매 중"),
        END_SALES("판매 종료");

        private final String description;
    }

    public void changeStatusToPrepare() {
        this.status = Status.PREPARE;
    }

    public void changeStatusToOnSales() {
//        if(this.status == Status.END_SALES)
        this.status = Status.ON_SALES;
    }

    public void changeStatusToEndSales() {
        this.status = Status.END_SALES;
    }
}
