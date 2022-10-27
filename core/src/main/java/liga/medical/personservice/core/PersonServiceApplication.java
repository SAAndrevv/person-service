package liga.medical.personservice.core;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.io.InputStream;

@SpringBootApplication
/*@MapperScan("liga.medical.personservice.core.repository")*/
@ComponentScan(basePackages = {"liga.medical.personservice", "liga.medical.common.service"})
public class PersonServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonServiceApplication.class, args);
    }

    /*@Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }*/
}
