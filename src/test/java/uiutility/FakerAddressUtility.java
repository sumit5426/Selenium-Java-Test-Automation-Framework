package uiutility;

import com.github.javafaker.Faker;
import uipojo.AddressPojo;

import java.util.Locale;

public class FakerAddressUtility {
    public static void main(String[] args) {
        getFakeAddress();
    }

    public static AddressPojo getFakeAddress() {
        Faker faker = new Faker(Locale.US);
        AddressPojo addressPojo = new AddressPojo(faker.company().name(), faker.address().buildingNumber(),
                faker.address().streetAddress(), faker.address().city(), faker.numerify("#####"),
                faker.phoneNumber().cellPhone(), faker.phoneNumber().cellPhone(), "other", "office address",
                faker.address().state());
        return addressPojo;

    }
}
