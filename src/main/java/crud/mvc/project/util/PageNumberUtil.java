package crud.mvc.project.util;

import org.springframework.data.domain.Page;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PageNumberUtil {
    public static <T> List<Integer> getPageNumber(Page<T> pages) {
        int totalPages = pages.getTotalPages();
        if (totalPages > 0) {
            return IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
        }

        return Collections.emptyList();
    }
}
