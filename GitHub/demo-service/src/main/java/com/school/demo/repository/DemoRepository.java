package com.school.demo.repository;

import com.school.demo.entity.Demo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Nicholas Dietz
 */

public interface DemoRepository extends CrudRepository<Demo, Integer> {

    /**
     * Repository used to manage data in Demo-Table in DB.
     *  > Already contains basic methods, such as:
     *      findAll()
     *      save()
     *      delete()
     *      ...
     *  > Custom methods can be added:
     *      findBySampleText()
     *      ... https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
     */

    List<Demo> findBySampleText(String text);

}
