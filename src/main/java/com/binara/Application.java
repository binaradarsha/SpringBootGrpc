package com.binara;

import com.binara.controller.grpc.StudentController;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.IOException;

/**
 * Created by binara on 7/8/17.
 */
@SpringBootApplication
@EnableWebMvc
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        try {
            startGrpcServer();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void startGrpcServer() throws InterruptedException, IOException {
        Server server = ServerBuilder.forPort(8085)
                .addService(new StudentController())
                .build();
        server.start();
        server.awaitTermination();
    }
}
