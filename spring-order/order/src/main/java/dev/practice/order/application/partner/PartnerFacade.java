package dev.practice.order.application.partner;

import dev.practice.order.domain.notification.NotificatioService;
import dev.practice.order.domain.partner.PartnerCommand;
import dev.practice.order.domain.partner.PartnerInfo;
import dev.practice.order.domain.partner.PartnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PartnerFacade {
    private final PartnerService partnerService;
    private final NotificatioService notificationService;

    public PartnerInfo registerPartner(PartnerCommand command){
        // 아래서 partnerService.registerPartner()가 동일하게 나오는 이유는, Facade 패턴은 여러 기능을 묶어 실행하는 코드 단위의 MSA 패턴이기 때문이다.
        var partnerInfo = partnerService.registerPartner(command);
        notificationService.sendEmail(partnerInfo.getEmail(), "제휴사 등록을 환영합니다.", "제휴사 등록이 완료되었습니다.");
        return partnerInfo;
    }
}
