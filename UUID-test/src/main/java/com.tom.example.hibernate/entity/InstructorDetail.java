package com.tom.example.hibernate.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "instructorDetail")
public class InstructorDetail {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "youtubeChannel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;


    public InstructorDetail() {

    }

    public InstructorDetail(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
