package com.example.authorbookee.model;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    private int id;
    private String title;
    private Author author;
    private double price;
    private int qty;
    private Date createdAt;

}