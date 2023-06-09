package crud.mvc.project.util;


import java.util.List;

public class ListUtilHelper {
    public static boolean isNotNullOrEmpty(List list) {
        return !(list == null || list.isEmpty());
    }
}
