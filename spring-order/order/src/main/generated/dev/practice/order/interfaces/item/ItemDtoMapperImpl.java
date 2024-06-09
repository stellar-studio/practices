package dev.practice.order.interfaces.item;

import dev.practice.order.domain.item.ItemCommand;
import dev.practice.order.domain.item.ItemDocument;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-09T01:58:06+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class ItemDtoMapperImpl implements ItemDtoMapper {

    @Override
    public ItemCommand.RegisterItemRequest of(ItemDto.RegisterItemRequest request) {
        if ( request == null ) {
            return null;
        }

        ItemCommand.RegisterItemRequest.RegisterItemRequestBuilder registerItemRequest = ItemCommand.RegisterItemRequest.builder();

        registerItemRequest.itemOptionGroupRequestList( registerItemOptionGroupRequestListToRegisterItemOptionGroupRequestList( request.getItemOptionGroupList() ) );
        registerItemRequest.itemName( request.getItemName() );
        registerItemRequest.itemPrice( request.getItemPrice() );

        return registerItemRequest.build();
    }

    @Override
    public ItemCommand.RegisterItemOptionGroupRequest of(ItemDto.RegisterItemOptionGroupRequest request) {
        if ( request == null ) {
            return null;
        }

        ItemCommand.RegisterItemOptionGroupRequest.RegisterItemOptionGroupRequestBuilder registerItemOptionGroupRequest = ItemCommand.RegisterItemOptionGroupRequest.builder();

        registerItemOptionGroupRequest.itemOptionRequestList( registerItemOptionRequestListToRegisterItemOptionRequestList( request.getItemOptionList() ) );
        registerItemOptionGroupRequest.ordering( request.getOrdering() );
        registerItemOptionGroupRequest.itemOptionGroupName( request.getItemOptionGroupName() );

        return registerItemOptionGroupRequest.build();
    }

    @Override
    public ItemCommand.RegisterItemOptionRequest of(ItemDto.RegisterItemOptionRequest request) {
        if ( request == null ) {
            return null;
        }

        ItemCommand.RegisterItemOptionRequest.RegisterItemOptionRequestBuilder registerItemOptionRequest = ItemCommand.RegisterItemOptionRequest.builder();

        registerItemOptionRequest.ordering( request.getOrdering() );
        registerItemOptionRequest.itemOptionName( request.getItemOptionName() );
        registerItemOptionRequest.itemOptionPrice( request.getItemOptionPrice() );

        return registerItemOptionRequest.build();
    }

    @Override
    public ItemDto.RegisterResponse of(String itemToken) {
        if ( itemToken == null ) {
            return null;
        }

        ItemDto.RegisterResponse.RegisterResponseBuilder registerResponse = ItemDto.RegisterResponse.builder();

        registerResponse.itemToken( itemToken );

        return registerResponse.build();
    }

    @Override
    public ItemDto.Main of(ItemDocument.Main main) {
        if ( main == null ) {
            return null;
        }

        ItemDto.Main.MainBuilder main1 = ItemDto.Main.builder();

        main1.itemToken( main.getItemToken() );
        main1.partnerId( main.getPartnerId() );
        main1.itemName( main.getItemName() );
        main1.itemPrice( main.getItemPrice() );
        main1.status( main.getStatus() );
        main1.itemOptionGroupList( itemOptionGroupDocumentListToItemOptionGroupDocumentList( main.getItemOptionGroupList() ) );

        return main1.build();
    }

    @Override
    public ItemDto.ItemOptionGroupDocument of(ItemDocument.ItemOptionGroupDocument itemOptionGroup) {
        if ( itemOptionGroup == null ) {
            return null;
        }

        ItemDto.ItemOptionGroupDocument.ItemOptionGroupDocumentBuilder itemOptionGroupDocument = ItemDto.ItemOptionGroupDocument.builder();

        itemOptionGroupDocument.ordering( itemOptionGroup.getOrdering() );
        itemOptionGroupDocument.itemOptionGroupName( itemOptionGroup.getItemOptionGroupName() );
        itemOptionGroupDocument.itemOptionList( itemOptionDocumentListToItemOptionDocumentList( itemOptionGroup.getItemOptionList() ) );

        return itemOptionGroupDocument.build();
    }

    @Override
    public ItemDto.ItemOptionDocument of(ItemDocument.ItemOptionDocument itemOption) {
        if ( itemOption == null ) {
            return null;
        }

        ItemDto.ItemOptionDocument.ItemOptionDocumentBuilder itemOptionDocument = ItemDto.ItemOptionDocument.builder();

        itemOptionDocument.ordering( itemOption.getOrdering() );
        itemOptionDocument.itemOptionName( itemOption.getItemOptionName() );
        itemOptionDocument.itemOptionPrice( itemOption.getItemOptionPrice() );

        return itemOptionDocument.build();
    }

    protected List<ItemCommand.RegisterItemOptionGroupRequest> registerItemOptionGroupRequestListToRegisterItemOptionGroupRequestList(List<ItemDto.RegisterItemOptionGroupRequest> list) {
        if ( list == null ) {
            return null;
        }

        List<ItemCommand.RegisterItemOptionGroupRequest> list1 = new ArrayList<ItemCommand.RegisterItemOptionGroupRequest>( list.size() );
        for ( ItemDto.RegisterItemOptionGroupRequest registerItemOptionGroupRequest : list ) {
            list1.add( of( registerItemOptionGroupRequest ) );
        }

        return list1;
    }

    protected List<ItemCommand.RegisterItemOptionRequest> registerItemOptionRequestListToRegisterItemOptionRequestList(List<ItemDto.RegisterItemOptionRequest> list) {
        if ( list == null ) {
            return null;
        }

        List<ItemCommand.RegisterItemOptionRequest> list1 = new ArrayList<ItemCommand.RegisterItemOptionRequest>( list.size() );
        for ( ItemDto.RegisterItemOptionRequest registerItemOptionRequest : list ) {
            list1.add( of( registerItemOptionRequest ) );
        }

        return list1;
    }

    protected List<ItemDto.ItemOptionGroupDocument> itemOptionGroupDocumentListToItemOptionGroupDocumentList(List<ItemDocument.ItemOptionGroupDocument> list) {
        if ( list == null ) {
            return null;
        }

        List<ItemDto.ItemOptionGroupDocument> list1 = new ArrayList<ItemDto.ItemOptionGroupDocument>( list.size() );
        for ( ItemDocument.ItemOptionGroupDocument itemOptionGroupDocument : list ) {
            list1.add( of( itemOptionGroupDocument ) );
        }

        return list1;
    }

    protected List<ItemDto.ItemOptionDocument> itemOptionDocumentListToItemOptionDocumentList(List<ItemDocument.ItemOptionDocument> list) {
        if ( list == null ) {
            return null;
        }

        List<ItemDto.ItemOptionDocument> list1 = new ArrayList<ItemDto.ItemOptionDocument>( list.size() );
        for ( ItemDocument.ItemOptionDocument itemOptionDocument : list ) {
            list1.add( of( itemOptionDocument ) );
        }

        return list1;
    }
}
