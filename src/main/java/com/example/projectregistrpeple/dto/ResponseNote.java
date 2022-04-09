package com.example.projectregistrpeple.dto;


import lombok.Data;
import lombok.experimental.Accessors;

@Accessors
@Data
public class ResponseNote {

    String product;
    String price;
    String description;
    String flag;

}
