import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JFrameClassTest {

    @Test
    void TestIfKeyIsCorrectAfterChanges(){
        String keyBefore = "46936582098914733154614229018642";
        String keyExpected = "42860129426154317314890982659346";

        MethodKeyChange keyChange = new MethodKeyChange(keyBefore);
        String keyafterChanges = keyChange.getStringKeyAfter();

        Assertions.assertEquals(keyafterChanges,keyExpected);


    }
}
