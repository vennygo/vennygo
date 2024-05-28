package com.vennygo.study;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringTest {

    @Test
    void substring() {
        String str = "abcde";
        assertEquals("cd", str.substring(2, 4));
    }

    @Test
    void assertThrows() {
        // 발생한 익셉션을 이용해서 추가로 검증이 필요할 경우 assertThrows() 메서드가 리턴한 익셉션 객체를 사용
        /*IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
            () -> {
                AuthService authService = AuthService();
                authService.authenticate(null, null);
        });
        assertTrue(thrown.getMessage().contains("id"));*/
    }
}
