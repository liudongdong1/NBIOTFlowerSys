package com.ldd.flower.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author liudongdong
 * @Date Created in 9:44 2019/9/6
 * @Description
 */
@Entity
@Table(name = "sys_flower")
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class Flower implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String color;
    private String iconurl;
    private String type;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(columnDefinition = "text")     //添加属性修改后updata 并没有修改属性
    private String description;
    private String growperiod;
    private String waterperiod;
    private String cuttingperiod;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;

    @Override
    public String toString() {
        return "Flower{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", iconurl='" + iconurl + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", growperiod='" + growperiod + '\'' +
                ", waterperiod='" + waterperiod + '\'' +
                ", cuttingperiod='" + cuttingperiod + '\'' +
                ", createdate=" + createdate +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIconurl() {
        return iconurl;
    }

    public void setIconurl(String iconurl) {
        this.iconurl = iconurl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGrowperiod() {
        return growperiod;
    }

    public void setGrowperiod(String growperiod) {
        this.growperiod = growperiod;
    }

    public String getWaterperiod() {
        return waterperiod;
    }

    public void setWaterperiod(String waterperiod) {
        this.waterperiod = waterperiod;
    }

    public String getCuttingperiod() {
        return cuttingperiod;
    }

    public void setCuttingperiod(String cuttingperiod) {
        this.cuttingperiod = cuttingperiod;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}
