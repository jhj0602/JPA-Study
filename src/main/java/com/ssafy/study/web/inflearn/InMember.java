package com.ssafy.study.web.inflearn;

import com.ssafy.study.member.enitity.Member;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MBR")
public class InMember {

    //매핑 어노테이션

    @Id
    private Long id;

    @Column(name = "name")
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)//enum타입을 쓰고 싶다면 이걸 쓰자
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    
    @Lob//큰 콘텐츠
    private String description;

    @Transient//매핑 무시
    private int temp;

    public InMember(){}
}
