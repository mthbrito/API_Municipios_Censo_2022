package brito.api_municipios_censo_2022;

import brito.api_municipios_censo_2022.repository.MunicipioRepository;
import brito.api_municipios_censo_2022.service.MunicipioService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ApiMunicipiosCenso2022Application {

    public static void main(String[] args) {
        ApplicationContext context =SpringApplication.run(ApiMunicipiosCenso2022Application.class, args);
        MunicipioService service = context.getBean(MunicipioService.class);
//        System.out.println(service.getGeomById("1"));
    }

}
