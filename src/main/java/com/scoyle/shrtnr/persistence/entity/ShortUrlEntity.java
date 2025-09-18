package com.scoyle.shrtnr.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

import java.util.Date;

@Data
@Entity
@Table(name = "ShortUrls")
public class ShortUrlEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String longUrl;

    @CreationTimestamp(source = SourceType.DB)
    private Date created;
}
