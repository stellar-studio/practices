package dev.practice.order.interfaces.order;

import dev.practice.order.domain.order.OrderCommand;
import dev.practice.order.domain.order.OrderInfo;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-08T17:13:21+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class OrderDtoMapperImpl implements OrderDtoMapper {

    private final DateTimeFormatter dateTimeFormatter_yyyy_MM_dd_HH_mm_ss_11333195168 = DateTimeFormatter.ofPattern( "yyyy-MM-dd HH:mm:ss" );

    @Override
    public OrderDto.Main of(OrderInfo.Main mainResult) {
        if ( mainResult == null ) {
            return null;
        }

        OrderDto.Main.MainBuilder main = OrderDto.Main.builder();

        if ( mainResult.getOrderedAt() != null ) {
            main.orderedAt( dateTimeFormatter_yyyy_MM_dd_HH_mm_ss_11333195168.format( mainResult.getOrderedAt() ) );
        }
        main.orderToken( mainResult.getOrderToken() );
        main.userId( mainResult.getUserId() );
        main.payMethod( mainResult.getPayMethod() );
        main.totalAmount( mainResult.getTotalAmount() );
        main.deliveryInfo( of( mainResult.getDeliveryInfo() ) );
        main.status( mainResult.getStatus() );
        main.statusDescription( mainResult.getStatusDescription() );
        main.orderItemList( orderItemListToOrderItemList( mainResult.getOrderItemList() ) );

        return main.build();
    }

    @Override
    public OrderDto.DeliveryInfo of(OrderInfo.DeliveryInfo deliveryResult) {
        if ( deliveryResult == null ) {
            return null;
        }

        OrderDto.DeliveryInfo.DeliveryInfoBuilder deliveryInfo = OrderDto.DeliveryInfo.builder();

        deliveryInfo.receiverName( deliveryResult.getReceiverName() );
        deliveryInfo.receiverPhone( deliveryResult.getReceiverPhone() );
        deliveryInfo.receiverZipcode( deliveryResult.getReceiverZipcode() );
        deliveryInfo.receiverAddress1( deliveryResult.getReceiverAddress1() );
        deliveryInfo.receiverAddress2( deliveryResult.getReceiverAddress2() );
        deliveryInfo.etcMessage( deliveryResult.getEtcMessage() );

        return deliveryInfo.build();
    }

    @Override
    public OrderDto.OrderItem of(OrderInfo.OrderItem orderItemResult) {
        if ( orderItemResult == null ) {
            return null;
        }

        OrderDto.OrderItem.OrderItemBuilder orderItem = OrderDto.OrderItem.builder();

        orderItem.orderCount( orderItemResult.getOrderCount() );
        orderItem.partnerId( orderItemResult.getPartnerId() );
        orderItem.itemId( orderItemResult.getItemId() );
        orderItem.itemName( orderItemResult.getItemName() );
        orderItem.totalAmount( orderItemResult.getTotalAmount() );
        orderItem.itemPrice( orderItemResult.getItemPrice() );
        orderItem.deliveryStatus( orderItemResult.getDeliveryStatus() );
        orderItem.deliveryStatusDescription( orderItemResult.getDeliveryStatusDescription() );
        orderItem.orderItemOptionGroupList( orderItemOptionGroupListToOrderItemOptionGroupList( orderItemResult.getOrderItemOptionGroupList() ) );

        return orderItem.build();
    }

    @Override
    public OrderCommand.RegisterOrder of(OrderDto.RegisterOrderRequest request) {
        if ( request == null ) {
            return null;
        }

        OrderCommand.RegisterOrder.RegisterOrderBuilder registerOrder = OrderCommand.RegisterOrder.builder();

        registerOrder.userId( request.getUserId() );
        registerOrder.payMethod( request.getPayMethod() );
        registerOrder.receiverName( request.getReceiverName() );
        registerOrder.receiverPhone( request.getReceiverPhone() );
        registerOrder.receiverZipcode( request.getReceiverZipcode() );
        registerOrder.receiverAddress1( request.getReceiverAddress1() );
        registerOrder.receiverAddress2( request.getReceiverAddress2() );
        registerOrder.etcMessage( request.getEtcMessage() );
        registerOrder.orderItemList( registerOrderItemListToRegisterOrderItemList( request.getOrderItemList() ) );

        return registerOrder.build();
    }

    @Override
    public OrderCommand.RegisterOrderItem of(OrderDto.RegisterOrderItem request) {
        if ( request == null ) {
            return null;
        }

        OrderCommand.RegisterOrderItem.RegisterOrderItemBuilder registerOrderItem = OrderCommand.RegisterOrderItem.builder();

        registerOrderItem.orderCount( request.getOrderCount() );
        registerOrderItem.itemToken( request.getItemToken() );
        registerOrderItem.itemName( request.getItemName() );
        registerOrderItem.itemPrice( request.getItemPrice() );
        registerOrderItem.orderItemOptionGroupList( registerOrderItemOptionGroupRequestListToRegisterOrderItemOptionGroupList( request.getOrderItemOptionGroupList() ) );

        return registerOrderItem.build();
    }

    @Override
    public OrderCommand.RegisterOrderItemOptionGroup of(OrderDto.RegisterOrderItemOptionGroupRequest request) {
        if ( request == null ) {
            return null;
        }

        OrderCommand.RegisterOrderItemOptionGroup.RegisterOrderItemOptionGroupBuilder registerOrderItemOptionGroup = OrderCommand.RegisterOrderItemOptionGroup.builder();

        registerOrderItemOptionGroup.ordering( request.getOrdering() );
        registerOrderItemOptionGroup.itemOptionGroupName( request.getItemOptionGroupName() );
        registerOrderItemOptionGroup.orderItemOptionList( registerOrderItemOptionRequestListToRegisterOrderItemOptionList( request.getOrderItemOptionList() ) );

        return registerOrderItemOptionGroup.build();
    }

    @Override
    public OrderCommand.RegisterOrderItemOption of(OrderDto.RegisterOrderItemOptionRequest request) {
        if ( request == null ) {
            return null;
        }

        OrderCommand.RegisterOrderItemOption.RegisterOrderItemOptionBuilder registerOrderItemOption = OrderCommand.RegisterOrderItemOption.builder();

        registerOrderItemOption.ordering( request.getOrdering() );
        registerOrderItemOption.itemOptionName( request.getItemOptionName() );
        registerOrderItemOption.itemOptionPrice( request.getItemOptionPrice() );

        return registerOrderItemOption.build();
    }

    @Override
    public OrderDto.RegisterResponse of(String orderToken) {
        if ( orderToken == null ) {
            return null;
        }

        OrderDto.RegisterResponse.RegisterResponseBuilder registerResponse = OrderDto.RegisterResponse.builder();

        registerResponse.orderToken( orderToken );

        return registerResponse.build();
    }

    @Override
    public OrderCommand.PaymentRequest of(OrderDto.PaymentRequest request) {
        if ( request == null ) {
            return null;
        }

        OrderCommand.PaymentRequest.PaymentRequestBuilder paymentRequest = OrderCommand.PaymentRequest.builder();

        paymentRequest.orderToken( request.getOrderToken() );
        paymentRequest.amount( request.getAmount() );
        paymentRequest.payMethod( request.getPayMethod() );

        return paymentRequest.build();
    }

    protected List<OrderDto.OrderItem> orderItemListToOrderItemList(List<OrderInfo.OrderItem> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderDto.OrderItem> list1 = new ArrayList<OrderDto.OrderItem>( list.size() );
        for ( OrderInfo.OrderItem orderItem : list ) {
            list1.add( of( orderItem ) );
        }

        return list1;
    }

    protected OrderDto.OrderItemOption orderItemOptionToOrderItemOption(OrderInfo.OrderItemOption orderItemOption) {
        if ( orderItemOption == null ) {
            return null;
        }

        OrderDto.OrderItemOption.OrderItemOptionBuilder orderItemOption1 = OrderDto.OrderItemOption.builder();

        orderItemOption1.ordering( orderItemOption.getOrdering() );
        orderItemOption1.itemOptionName( orderItemOption.getItemOptionName() );
        orderItemOption1.itemOptionPrice( orderItemOption.getItemOptionPrice() );

        return orderItemOption1.build();
    }

    protected List<OrderDto.OrderItemOption> orderItemOptionListToOrderItemOptionList(List<OrderInfo.OrderItemOption> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderDto.OrderItemOption> list1 = new ArrayList<OrderDto.OrderItemOption>( list.size() );
        for ( OrderInfo.OrderItemOption orderItemOption : list ) {
            list1.add( orderItemOptionToOrderItemOption( orderItemOption ) );
        }

        return list1;
    }

    protected OrderDto.OrderItemOptionGroup orderItemOptionGroupToOrderItemOptionGroup(OrderInfo.OrderItemOptionGroup orderItemOptionGroup) {
        if ( orderItemOptionGroup == null ) {
            return null;
        }

        OrderDto.OrderItemOptionGroup.OrderItemOptionGroupBuilder orderItemOptionGroup1 = OrderDto.OrderItemOptionGroup.builder();

        orderItemOptionGroup1.ordering( orderItemOptionGroup.getOrdering() );
        orderItemOptionGroup1.itemOptionGroupName( orderItemOptionGroup.getItemOptionGroupName() );
        orderItemOptionGroup1.orderItemOptionList( orderItemOptionListToOrderItemOptionList( orderItemOptionGroup.getOrderItemOptionList() ) );

        return orderItemOptionGroup1.build();
    }

    protected List<OrderDto.OrderItemOptionGroup> orderItemOptionGroupListToOrderItemOptionGroupList(List<OrderInfo.OrderItemOptionGroup> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderDto.OrderItemOptionGroup> list1 = new ArrayList<OrderDto.OrderItemOptionGroup>( list.size() );
        for ( OrderInfo.OrderItemOptionGroup orderItemOptionGroup : list ) {
            list1.add( orderItemOptionGroupToOrderItemOptionGroup( orderItemOptionGroup ) );
        }

        return list1;
    }

    protected List<OrderCommand.RegisterOrderItem> registerOrderItemListToRegisterOrderItemList(List<OrderDto.RegisterOrderItem> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderCommand.RegisterOrderItem> list1 = new ArrayList<OrderCommand.RegisterOrderItem>( list.size() );
        for ( OrderDto.RegisterOrderItem registerOrderItem : list ) {
            list1.add( of( registerOrderItem ) );
        }

        return list1;
    }

    protected List<OrderCommand.RegisterOrderItemOptionGroup> registerOrderItemOptionGroupRequestListToRegisterOrderItemOptionGroupList(List<OrderDto.RegisterOrderItemOptionGroupRequest> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderCommand.RegisterOrderItemOptionGroup> list1 = new ArrayList<OrderCommand.RegisterOrderItemOptionGroup>( list.size() );
        for ( OrderDto.RegisterOrderItemOptionGroupRequest registerOrderItemOptionGroupRequest : list ) {
            list1.add( of( registerOrderItemOptionGroupRequest ) );
        }

        return list1;
    }

    protected List<OrderCommand.RegisterOrderItemOption> registerOrderItemOptionRequestListToRegisterOrderItemOptionList(List<OrderDto.RegisterOrderItemOptionRequest> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderCommand.RegisterOrderItemOption> list1 = new ArrayList<OrderCommand.RegisterOrderItemOption>( list.size() );
        for ( OrderDto.RegisterOrderItemOptionRequest registerOrderItemOptionRequest : list ) {
            list1.add( of( registerOrderItemOptionRequest ) );
        }

        return list1;
    }
}
