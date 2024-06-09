package dev.practice.order.interfaces.partner;

import dev.practice.order.domain.partner.PartnerCommand;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-10T01:28:48+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class PartnerDtoMapperImpl implements PartnerDtoMapper {

    @Override
    public PartnerCommand of(PartnerDto.RegisterRequest request) {
        if ( request == null ) {
            return null;
        }

        PartnerCommand.PartnerCommandBuilder partnerCommand = PartnerCommand.builder();

        partnerCommand.partnerName( request.getPartnerName() );
        partnerCommand.businessNo( request.getBusinessNo() );
        partnerCommand.email( request.getEmail() );

        return partnerCommand.build();
    }
}
