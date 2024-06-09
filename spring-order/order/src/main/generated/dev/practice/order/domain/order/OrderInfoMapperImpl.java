package dev.practice.order.domain.order;

import dev.practice.order.domain.order.fragment.DeliveryFragment;
import dev.practice.order.domain.order.item.OrderItem;
import dev.practice.order.domain.order.item.OrderItemOption;
import dev.practice.order.domain.order.item.OrderItemOptionGroup;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-09T21:38:09+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class OrderInfoMapperImpl implements OrderInfoMapper {

    @Override
    public OrderInfo.Main of(Order order, List<OrderItem> orderItemList) {
        if ( order == null && orderItemList == null ) {
            return null;
        }

        OrderInfo.Main.MainBuilder main = OrderInfo.Main.builder();

        if ( order != null ) {
            main.orderId( order.getId() );
            main.deliveryInfo( deliveryFragmentToDeliveryInfo( order.getDeliveryFragment() ) );
            main.orderToken( order.getOrderToken() );
            main.userId( order.getUserId() );
            main.payMethod( order.getPayMethod() );
            main.orderedAt( order.getOrderedAt() );
            main.orderItemList( orderItemListToOrderItemList( order.getOrderItemList() ) );
        }
        main.totalAmount( order.calculateTotalAmount() );
        main.status( order.getStatus().name() );
        main.statusDescription( order.getStatus().getDescription() );

        return main.build();
    }

    @Override
    public OrderInfo.OrderItem of(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }

        OrderInfo.OrderItem.OrderItemBuilder orderItem1 = OrderInfo.OrderItem.builder();

        orderItem1.orderCount( orderItem.getOrderCount() );
        orderItem1.partnerId( orderItem.getPartnerId() );
        orderItem1.itemId( orderItem.getItemId() );
        orderItem1.itemName( orderItem.getItemName() );
        orderItem1.itemPrice( orderItem.getItemPrice() );
        orderItem1.orderItemOptionGroupList( orderItemOptionGroupListToOrderItemOptionGroupList( orderItem.getOrderItemOptionGroupList() ) );

        orderItem1.deliveryStatus( orderItem.getDeliveryStatus().name() );
        orderItem1.deliveryStatusDescription( orderItem.getDeliveryStatus().getDescription() );
        orderItem1.totalAmount( orderItem.calculateTotalAmount() );

        return orderItem1.build();
    }

    @Override
    public OrderInfo.OrderItemOptionGroup of(OrderItemOptionGroup orderItemOptionGroup) {
        if ( orderItemOptionGroup == null ) {
            return null;
        }

        OrderInfo.OrderItemOptionGroup.OrderItemOptionGroupBuilder orderItemOptionGroup1 = OrderInfo.OrderItemOptionGroup.builder();

        orderItemOptionGroup1.ordering( orderItemOptionGroup.getOrdering() );
        orderItemOptionGroup1.itemOptionGroupName( orderItemOptionGroup.getItemOptionGroupName() );
        orderItemOptionGroup1.orderItemOptionList( orderItemOptionListToOrderItemOptionList( orderItemOptionGroup.getOrderItemOptionList() ) );

        return orderItemOptionGroup1.build();
    }

    @Override
    public OrderInfo.OrderItemOption of(OrderItemOption orderItemOption) {
        if ( orderItemOption == null ) {
            return null;
        }

        OrderInfo.OrderItemOption.OrderItemOptionBuilder orderItemOption1 = OrderInfo.OrderItemOption.builder();

        orderItemOption1.ordering( orderItemOption.getOrdering() );
        orderItemOption1.itemOptionName( orderItemOption.getItemOptionName() );
        orderItemOption1.itemOptionPrice( orderItemOption.getItemOptionPrice() );

        return orderItemOption1.build();
    }

    protected OrderInfo.DeliveryInfo deliveryFragmentToDeliveryInfo(DeliveryFragment deliveryFragment) {
        if ( deliveryFragment == null ) {
            return null;
        }

        OrderInfo.DeliveryInfo.DeliveryInfoBuilder deliveryInfo = OrderInfo.DeliveryInfo.builder();

        deliveryInfo.receiverName( deliveryFragment.getReceiverName() );
        deliveryInfo.receiverPhone( deliveryFragment.getReceiverPhone() );
        deliveryInfo.receiverZipcode( deliveryFragment.getReceiverZipcode() );
        deliveryInfo.receiverAddress1( deliveryFragment.getReceiverAddress1() );
        deliveryInfo.receiverAddress2( deliveryFragment.getReceiverAddress2() );
        deliveryInfo.etcMessage( deliveryFragment.getEtcMessage() );

        return deliveryInfo.build();
    }

    protected List<OrderInfo.OrderItem> orderItemListToOrderItemList(List<OrderItem> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderInfo.OrderItem> list1 = new ArrayList<OrderInfo.OrderItem>( list.size() );
        for ( OrderItem orderItem : list ) {
            list1.add( of( orderItem ) );
        }

        return list1;
    }

    protected List<OrderInfo.OrderItemOptionGroup> orderItemOptionGroupListToOrderItemOptionGroupList(List<OrderItemOptionGroup> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderInfo.OrderItemOptionGroup> list1 = new ArrayList<OrderInfo.OrderItemOptionGroup>( list.size() );
        for ( OrderItemOptionGroup orderItemOptionGroup : list ) {
            list1.add( of( orderItemOptionGroup ) );
        }

        return list1;
    }

    protected List<OrderInfo.OrderItemOption> orderItemOptionListToOrderItemOptionList(List<OrderItemOption> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderInfo.OrderItemOption> list1 = new ArrayList<OrderInfo.OrderItemOption>( list.size() );
        for ( OrderItemOption orderItemOption : list ) {
            list1.add( of( orderItemOption ) );
        }

        return list1;
    }
}
