This project is created by ApplicationPower. [ApplicationPower地址](https://gitee.com/sunyurepository/ApplicationPower)

# 项目说明
  一个使用ApplicationPower脚手架创建的springboot多数据源demo，不管有多少个数据源ApplicationPower
  都可以帮你创建一个mybatis多数据源并且集成atomikos分布式事务，方便控制分布式环境下的事务一致性。
  减少那些繁琐的配置工作。同时屏蔽了一些因为不小信息配置错误导致项目出问题无法正常工作
# 创建重要过程说明
  1. 自动为您创建DataSourceKey并把数据源添加到其中
  ```
  /**
   * 数据源常量
   */
  public class DataSourceKey {

      /** 数据库源one*/
      public static final String ONE= "one";

      /** 数据库源two*/
      public static final String TWO= "two";


  }
  ```
  2. 默认给你dao或者mapper注入第一个数据源,后续自己修改为其他数据源

  ```
  @TargetDataSource(DataSourceKey.ONE)
  public interface StudentOneDao {

  	/**
  	 * 保存数据
  	 * @param entity
  	 * @return
       */
  	int save(Student entity);
  }
  ```

  3. 自动创建多数据源的yml配置文件
  ```
  spring:
    #profiles : dev
    datasource:
      type: com.alibaba.druid.pool.DruidDataSource
      druid:
        one:
          url: jdbc:mysql://localhost:3306/project_boot?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false
          username: root
          password: root
          driver-class-name: com.mysql.cj.jdbc.Driver
          minIdle: 1
          maxActive: 2
          initialSize: 1
          timeBetweenEvictionRunsMillis: 3000
          minEvictableIdleTimeMillis: 300000
          validationQuery: SELECT 'ZTM' FROM DUAL
          validationQueryTimeout: 10000
          testWhileIdle: true
          testOnBorrow: false
          testOnReturn: false
          maxWait: 60000
          # 打开PSCache，并且指定每个连接上PSCache的大小
          poolPreparedStatements: true
          maxPoolPreparedStatementPerConnectionSize: 20
          filters: stat,wall,log4j2
        two:
          url: jdbc:mysql://localhost:3306/springlearn?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=false
          username: root
          password: root
          driver-class-name: com.mysql.cj.jdbc.Driver
          minIdle: 1
          maxActive: 2
          initialSize: 1
          timeBetweenEvictionRunsMillis: 3000
          minEvictableIdleTimeMillis: 300000
          validationQuery: SELECT 'ZTM' FROM DUAL
          validationQueryTimeout: 10000
          testWhileIdle: true
          testOnBorrow: false
          testOnReturn: false
          maxWait: 60000
          # 打开PSCache，并且指定每个连接上PSCache的大小
          poolPreparedStatements: true
          maxPoolPreparedStatementPerConnectionSize: 20
          filters: stat,wall,log4j2
  ```
  4. 事务的控制
  ```
  @Transactional
  	@Override
  	public CommonResult save(Student entity) {
  		CommonResult result = new CommonResult();
          try {
            //同时往不同的数据库插入数据
          	studentOneDao.save(entity);
          	studentTwoDao.save(entity);
          	int a = 10/0;
          	result.setSuccess(true);
          } catch (Exception e) {
          	result.setMessage("添加数据失败");
          	logger.error("StudentService添加数据异常：",e);
          	throw new RuntimeException("添加数据失败");
          }
          return result;
  	}
  ```
  # 重点
  ApplicationPower项目致力于解决项目初期的架构问题，让你在5分钟以内便能快速的创建出一个springmvc或者是springboot的we项目，
  做到创建后开箱即可正确运行，解决创建项目中的一些配置问题。如果你喜欢，那就star吧，你的支持将是ApplicationPower不断完善和持续推进的动力。