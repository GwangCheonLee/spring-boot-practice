package com.example.springbootpractice.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class JpaConfig {

    /*
     * JpaConfig 클래스는 Spring Data JPA의 Auditing 기능을 활성화하기 위한 설정 클래스입니다.
     *
     * - @EnableJpaAuditing: Spring Data JPA의 Auditing 기능을 활성화하는 어노테이션입니다.
     *   이를 통해 엔티티 클래스에서 @CreatedDate, @LastModifiedDate 등의 어노테이션을 사용할 수 있게 됩니다.
     *   이 기능을 통해 엔티티가 생성되거나 수정될 때, 해당 타임스탬프 필드가 자동으로 업데이트됩니다.
     *
     */
}
