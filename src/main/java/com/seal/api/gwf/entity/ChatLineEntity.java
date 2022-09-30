package com.seal.api.gwf.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ChatLine")
public class ChatLineEntity {

    @Id
    @Column(name = "LineID")
    private int lineID;

    @Column(name = "ChatID")
    private int chatID;

    @Column(name = "CreatedByID")
    private int createdByID;

    @Column(name = "CreatedTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;

    @Column(name = "Message")
    private String message;


}
