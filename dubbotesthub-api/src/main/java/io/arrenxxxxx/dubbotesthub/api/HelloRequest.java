package io.arrenxxxxx.dubbotesthub.api;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Hello request domain
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HelloRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private Integer age;
    private String message;
}