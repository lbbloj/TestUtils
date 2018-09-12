package com.hzwq.testng;

import org.mockito.MockitoAnnotations;

public class MockTestBase {
    public MockTestBase() {
        MockitoAnnotations.initMocks(this);
    }
}