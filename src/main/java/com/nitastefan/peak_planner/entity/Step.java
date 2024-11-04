package com.nitastefan.peak_planner.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "step")
public class Step {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "duration")
    private String duration;

    @Column(name = "description")
    private String description;

    public Step() {
    }

    public Step(String duration, String description) {
        this.duration = duration;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Step{" +
                "id=" + id +
                ", duration='" + duration + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
