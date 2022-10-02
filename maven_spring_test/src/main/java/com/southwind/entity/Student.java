package com.southwind.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    //必须要有无参构造
    //因为spring无参反射
    private long id;
    private String name;
    private long age;
    private List<Address> addresses;
}
