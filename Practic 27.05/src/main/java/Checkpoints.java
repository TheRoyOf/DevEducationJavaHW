package practice.wednesday_27_05;

import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.TreeMap;

public class Checkpoints {
    private Map<Integer, Checkpoint> checkpoints = new TreeMap<>();

    public Checkpoints() {
    }

    public Map<Integer, Checkpoint> generateCheckpoint() {
        int checkpointId = 1;
        int sum = 0;
        do {
            checkpoints.clear();
            sum = 0;
            checkpointId = 1;

            for (int i = 0; i < 10; i++) {
                checkpoints.put(checkpointId, new Checkpoint());
                sum += checkpoints.get(checkpointId).getPrice();
                checkpointId++;
            }

        } while (sum <= 55);

        return checkpoints;
    }

    public Map<Integer, Checkpoint> getCheckpoints() {
        return checkpoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Checkpoints that = (Checkpoints) o;
        return Objects.equals(checkpoints, that.checkpoints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkpoints);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Checkpoints.class.getSimpleName() + "[", "]")
                .add("checkpoints=" + checkpoints)
                .toString();
    }
}
