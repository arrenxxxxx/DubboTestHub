package io.arrenxxxxx.dubbotesthub.api;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Hello response domain
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HelloResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String greeting;
    private Date timestamp;
    private boolean success;
    private String message;
}