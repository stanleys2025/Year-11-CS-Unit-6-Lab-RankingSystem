public class User {
    private int rank = -8;
    private int progress;

    public int getRank() {
        return rank;
    }

    public int getProgress() {
        return progress;
    }

    public void incProgress(int activity) {
        int d; // difference between the two values

        if (activity > 8 || activity == 0 || activity < -8) {
            throw new IllegalArgumentException("The rank of an activity cannot be less than 8, 0, or greater than 8!");
        }

        System.out.println("rank = " + rank);
        System.out.println("activity = " + activity);

        if (activity >= 1 && rank <= -1 || activity <= -1 && rank >= 1) { // ignore 0
            if(rank == 1 && activity == -1){
                d = -1;
            }
            else if (rank - activity < 0) {
                d = -(rank - activity) - 1;
            } else {
                d = rank - activity - 1;
            }
        } else {
            if (rank - activity < 0) {
                d = -(rank - activity);
            } else {
                d = rank - activity;
            }

        }

        System.out.println("d = " + d);

        if (d == 0) {
            progress += 3;
            System.out.println("+3");
        } else if (d == -1) {
            progress++;
            System.out.println("+1");
        } else {
            progress += d * d * 10;
            System.out.println("+" + progress);
        }

        while (progress > 100) { // rank up process -> keep on upgrading when progress is full
            if (rank == -1) {
                rank = 1;
            } else {
                rank++;
            }
            progress -= 100;
        }


    }

    public String toString() {
        return "User{rank=" + rank + ", progress=" + progress + "}";
    }
}