package com.pch.common.po;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author uo712
 * @version 1.0
 * @since 2017/1/9
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    private static final long serialVersionUID = -4743363790685901665L;
    private String id;
    private String cDate;
    private String cTime;

    public BaseEntity() {
    }

    public BaseEntity(String cDate, String cTime) {
        this.cDate = cDate;
        this.cTime = cTime;
    }

    public BaseEntity(String id, String cDate, String cTime) {
        this.id = id;
        this.cDate = cDate;
        this.cTime = cTime;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Id
    @Column(length = 36)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(length = 10, nullable = false)
    public String getcDate() {
        return cDate;
    }

    public void setcDate(String cDate) {
        this.cDate = cDate;
    }

    @Column(length = 6, nullable = false)
    public String getcTime() {
        return cTime;
    }

    public void setcTime(String cTime) {
        this.cTime = cTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseEntity that = (BaseEntity) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id='" + id + '\'' +
                ", cDate='" + cDate + '\'' +
                ", cTime='" + cTime + '\'' +
                '}';
    }
}
