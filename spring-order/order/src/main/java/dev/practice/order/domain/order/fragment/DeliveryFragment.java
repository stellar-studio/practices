package dev.practice.order.domain.order.fragment;

import dev.practice.order.common.exception.InvalidParamException;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.Embeddable;

@Getter
@Embeddable
@NoArgsConstructor
public class DeliveryFragment {
    private String receiverName;
    private String receiverPhone;
    private String receiverZipcode;
    private String receiverAddress1;
    private String receiverAddress2;
    private String etcMessage;

    @Builder
    public DeliveryFragment(
            String receiverName,
            String receiverPhone,
            String receiverZipcode,
            String receiverAddress1,
            String receiverAddress2,
            String etcMessage
    ) {
        if (receiverName.isEmpty()) throw new InvalidParamException("DeliveryFragment receiverName");
        if (receiverPhone.isEmpty()) throw new InvalidParamException("DeliveryFragment receiverPhone");
        if (receiverZipcode.isEmpty()) throw new InvalidParamException("DeliveryFragment receiverZipcode");
        if (receiverAddress1.isEmpty()) throw new InvalidParamException("DeliveryFragment receiverAddress1");
        if (receiverAddress2.isEmpty()) throw new InvalidParamException("DeliveryFragment receiverAddress2");
        if (etcMessage.isEmpty()) throw new InvalidParamException("DeliveryFragment etcMessage");
        
        this.receiverName = receiverName; 
        this.receiverPhone = receiverPhone; 
        this.receiverZipcode = receiverZipcode; 
        this.receiverAddress1 = receiverAddress1; 
        this.receiverAddress2 = receiverAddress2; 
        this.etcMessage = etcMessage; 
    }
}
