package dev.practice.order.domain.partner;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PartnerInfo {
    private final Long identifier;
    private final String partnerToken;
    private final String partnerName;
    private final String businessNo;
    private final String email;
    private final Partner.Status status;

    public PartnerInfo(Partner partner) {
        this.identifier = partner.getId();
        this.partnerToken = partner.getPartnerToken();
        this.partnerName = partner.getPartnerName();
        this.businessNo = partner.getBusinessNo();
        this.email = partner.getEmail();
        this.status = partner.getStatus();
    }
}
