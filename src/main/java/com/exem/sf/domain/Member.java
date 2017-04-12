package com.exem.sf.domain;

import javax.persistence.*;

/**
 * Created by dev on 2017. 3. 21..
 */
@Entity
@Table(name="MEMBER")
public class Member
{
    @Id
    private Long id;
    private String name;
}