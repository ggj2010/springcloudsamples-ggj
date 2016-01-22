package com.ggj.dao;

import com.ggj.bean.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

/**
 * author:gaoguangjin
 * Description: Spring Data JPA 为此提供了一些表达条件查询的关键字
 * Email:335424093@qq.com
 * Date 2016/1/22 9:14
 */
public interface CityRepository extends Repository<City, Long> {
    City findByNameAndCountryAllIgnoringCase(String name, String country);

    //jpa 就当了解吧===
   /* @Query(name="from City a where a.name = :name")
     City findByAccountId(String  name);*/
}

/**
 * And --- 等价于 SQL 中的 and 关键字，比如 findByUsernameAndPassword(String user, Striang pwd)；
 Or --- 等价于 SQL 中的 or 关键字，比如 findByUsernameOrAddress(String user, String addr)；
 Between --- 等价于 SQL 中的 between 关键字，比如 findBySalaryBetween(int max, int min)；
 LessThan --- 等价于 SQL 中的 "<"，比如 findBySalaryLessThan(int max)；
 GreaterThan --- 等价于 SQL 中的">"，比如 findBySalaryGreaterThan(int min)；
 IsNull --- 等价于 SQL 中的 "is null"，比如 findByUsernameIsNull()；
 IsNotNull --- 等价于 SQL 中的 "is not null"，比如 findByUsernameIsNotNull()；
 NotNull --- 与 IsNotNull 等价；
 Like --- 等价于 SQL 中的 "like"，比如 findByUsernameLike(String user)；
 NotLike --- 等价于 SQL 中的 "not like"，比如 findByUsernameNotLike(String user)；
 OrderBy --- 等价于 SQL 中的 "order by"，比如 findByUsernameOrderBySalaryAsc(String user)；
 Not --- 等价于 SQL 中的 "！ ="，比如 findByUsernameNot(String user)；
 In --- 等价于 SQL 中的 "in"，比如 findByUsernameIn(Collection<String> userList) ，方法的参数可以是 Collection 类型，也可以是数组或者不定长参数；
 NotIn --- 等价于 SQL 中的 "not in"，比如 findByUsernameNotIn(Collection<String> userList) ，方法的参数可以是 Collection 类型，也可以是数组或者不定长参数；
 */

/**
 修改注解
  @Modifying
 @Query("update AccountInfo a set a.salary = ?1 where a.salary < ?2")


 */
