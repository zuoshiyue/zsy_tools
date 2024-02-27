package com.jx3.api_sdk;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class BaseTester {

    @Before
    @BeforeEach
    public void start() {
        System.out.println("单测启动......................");
    }

    @After
    @AfterEach
    public void end() {
        System.out.println("单测结束......................");
    }

}
