package com.ll.chat_ai.global.jpa;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.*;
import static lombok.AccessLevel.PROTECTED;

// @MappedSuperclass
// 부모 클래스에 선언하여 공통 필드나 매핑 정보를 하위 엔티티에서 상속받도록 설정
// 선언된 클래스는 데이터베이스 테이블과 직접 매핑되지 않고,
// 이를 상속받는 하위 클래스가 실제 엔티티가 되고,
// 부모 클래스의 필드가 하위 클래스의 테이블에 포함

// @SuperBuilder
// 상속 구조에서 부모 클래스와 자식 클래스의 필드를 모두 포함한 Builder를 생성할 때 사용
// JPA 엔티티에서 Builder 패턴을 사용하려면 기본 생성자와 AllArgsConstructor를 함께 사용해야 합니다.

// @EntityListeners(AuditingEntityListener.class)
// 엔티티의 변경 사항(생성/수정 등)을 감지하여 특정 작업을 수행할 수 있도록 합니다.
// AuditingEntityListener는 스프링 데이터 JPA의 Auditing 기능을 활성화

// @ToString
// 클래스의 모든 필드에 대해 toString() 메서드를 자동으로 생성
// 주의: 연관 관계가 있는 엔티티 필드(특히 양방향 관계)는 무한 순환 참조를 유발할 수 있으므로 제외하는 것이 좋습니다.

// @EqualsAndHashCode
// equals()와 hashCode() 메서드를 자동 생성
// 특정 필드만 비교하려면 @EqualsAndHashCode.Include나 @EqualsAndHashCode.Exclude를 사용
@MappedSuperclass
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PROTECTED)
@Getter
@SuperBuilder
@EntityListeners(AuditingEntityListener.class)
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BaseEntity {
    // GenerationType
    // 엔티티의 기본 키(primary key) 값이 어떻게 생성될지에 대한 전략을 지정하는 열거형
    // IDENTITY: 기본 키 생성을 데이터베이스에 위임
    // SEQUENCE: 데이터베이스의 시퀀스를 사용하여 기본 키 생성
    // TABLE: 키 생성 테이블을 사용하여 기본 키 생성
    // AUTO: 데이터베이스 벤더에 따라 IDENTITY, SEQUENCE, TABLE 중 하나를 자동으로 선택
    // NONE: 기본 키 생성을 하지 않음
    // UUID: UUID를 사용하여 기본 키 생성

    @Id @GeneratedValue(strategy = IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @CreatedDate
    @Getter
    private LocalDateTime createDate;

    @LastModifiedDate
    @Getter
    private LocalDateTime modifyDate;
}
