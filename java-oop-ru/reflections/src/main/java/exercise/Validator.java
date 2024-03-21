package exercise;

import java.lang.reflect.Field;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
// BEGIN
public class Validator {
    private Address address;

    public Validator(Address address) {
        this.address = address;
    }

    public static List<String> validate(Address address) {
        List<Field> fields = List.of(address.getClass().getDeclaredFields());
        return fields.stream()
                .filter(field -> field.isAnnotationPresent(NotNull.class))
                .filter(field -> {
                    Object value;
                    try {
                        field.setAccessible(true);
                        value = field.get(address);
                        field.setAccessible(false);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    return value == null;
                })
                .map(Field::getName)
                .collect(Collectors.toList());
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        Map<String, List<String>> result = new HashMap<>();
        List<Field> fields = List.of(address.getClass().getDeclaredFields());

        fields.stream()
                .filter(field -> field.isAnnotationPresent(NotNull.class) || field.isAnnotationPresent(MinLength.class))
                .forEach(field -> {
                    String fieldName = field.getName();
                    List<String> interimResults = new ArrayList<>();
                    List<String> withNull = validate(address);
                    String nameField;
                    try {
                        field.setAccessible(true);
                        nameField = (String) field.get(address);
                        field.setAccessible(false);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }

                    if (withNull.contains(field.getName())) {
                        interimResults.add("can not be null");
                    }
                    if (field.isAnnotationPresent(MinLength.class)) {
                        var fieldLength = field.getAnnotation(MinLength.class).minLength();
                        if(nameField == null || nameField.length() < fieldLength) {
                            interimResults.add("length less than " + fieldLength);
                        }
                    }
                    if (!interimResults.isEmpty()) {
                        result.put(fieldName, interimResults);
                    }
                });

        return result;
    }
}
// END
