import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import com.google.gson.*;

class MainTest {

    @Test
    void TEST_isPrint()
    {

        String json = "{\"TestPoints\":[{\"taskId\":1,\"x\":1,\"y\":1,\"expected\":true},{\"taskId\":1,\"x\":3,\"y\":4,\"expected\":true},{\"taskId\":1,\"x\":5,\"y\":6,\"expected\":true},{\"taskId\":1,\"x\":7,\"y\":7,\"expected\":true},{\"taskId\":2,\"x\":1,\"y\":6,\"expected\":true},{\"taskId\":2,\"x\":3,\"y\":2,\"expected\":false},{\"taskId\":2,\"x\":5,\"y\":2,\"expected\":false},{\"taskId\":2,\"x\":7,\"y\":1,\"expected\":true},{\"taskId\":3,\"x\":1,\"y\":5,\"expected\":true},{\"taskId\":3,\"x\":5,\"y\":1,\"expected\":true},{\"taskId\":3,\"x\":5,\"y\":3,\"expected\":true},{\"taskId\":3,\"x\":6,\"y\":6,\"expected\":false},{\"taskId\":4,\"x\":1,\"y\":6,\"expected\":true},{\"taskId\":4,\"x\":6,\"y\":6,\"expected\":true},{\"taskId\":4,\"x\":1,\"y\":8,\"expected\":true},{\"taskId\":4,\"x\":3,\"y\":1,\"expected\":false},{\"taskId\":4,\"x\":2,\"y\":7,\"expected\":true},{\"taskId\":5,\"x\":7,\"y\":5,\"expected\":true},{\"taskId\":5,\"x\":5,\"y\":7,\"expected\":true},{\"taskId\":5,\"x\":3,\"y\":3,\"expected\":false},{\"taskId\":5,\"x\":6,\"y\":6,\"expected\":false},{\"taskId\":5,\"x\":6,\"y\":2,\"expected\":true},{\"taskId\":6,\"x\":1,\"y\":8,\"expected\":true},{\"taskId\":6,\"x\":8,\"y\":7,\"expected\":true},{\"taskId\":6,\"x\":3,\"y\":3,\"expected\":true},{\"taskId\":6,\"x\":2,\"y\":5,\"expected\":false},{\"taskId\":6,\"x\":5,\"y\":7,\"expected\":false},{\"taskId\":7,\"x\":2,\"y\":2,\"expected\":true},{\"taskId\":7,\"x\":2,\"y\":6,\"expected\":true},{\"taskId\":7,\"x\":6,\"y\":2,\"expected\":true},{\"taskId\":7,\"x\":6,\"y\":6,\"expected\":true},{\"taskId\":7,\"x\":6,\"y\":4,\"expected\":false},{\"taskId\":8,\"x\":5,\"y\":1,\"expected\":true},{\"taskId\":8,\"x\":3,\"y\":3,\"expected\":true},{\"taskId\":8,\"x\":2,\"y\":6,\"expected\":false},{\"taskId\":8,\"x\":7,\"y\":7,\"expected\":false},{\"taskId\":9,\"x\":2,\"y\":7,\"expected\":true},{\"taskId\":9,\"x\":3,\"y\":5,\"expected\":true},{\"taskId\":9,\"x\":6,\"y\":6,\"expected\":true},{\"taskId\":9,\"x\":6,\"y\":2,\"expected\":false},{\"taskId\":10,\"x\":7,\"y\":6,\"expected\":true},{\"taskId\":10,\"x\":6,\"y\":2,\"expected\":true},{\"taskId\":10,\"x\":2,\"y\":3,\"expected\":false},{\"taskId\":10,\"x\":3,\"y\":6,\"expected\":false},{\"taskId\":11,\"x\":4,\"y\":4,\"expected\":true}]}";

        Gson gson = new Gson();
        TestPointWraper testPoints = gson.fromJson(json, TestPointWraper.class);

        boolean test = true;

        for (TestPoit point : testPoints.TestPoints)
        {
            if(Main.isPrint(point.taskId,point.x,point.y) != point.expected)
                test = false;
        }
        assertTrue(Main.isPrint(1,1,1)/*test*/);

    }
}