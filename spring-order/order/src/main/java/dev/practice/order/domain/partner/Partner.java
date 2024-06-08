package dev.practice.order.domain.partner;

import dev.practice.order.common.util.TokenGenerator;
import dev.practice.order.domain.AbstractEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter //→ Entity 에선 내부 프로퍼티를 외부에서 건드릴 수 없게 Setter 는 추가하지 말라
@Entity
@NoArgsConstructor //→ Spring JPA 사용 시 전제되는 기본 생성자
@Table(name = "partners")
public class Partner extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String partnerToken;
    private String partnerName;
    private String businessNo;
    private String email;

    @Enumerated(EnumType.STRING) //→ DB 저장 시 Enum Name 그대로 저장됨
    private Status status;

    @Getter
    @RequiredArgsConstructor
    public enum Status {
        ENABLE("활성화"), DISABLE("비활성화");
        private final String description;
    }

    @Builder //→ 파라미터에 명시적으로 값을 설정할 수 있음
    public Partner(String partnerName, String businessNo, String email) {
        //API 호출 단에서 Try-Catch 가 가능토록 한다
        if(partnerName.isEmpty()) throw new RuntimeException("empty partnerName");
        if(businessNo.isEmpty()) throw new RuntimeException("empty businessNo");
        if(email.isEmpty()) throw new RuntimeException("empty email");

        this.partnerToken = TokenGenerator.randomCharacter();

        this.partnerName = partnerName;
        this.businessNo = businessNo;
        this.email = email;

        this.status = Status.ENABLE; // 승인 기능이 없으므로 일단 활성화
    }

    public void enable() {
        this.status = Status.ENABLE;
    }

    public void disable() {
        this.status = Status.DISABLE;
    }
}
