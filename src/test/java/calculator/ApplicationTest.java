package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    // 예외 입력 테스트
    @Test
    void 음수_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_외의_문자_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자_숫자_외의_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2 3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // 정상 입력 테스트
    @Test
    void 빈문자열_테스트() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 숫자_하나일때() {
        assertSimpleTest(() -> {
            run("3");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 콤마_구분자_테스트() {
        assertSimpleTest(() -> {
            run("1,3,5");
            assertThat(output()).contains("결과 : 9");
        });
    }

    @Test
    void 콜론_구분자_테스트() {
        assertSimpleTest(() -> {
            run("1:3:5");
            assertThat(output()).contains("결과 : 9");
        });
    }

    @Test
    void 혼합_구분자_테스트() {
        assertSimpleTest(() -> {
            run("1,3:5");
            assertThat(output()).contains("결과 : 9");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
