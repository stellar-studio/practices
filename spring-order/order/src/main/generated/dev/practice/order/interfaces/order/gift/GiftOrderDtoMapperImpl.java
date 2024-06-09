package dev.practice.order.interfaces.order.gift;

import dev.practice.order.domain.order.OrderCommand;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-10T01:28:48+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class GiftOrderDtoMapperImpl implements GiftOrderDtoMapper {

    @Override
    public OrderCommand.RegisterOrder of(GiftOrderDto.RegisterOrderRequest request) {
        if ( request == null ) {
            return null;
        }

        OrderCommand.RegisterOrder.RegisterOrderBuilder registerOrder = OrderCommand.RegisterOrder.builder();

        registerOrder.userId( request.getBuyerUserId() );
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
    public OrderCommand.RegisterOrderItem of(GiftOrderDto.RegisterOrderItem request) {
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
    public OrderCommand.RegisterOrderItemOptionGroup of(GiftOrderDto.RegisterOrderItemOptionGroupRequest request) {
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
    public OrderCommand.RegisterOrderItemOption of(GiftOrderDto.RegisterOrderItemOptionRequest request) {
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
    public GiftOrderDto.RegisterResponse of(String orderToken) {
        if ( orderToken == null ) {
            return null;
        }

        GiftOrderDto.RegisterResponse.RegisterResponseBuilder registerResponse = GiftOrderDto.RegisterResponse.builder();

        registerResponse.orderToken( orderToken );

        return registerResponse.build();
    }

    @Override
    public OrderCommand.PaymentRequest of(GiftOrderDto.PaymentRequest request) {
        if ( request == null ) {
            return null;
        }

        OrderCommand.PaymentRequest.PaymentRequestBuilder paymentRequest = OrderCommand.PaymentRequest.builder();

        paymentRequest.orderToken( request.getOrderToken() );
        paymentRequest.amount( request.getAmount() );
        paymentRequest.payMethod( request.getPayMethod() );

        return paymentRequest.build();
    }

    protected List<OrderCommand.RegisterOrderItem> registerOrderItemListToRegisterOrderItemList(List<GiftOrderDto.RegisterOrderItem> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderCommand.RegisterOrderItem> list1 = new ArrayList<OrderCommand.RegisterOrderItem>( list.size() );
        for ( GiftOrderDto.RegisterOrderItem registerOrderItem : list ) {
            list1.add( of( registerOrderItem ) );
        }

        return list1;
    }

    protected List<OrderCommand.RegisterOrderItemOptionGroup> registerOrderItemOptionGroupRequestListToRegisterOrderItemOptionGroupList(List<GiftOrderDto.RegisterOrderItemOptionGroupRequest> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderCommand.RegisterOrderItemOptionGroup> list1 = new ArrayList<OrderCommand.RegisterOrderItemOptionGroup>( list.size() );
        for ( GiftOrderDto.RegisterOrderItemOptionGroupRequest registerOrderItemOptionGroupRequest : list ) {
            list1.add( of( registerOrderItemOptionGroupRequest ) );
        }

        return list1;
    }

    protected List<OrderCommand.RegisterOrderItemOption> registerOrderItemOptionRequestListToRegisterOrderItemOptionList(List<GiftOrderDto.RegisterOrderItemOptionRequest> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderCommand.RegisterOrderItemOption> list1 = new ArrayList<OrderCommand.RegisterOrderItemOption>( list.size() );
        for ( GiftOrderDto.RegisterOrderItemOptionRequest registerOrderItemOptionRequest : list ) {
            list1.add( of( registerOrderItemOptionRequest ) );
        }

        return list1;
    }
}
