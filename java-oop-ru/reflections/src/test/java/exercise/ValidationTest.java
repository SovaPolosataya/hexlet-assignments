package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Map;



class ValidationTest {

    @Test
    void testValidate() {
        Address address1 = new Address("Russia", "Ufa", "Lenina", "54", null);
        List<String> result1 = Validator.validate(address1);
        List<String> expected1 = List.of();
        assertThat(result1).isEqualTo(expected1);

        Address address2 = new Address(null, "London", "1-st street", "5", "1");
        List<String> result2 = Validator.validate(address2);
        List<String> expected2 = List.of("country");
        assertThat(result2).isEqualTo(expected2);

        Address address3 = new Address("USA", null, null, null, "1");
        List<String> result3 = Validator.validate(address3);
        List<String> expected3 = List.of("city", "street", "houseNumber");
        assertThat(result3).isEqualTo(expected3);
    }

    // BEGIN
    void testAdvancedValidate() {
        Address address4 = new Address("Russia", "Kaliningrad", "Kamskaya", "52", "1");
        Map<String, List<String>> result4 = Validator.advancedValidate(address4);
        Map<String, List<String>> expected4 = Map.of();
        assertThat(result4).isEqualTo(expected4);

        Address address5 = new Address(null, "Berlin", "Nu", "35", "7");
        Map<String, List<String>> result5 = Validator.advancedValidate(address5);
        List<String> country1 = List.of("can not be null", "length less than 3");
        List<String> street1 = List.of("can not be null", "length less than 5");
        List<String> houseNumber1 = List.of("length less than 2");
        Map<String, List<String>> expected5 = Map.of("country", country1, "street", street1, "houseNumber", houseNumber1);
        assertThat(result5).isEqualTo(expected5);

        Address address6 = new Address(null, "London", "1-st street", "5", "1");
        Map<String, List<String>> result6 = Validator.advancedValidate(address6);
        List<String> city2 = List.of("length less than 3");
        List<String> street2 = List.of("length less than 5");
        Map<String, List<String>> expected6 = Map.of("city", city2, "street", street2);
        assertThat(result6).isEqualTo(expected6);
    }
    // END
}
