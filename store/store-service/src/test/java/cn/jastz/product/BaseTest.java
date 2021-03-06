package cn.jastz.product;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhiwen
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest<T> {
    @Autowired
    protected T service;

    protected String getAppId() {
        return "30b1b99af55f4936a6d03440b77b8cce";
    }
}
