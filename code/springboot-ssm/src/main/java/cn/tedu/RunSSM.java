package cn.tedu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.tedu.mapper")
public class RunSSM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
SpringApplication.run(RunSSM.class, args);
	}

}
