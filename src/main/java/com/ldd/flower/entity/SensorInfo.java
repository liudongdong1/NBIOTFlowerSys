package com.ldd.flower.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author liudongdong
 * @Date Created in 9:50 2019/9/6
 * @Description
 */
@Entity
@Table(name = "sys_sensorinfo")
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class SensorInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long monitorid;
    private String type;
    private String info;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;

    @Override
    public String toString() {
        return "SensorInfo{" +
                "id=" + id +
                ", monitorid=" + monitorid +
                ", type='" + type + '\'' +
                ", info='" + info + '\'' +
                ", createdate=" + createdate +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMonitorid() {
        return monitorid;
    }

    public void setMonitorid(long monitorid) {
        this.monitorid = monitorid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}
