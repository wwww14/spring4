package com.ywx.core.orm.hibernate;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;

/**
 * 封装Hibernate原生API的DAO泛型基类. <br>
 * 可在Service层直接使用,也可以扩展泛型DAO子类使用
 * 
 * @param <T>
 *            DAO操作的对象类型
 */
public interface SimpleHibernateDao<T> {
	
	/**
	 * 保存新增的对象.
	 */
	public Object save(final T entity);

	/**
	 * 保存新增或修改的对象.
	 */
	public void saveOrUpdate(final T entity);

	/**
	 * 修改的对象.
	 */
	public void update(final T entity);

	/**
	 * 删除对象.
	 * 
	 * @param entity
	 *            对象必须是session中的对象或含id属性的transient对象.
	 */
	public void delete(final T entity);

	/**
	 * 按id删除对象.
	 * 
	 * @param id
	 */
	public void deleteById(final Object id);

	/**
	 * 按id获取对象,使用load方式.
	 * 
	 * @param id
	 *            主键
	 * @return
	 */
	public T get(final Object id);

	/**
	 * 按id获取对象，根据参数决定使用get方式还是load方式.
	 * 
	 * @param id
	 *            主键
	 * @param isUsedGet
	 *            isUsedGet true：get方式；false：load方式
	 * @return
	 */
	public T get(final Object id, final Boolean isUsedGet);

	/**
	 * 获取全部对象.
	 * 
	 * @return
	 */
	public List<T> getAll();

	/**
	 * 获取全部对象,支持排序.
	 * 
	 * @param orderBy
	 *            排序字段
	 * @param isAsc
	 *            true：升序；false：降序
	 * @return
	 */
	public List<T> getAll(String orderBy, boolean isAsc);

	/**
	 * 按属性查找对象列表,匹配方式为相等.
	 * 
	 * @param propertyName
	 *            属性
	 * @param value
	 *            属性值
	 * @return 查询结果
	 */
	public List<T> findBy(final String propertyName, final Object value);

	/**
	 * 按属性查找对象列表,匹配方式为相等.
	 * 
	 * @param propertyName
	 *            属性
	 * @param value
	 *            属性值
	 * @param propertyName1
	 *            属性1
	 * @param value1
	 *            属性1值
	 * @return 查询结果
	 */
	public List<T> findBy(final String propertyName, final Object value, final String propertyName1, final Object value1);

	/**
	 * 按属性查找对象列表,匹配方式为相等.<br>
	 * 
	 * @param propertyName
	 *            属性
	 * @param value
	 *            属性值
	 * @param orderBy
	 *            排序字段
	 * @param isAsc
	 *            支持排序：true-升序,false-降序.
	 * @return 查询结果
	 */
	public List<T> findByAndOrder(final String propertyName, final Object value, final String orderBy, final boolean isAsc);

	/**
	 * 按属性查找对象列表,匹配方式为相等.<br>
	 * 
	 * @param propertyName
	 *            属性
	 * @param value
	 *            属性值
	 * @param propertyName1
	 *            属性1
	 * @param value1
	 *            属性值1
	 * @param orderBy
	 *            排序字段
	 * @param isAsc
	 *            支持排序：true-升序,false-降序.
	 * @return
	 */
	public List<T> findByAndOrder(final String propertyName, final Object value, final String propertyName1, final Object value1, final String orderBy, final boolean isAsc);

	/**
	 * 按属性查找唯一对象,匹配方式为相等.
	 */
	public T findUniqueBy(final String propertyName, final Object value);

	/**
	 * 按属性查找唯一对象,匹配方式为相等.
	 */
	public T findUniqueBy(final String propertyName, final Object value, final String propertyName1, final Object value1);

	/**
	 * 按id获取对象列表.
	 */
	public List<T> findByIds(List<Object> ids);

	/**
	 * 按HQL查询对象列表.
	 * 
	 * @param values
	 *            数量可变的参数,按顺序绑定.
	 */
	public <X> List<X> find(final String hql, final Object... values);

