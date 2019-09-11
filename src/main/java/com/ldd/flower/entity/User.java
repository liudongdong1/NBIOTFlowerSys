package com.ldd.flower.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Currency;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author ldd
 * @createdate 2019/9/5
 * @function  用户的基本类
 * */

/**
 * @Entity注解，表明了这是一个Entity，可以使用默认的ORM规则，即class名即为要更新的数据表名
 * @Table注解，可以指定这个Entity要更新的数据表名，也不使用默认的ORM规则。
 * @Id注解，表明了这个数据表的主键ID，这个主键可以是AUTO_INCREMENT类型的数据。
 * */
@Entity
@Getter
@Setter
@Table(name="sys_user")
/**
 * @JsonIgnoreProperties：忽略Hibernate的延迟加载的一些属性"hibernateLazyInitializer", "handler", "fieldHandler"，这些属性在实体类里没有所以要忽略掉，否则转换为Json会报错。
 * */
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class User implements Serializable {
    /**
     * @Id注释指定表的主键，它可以有多种生成方式：
     * 　　1）TABLE：容器指定用底层的数据表确保唯一；
     * 　　2）SEQUENCE：使用数据库德SEQUENCE列莱保证唯一（Oracle数据库通过序列来生成唯一ID）；
     * 　　3）IDENTITY：使用数据库的IDENTITY列莱保证唯一；
     * 　　4）AUTO：由容器挑选一个合适的方式来保证唯一；
     * 　　5）NONE：容器不负责主键的生成，由程序来完成。@Id注释指定表的主键，它可以有多种生成方式：
     * 　　1）TABLE：容器指定用底层的数据表确保唯一；
     * 　　2）SEQUENCE：使用数据库德SEQUENCE列莱保证唯一（Oracle数据库通过序列来生成唯一ID）；
     * 　　3）IDENTITY：使用数据库的IDENTITY列莱保证唯一；
     * 　　4）AUTO：由容器挑选一个合适的方式来保证唯一；
     * 　　5）NONE：容器不负责主键的生成，由程序来完成。
     * */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    /**
     * @Column注释定义了将成员属性映射到关系表中的哪一列和该列的结构信息，属性如下：
     * 　　1）name：映射的列名。如：映射tbl_user表的name列，可以在name属性的上面或getName方法上面加入；
     * 　　2）unique：是否唯一；
     * 　　3）nullable：是否允许为空；
     * 　　4）length：对于字符型列，length属性指定列的最大字符长度；
     * 　　5）insertable：是否允许插入；
     * 　　6）updatetable：是否允许更新；
     * 　　7）columnDefinition：定义建表时创建此列的DDL；
     * 　　8）secondaryTable：从表名。如果此列不建在主表上（默认是主表），该属性定义该列所在从表的名字
     * */
    @Column(name ="username",nullable = false)
    private String username;
    @Column(name ="password",nullable = false)
    private String password;
    @Column(name = "salt")
    private String salt;
    @Column(name="role")
    private String role;
    @Column(name="tel")
    private String tel;
    @Column(name="address")
    private String address;
    @Column(name="description")
    private String description;
    @Column(name="url")
    private String url;
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date create_date;
    public String getCredentialsSalt() {
        return username + salt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", role='" + role + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", create_date=" + create_date +
                '}';
    }
}
