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
@Table(name = "Chat")
public class ChatEntity {
    @Id
    @Column(name = "ChatID")
    private int chatID;

    @Column(name = "AccountID")
    private int accountID;

    @Column(name = "CreatedTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;

    @Column(name = "CreatedByID")
    private int createdByID;

    @Column(name = "RepByID")
    private int repByID;

}
