package com.southwind.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    //必须要有无参构造
    //因为spring无参反射
    private String address;
}
