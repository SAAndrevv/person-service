package liga.medical.personservice.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ListUtils {

    public static String stringListWithoutBrackets(List<?> list) {
        return list.toString().substring(1, list.toString().length() - 1);
    }

    public static List<?> toWildCardList(Object[] objects) {
        return Arrays.stream(objects)
                .filter(Objects::nonNull)
                .map(arg -> arg.getClass().cast(arg))
                .collect(Collectors.toList());
    }

}