	/**
	 * 按HQL查询对象列表.
	 * 
	 * @param values
	 *            命名参数,按名称绑定.
	 */
	public <X> List<X> find(final String hql, final Map<String, ?> values);

	/**
	 * 按HQL查询唯一对象.
	 * 
	 * @param values
	 *            数量可变的参数,按顺序绑定.
	 */
	public <X> X findUnique(final String hql, final Object... values);

	/**
	 * 按HQL查询唯一对象.
	 * 
	 * @param values
	 *            命名参数,按名称绑定.
	 */
	public <X> X findUnique(final String hql, final Map<String, ?> values);

	/**
	 * 执行HQL进行批量修改/删除操作.
	 * 
	 * @return 更新记录数.
	 */
	public int batchExecute(final String hql, final Object... values);

	/**
	 * 执行HQL进行批量修改/删除操作.
	 * 
	 * @return 更新记录数.
	 */
	public int batchExecute(final String hql, final Map<String, ?> values);

	/**
	 * 根据查询HQL与参数列表创建Query对象.
	 * 
	 * 本类封装的find()函数全部默认返回对象类型为T,当不为T时使用本函数.
	 * 
	 * @param values
	 *            数量可变的参数,按顺序绑定.
	 * @return
	 */
	public Query createQuery(final String queryString, final Object... values);

	/**
	 * 根据查询HQL与参数列表创建Query对象.
	 * 
	 * @param @param values 命名参数,按名称绑定.
	 */
	public Query createQuery(final String queryString, final Map<String, ?> values);

	// /**
	// * 按Criteria查询对象列表.
	// *
	// * @param criterions 数量可变的Criterion.
	// */
	// public List<T> find(final Criterion... criterions);

	/**
	 * 按Criteria查询对象列表.
	 * 
	 * @param criterions
	 *            数量可变的Criterion.
	 */
	public List<T> find(final Set<String> refNames, final Map<String, String> orderMap, final Criterion... criterions);

	/**
	 * 按Criteria查询唯一对象.
	 * 
	 * @param criterions
	 *            数量可变的Criterion.
	 */
	public T findUnique(final Criterion... criterions);

	/**
	 * 根据Criterion条件创建Criteria.
	 * 
	 * 本类封装的find()函数全部默认返回对象类型为T,当不为T时使用本函数.
	 * 
	 * @param criterions
	 *            数量可变的Criterion.
	 */
	public Criteria createCriteria(final Set<String> refNames, Map<String, String> orderMap, final Criterion... criterions);

	/**
	 * 根据Criterion条件创建Criteria.
	 * 
	 * 本类封装的find()函数全部默认返回对象类型为T,当不为T时使用本函数.
	 * 
	 * @param criterions
	 *            数量可变的Criterion.
	 */
	public Criteria createCriteria(final Criterion... criterions);

	/**
	 * 初始化对象. 使用load()方法得到的仅是对象Proxy, 在传到View层前需要进行初始化.
	 * 只初始化entity的直接属性,但不会初始化延迟加载的关联集合和属性. 如需初始化关联属性,可实现新的函数,执行:
	 * Hibernate.initialize(user.getRoles())，初始化User的直接属性和关联集合.
	 * Hibernate.initialize
	 * (user.getDescription())，初始化User的直接属性和延迟加载的Description属性.
	 */
	public void initEntity(T entity);

	/**
	 * @see #initEntity(Object)
	 */
	public void initEntity(List<T> entityList);

	/**
	 * Flush当前Session.
	 */
	public void flush();

	/**
	 * 为Query添加distinct transformer.
	 */
	public Query distinct(Query query);

	/**
	 * 为Criteria添加distinct transformer.
	 */
	public Criteria distinct(Criteria criteria);

	/**
	 * 取得对象的主键名.
	 */
	public String getIdName();

}
