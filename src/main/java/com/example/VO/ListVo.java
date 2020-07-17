package com.example.VO;

import lombok.Data;

import java.util.List;
@Data
public class ListVo {
    private String title;
    private String number;
    List<DataVO> list;
}
