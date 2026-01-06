package pairmatching.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RetryTest {
    private PrintStream originalOut;
    private ByteArrayOutputStream out;

    @BeforeEach
    void setUp() {
        originalOut = System.out;
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void retryUntilSuccess_Supplier는_예외가_나면_메시지_출력_후_재시도한다() throws UnsupportedEncodingException {
        AtomicInteger count = new AtomicInteger();

        String result = Retry.retryUntilSuccess(() -> {
            if (count.getAndIncrement() == 0) {
                throw new IllegalArgumentException("[ERROR] TEST");
            }
            return "OK";
        });

        assertThat(result).isEqualTo("OK");
        assertThat(out.toString(String.valueOf(StandardCharsets.UTF_8))).contains("[ERROR] TEST");
    }

    @Test
    void retryUntilSuccess_Runnable은_예외가_나면_메시지_출력_후_재시도한다() throws UnsupportedEncodingException {
        AtomicInteger count = new AtomicInteger();

        Retry.retryUntilSuccess(() -> {
            if (count.getAndIncrement() == 0) {
                throw new IllegalArgumentException("[ERROR] RUN");
            }
        });

        assertThat(count.get()).isEqualTo(2);
        assertThat(out.toString(String.valueOf(StandardCharsets.UTF_8))).contains("[ERROR] RUN");
    }
}