import java.util.List;

@FunctionalInterface
interface ReportGenerator<T, R> {
    R generate(List<T> data);
}
