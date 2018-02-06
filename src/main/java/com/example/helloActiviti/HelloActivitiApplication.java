package com.example.helloActiviti;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class HelloActivitiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloActivitiApplication.class, args);
	}

   /* @Bean
    InitializingBean usersAndGroupsInitializer(final IdentityService identityService) {

        return new InitializingBean() {

            public void afterPropertiesSet() throws Exception {

                Group group = identityService.newGroup("user");
                group.setName("users");
                group.setType("security-role");
                identityService.saveGroup(group);

                User admin = identityService.newUser("admin");
                admin.setPassword("admin");
                identityService.saveUser(admin);

                Group group1 = identityService.newGroup("tester");
                group1.setName("tester");
                group1.setType("security-role");
                identityService.saveGroup(group1);

                Group group2 = identityService.newGroup("gisdriver");
                group2.setName("gisdriver");
                group2.setType("security-role");
                identityService.saveGroup(group2);

                User admin1 = identityService.newUser("gisdriver");
                admin1.setPassword("test");
                identityService.saveUser(admin1);

                User admin2 = identityService.newUser("tester");
                admin2.setPassword("test");
                identityService.saveUser(admin2);

                identityService.createMembership("gisdriver","gisdriver");
                identityService.createMembership("tester","tester");

            }
        };
    }*/
}
