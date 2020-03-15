package com.mt.server;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * author: liqm
 * 2020-03-15
 */
@Data
@AllArgsConstructor
@ToString
public class User implements Serializable {


    private String username;
}
