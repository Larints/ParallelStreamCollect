import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParallelStreamCollectMapAdvancedExample {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Student1", Map.of("Math", 90, "Physics", 85)),
                new Student("Student2", Map.of("Math", 95, "Physics", 88)),
                new Student("Student3", Map.of("Math", 88, "Chemistry", 92)),
                new Student("Student4", Map.of("Physics", 78, "Chemistry", 85))
        );

        Map<String, Double> averageMap = students.parallelStream()
                .flatMap(s -> s.getGrades().entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.averagingDouble(Map.Entry::getValue)));
        System.out.println(averageMap);
    }


}
