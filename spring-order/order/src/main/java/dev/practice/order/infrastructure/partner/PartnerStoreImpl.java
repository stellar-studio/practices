package dev.practice.order.infrastructure.partner;

import dev.practice.order.common.exception.InvalidParamException;
import dev.practice.order.domain.partner.Partner;
import dev.practice.order.domain.partner.PartnerStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Slf4j
@Component
@RequiredArgsConstructor
public class PartnerStoreImpl implements PartnerStore {
    private final PartnerRepository partnerRepository;

    @Override
    public Partner store(Partner partner) {
        if (partner.getPartnerToken().isEmpty()) throw new InvalidParamException("partner.getPartnerToken()");
        if (partner.getPartnerName().isEmpty()) throw new InvalidParamException("partner.getPartnerName()");
        if (partner.getBusinessNo().isEmpty()) throw new InvalidParamException("partner.getBusinessNo()");
        if (partner.getEmail().isEmpty()) throw new InvalidParamException("partner.getEmail()");
        if (partner.getStatus() == null) throw new InvalidParamException("partner.getStatus()");

        //PartnerRepository 가 JpaRepository 를 implement 하고있다. save 는 JpaRepository 메서드다.
        return partnerRepository.save(partner);
    }
}
