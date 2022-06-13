package com.example.shop.commons.model;

import java.io.Serializable;
import java.time.Instant;
import javax.persistence.*;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @CreatedDate @NotNull  private Instant createdDate = Instant.now();

  @LastModifiedDate @NotNull  private Instant lastModifiedDate = Instant.now();
}
