import java.io.*;
import java.util.*;

class Lesson implements Comparable<Lesson> {
    int id;
    int start;
    int end;

    Lesson(int _id, int _start, int _end) {
        this.id = _id;
        this.start = _start;
        this.end = _end;
    }

    @Override
    public int compareTo(Lesson target) {
        int diff = this.start - target.start;
        if (diff != 0) {
            return diff;
        }

        return this.end - target.end;
    }

    @Override
    public String toString() {
        return this.id + " " + this.start + " " + this.end;
    }
}

class Room implements Comparable<Room> {
    int end;

    Room(int _end) {
        this.end = _end;
    }

    @Override
    public int compareTo(Room target) {
        return this.end - target.end;
    }
}

public class Main {
    static PriorityQueue<Lesson> lessons = new PriorityQueue<Lesson>();
    static PriorityQueue<Room> rooms = new PriorityQueue<Room>();

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        var line = new StringTokenizer(br.readLine());
        var N = Integer.parseInt(line.nextToken());
        for (int n = 0; n < N; n++) {
            line = new StringTokenizer(br.readLine());
            var id = Integer.parseInt(line.nextToken());
            var start = Integer.parseInt(line.nextToken());
            var end = Integer.parseInt(line.nextToken());

            lessons.add(new Lesson(id, start, end));
        }

        Lesson lessonF = lessons.poll();
        rooms.add(new Room(lessonF.end));

        while (!lessons.isEmpty()) {
            var lesson = lessons.peek();
            int minEnd = rooms.peek().end;

            if (lesson.start >= minEnd) {
                lessons.remove();
                rooms.remove();
                rooms.add(new Room(lesson.end));
            } else {
                lessons.remove();
                rooms.add(new Room(lesson.end));
            }
        }

        System.out.println(rooms.size());
    }
}