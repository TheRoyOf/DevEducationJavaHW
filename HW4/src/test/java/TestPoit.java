public class TestPoit
{
    int taskId;
    int x;
    int y;
    boolean expected;

    TestPoit(int _taskId,
            int _x,
            int _y,
            boolean _expected)
    {
        int taskId = _taskId;
        int x = _x;
        int y = _y;
        boolean expected = _expected;
    }

    TestPoit() {}
}
