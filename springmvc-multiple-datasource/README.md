This project is created by ApplicationPower. [ApplicationPower地址](https://gitee.com/sunyurepository/ApplicationPower)

# 项目说明
  一个使用ApplicationPower脚手架创建的SpringMvc多数据源demo，不管有多少个数据源ApplicationPower
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

  3. 自动创建多数据源的mybatis配置文件
  ```
    <!-- 配置第一个数据源 -->
     <bean id="dataSourceOne" parent="abstractXADataSource">
         <!-- value只要两个数据源不同就行，随便取名 -->
         <property name="uniqueResourceName" value="mysql/sitestone" />
         <property name="xaDataSourceClassName" value="com.alibaba.druid.pool.xa.DruidXADataSource" />
         <property name="xaProperties">
             <props>
                 <prop key="url">${jdbc.one.url}</prop>
                 <prop key="password">${jdbc.one.password}</prop>
                 <prop key="username">${jdbc.one.username}</prop>   <!-- durid -->
                 <prop key="initialSize">0</prop>
                 <prop key="maxActive">20</prop>
                 <prop key="minIdle">0</prop>
                 <prop key="maxWait">6000</prop>
                 <prop key="validationQuery">SELECT 'x'</prop>
                 <prop key="testOnBorrow">false</prop>
                 <prop key="testOnReturn">false</prop>
                 <prop key="testWhileIdle">true</prop>
                 <prop key="removeAbandoned">true</prop>
                 <prop key="removeAbandonedTimeout">1800</prop>
                 <prop key="logAbandoned">true</prop>
                 <prop key="filters">stat,log4j2</prop>
             </props>
         </property>
     </bean>

     <!-- 配置第二个数据源-->
     <bean id="dataSourceTwo" parent="abstractXADataSource">
         <!-- value只要两个数据源不同就行，随便取名 -->
         <property name="uniqueResourceName" value="mysql/sitesttwo" />
         <property name="xaDataSourceClassName" value="com.alibaba.druid.pool.xa.DruidXADataSource" />
         <property name="xaProperties">
             <props>
                 <prop key="url">${jdbc.two.url}</prop>
                 <prop key="password">${jdbc.two.password}</prop>
                 <prop key="username">${jdbc.two.username}</prop>
                 <prop key="initialSize">0</prop>
                 <prop key="maxActive">20</prop>
                 <prop key="minIdle">0</prop>
                 <prop key="maxWait">60000</prop>
                 <prop key="validationQuery">SELECT 'x'</prop>
                 <prop key="testOnBorrow">false</prop>
                 <prop key="testOnReturn">false</prop>
                 <prop key="testWhileIdle">true</prop>
                 <prop key="removeAbandoned">true</prop>
                 <prop key="removeAbandonedTimeout">1800</prop>
                 <prop key="logAbandoned">true</prop>
                 <prop key="filters">stat,log4j2</prop>
             </props>
         </property>
     </bean>
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