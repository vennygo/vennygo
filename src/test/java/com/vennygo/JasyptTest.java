package com.vennygo;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.jasypt.iv.RandomIvGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class JasyptTest {

    private StringEncryptor encryptor;

    @BeforeEach
    void setUp() {
        encryptor = createStringEncryptor();
    }

    @Test
    void jasypt() {
        String value = "vennygo"; // 암호화할 값

        String encryptedText = encryptor.encrypt(value);
        String decryptedText = encryptor.decrypt(encryptedText);

        System.out.println(encryptedText);

        assertThat(value).isEqualTo(decryptedText);
    }

    private StringEncryptor createStringEncryptor() {
        // 외부에 노출되면 안되는 나만의 비밀키 값, VM options에 설정
        // -Djasypt.encryptor.password=비밀키값
        String encryptKey = System.getProperty("jasypt.encryptor.password");

        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(encryptKey); // 암호화/복호화에 사용할 비밀키를 설정
        config.setAlgorithm("PBEWithHMACSHA512AndAES_256"); // 사용할 알고리즘 설정
        config.setPoolSize("1"); // 암호화/복호화에 사용할 스레드 풀 크기 설정, 단일 스레드를 사용하므로 "1"로 설정
        config.setStringOutputType("base64"); // 암호화된 문자열을 표현할 출력 형식 설정
        config.setKeyObtentionIterations("1000"); // 키를 생성하기 위해 알고리즘에 적용할 반복 횟수 지정, 이 값이 높을 수록 암호화된 문자열의 안전성이 높아짐
        config.setIvGenerator(new RandomIvGenerator()); // Initial Vector (IV) 생성기를 설정합니다. IV는 암호화된 텍스트의 초기 값을 결정하는데 사용되며, 보안을 위해 암호화마다 다른 값을 사용해야 합니다.
        encryptor.setConfig(config);
        return encryptor;
    }
}