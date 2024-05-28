package com.vennygo.study;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("@DisplayName, @Disabled 어노테이션 테스트")
public class AnnotationTest {
    @DisplayName("메서드 설명")
    @Test
    void displayName() {
        assertEquals(2, 1+1);
    }

    @Disabled
    @Test
    void disabled() {
        assertEquals(3, 1+2);
    }
}
