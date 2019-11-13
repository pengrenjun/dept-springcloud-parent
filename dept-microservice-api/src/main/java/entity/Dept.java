package entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @Description: 部门实体 微服务公共的实体类需要实现序列化接口
 * @Author：pengrj
 * @Date : 2018/12/19 0019 23:08
 * @version:1.0
 */

@NoArgsConstructor
@Data
@Accessors(chain = true)
@ToString
public class Dept {

    // 主键
    private Long 	deptno;

    // 部门名称
    private String 	dname;

    /**
      *来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
      */
    private String 	db_source;



    public Dept(String dname, String db_source)
    {
        super();
        this.dname = dname;
        this.db_source=db_source;
    }


    public Long getDeptno() {
        return deptno;
    }

    public void setDeptno(Long deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDb_source() {
        return db_source;
    }

    public void setDb_source(String db_source) {
        this.db_source = db_source;
    }
}
