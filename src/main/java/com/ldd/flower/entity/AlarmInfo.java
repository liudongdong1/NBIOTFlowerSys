package com.ldd.flower.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author liudongdong
 * @Date Created in 9:35 2019/9/6
 * @Description
 */
@Entity
@Table(name = "sys_alarminfo")
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
/*@SequenceGenerator(name="sysalarminfo_id_seq", initialValue=1000, allocationSize=1)*/
public class AlarmInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long deviceId;

    private Integer state;
    private String alarminfo;
    private String elsepara;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;

    @Override
    public String toString() {
        return "AlarmInfo{" +
                "id=" + id +
                ", deviceId=" + deviceId +
                ", state=" + state +
                ", alarminfo='" + alarminfo + '\'' +
                ", elsepara='" + elsepara + '\'' +
                ", createdate=" + createdate +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDevices() {
        return deviceId;
    }

    public void setDevices(long deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getAlarminfo() {
        return alarminfo;
    }

    public void setAlarminfo(String alarminfo) {
        this.alarminfo = alarminfo;
    }

    public String getElsepara() {
        return elsepara;
    }

    public void setElsepara(String elsepara) {
        this.elsepara = elsepara;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}
