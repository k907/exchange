package com.kuzmenko.exchange.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "notification")
@Accessors(chain = true)
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "type")
    NotificationEnum notification;

    @Column(name = "content")
    String description;

    @Column(name = "user_id")
    Long userId;
}
