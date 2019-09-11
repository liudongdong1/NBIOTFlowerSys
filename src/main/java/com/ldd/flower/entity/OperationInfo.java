package com.ldd.flower.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author liudongdong
 * @Date Created in 9:09 2019/9/6
 * @Description
 */
@Entity
@Table(name = "sys_operationinfo")
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class OperationInfo  implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    /**
     * Todo  级联删除
     * @Cascade()
     * */
  /*  @OneToOne(cascade=CascadeType.ALL)//People是关系的维护端，当删除 people，会级联删除 address
    @JoinColumn(name = "deviceid", referencedColumnName = "id")//people中的address_id字段参考address表中的id字段*/
    private long deviceid;

    /**
     * Todo
     * 级联删除
     * */
    private long userid;
    private String operatereasion;
    private String operateinfo;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;

    @Override
    public String toString() {
        return "OperationInfo{" +
                "id=" + id +
                ", deviceid=" + deviceid +
                ", userid=" + userid +
                ", operatereasion='" + operatereasion + '\'' +
                ", operateinfo='" + operateinfo + '\'' +
                ", createdate=" + createdate +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(long deviceid) {
        this.deviceid = deviceid;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getOperatereasion() {
        return operatereasion;
    }

    public void setOperatereasion(String operatereasion) {
        this.operatereasion = operatereasion;
    }

    public String getOperateinfo() {
        return operateinfo;
    }

    public void setOperateinfo(String operateinfo) {
        this.operateinfo = operateinfo;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}
