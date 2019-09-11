package com.ldd.flower.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author liudongdong
 * @Date Created in 9:02 2019/9/6
 * @Description
 */
@Entity
@Table(name = "sys_device")
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class Device implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String devicename;
    private String deviceurl;
    private String factory;
    private long price;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(columnDefinition = "text")     //添加属性修改后updata 并没有修改属性
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDevicename() {
        return devicename;
    }

    public void setDevicename(String devicename) {
        this.devicename = devicename;
    }

    public String getDeviceurl() {
        return deviceurl;
    }

    public void setDeviceurl(String deviceurl) {
        this.deviceurl = deviceurl;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    @Override
    public String toString() {
        return "device{" +
                "id=" + id +
                ", devicename='" + devicename + '\'' +
                ", deviceurl='" + deviceurl + '\'' +
                ", factory='" + factory + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", createdate=" + createdate +
                '}';
    }
}

