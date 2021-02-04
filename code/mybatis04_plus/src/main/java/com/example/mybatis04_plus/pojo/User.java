package com.example.mybatis04_plus.pojo;

import lombok.Data;

@Data//lombok会为User生成set,get
//从网上下载代码，如果发现实体类没有set(),get(),加了@data,
//说明项目用了lombok
public class User {
	Integer userId;
}
