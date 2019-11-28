package com.alex.dam.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Gate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private static String name;

    @Temporal(TemporalType.TIME)
    private static Date openTime;

    @Temporal(TemporalType.TIME)
    private static Date closeTime;

    private static Boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Gate.name = name;
    }

    public static Date getOpenTime() {
        return openTime;
    }

    public static void setOpenTime(Date openTime) {
        Gate.openTime = openTime;
    }

    public static Date getCloseTime() {
        return closeTime;
    }

    public static void setCloseTime(Date closeTime) {
        Gate.closeTime = closeTime;
    }

    public static Boolean getStatus() {
        return status;
    }

    public static void setStatus(Boolean status) {
        Gate.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gate gate = (Gate) o;
        return id.equals(gate.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
