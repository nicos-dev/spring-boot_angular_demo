package com.school.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Nicholas Dietz
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Demo {

    /**
     * ENTITY (Table in DB)
     *
     * with following properties:
     *  > id (Auto generated when saving new Demo-Object to DB)
     *  > sampleText
     *
     *  ____________________________________________________________
     *  Each Demo-Object saved to DB represents a row in Demo-Table.
     */

    @Id
    @GeneratedValue
    @Column(unique = true)
    private int id;

    private String sampleText;

}
