package com.hellofresh.challenge.helper;

import io.github.benas.randombeans.randomizers.*;
import io.github.benas.randombeans.randomizers.jodatime.JodaTimeLocalDateRandomizer;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.LocalDate;

import java.util.Date;

@Data
public class AccountDetails {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate birthDate;
    private String company;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String postCode;
    private String other;
    private String phone;
    private String mobile;
    private String alias;

    public AccountDetails() {
        String timestamp = String.valueOf(new Date().getTime());
        setEmail("hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com");

        setPassword(RandomStringUtils.randomAlphabetic(10));

        setFirstName(FirstNameRandomizer.aNewFirstNameRandomizer().getRandomValue());
        setLastName(LastNameRandomizer.aNewLastNameRandomizer().getRandomValue());

        setBirthDate(generateValidDateOfBirth());

        setCompany(CompanyRandomizer.aNewCompanyRandomizer().getRandomValue());
        setAddress1(getRandomAddress());
        setAddress2(getRandomAddress());
        setCity(CityRandomizer.aNewCityRandomizer().getRandomValue());
        setState(StateRandomizer.aNewStateRandomizer().getRandomValue());
        setPostCode(RandomStringUtils.randomNumeric(5));
        setOther(SentenceRandomizer.aNewSentenceRandomizer().getRandomValue());
        setPhone(RandomStringUtils.randomNumeric(11));
        setMobile(RandomStringUtils.randomNumeric(11));
        setAlias(RandomStringUtils.randomNumeric(1, 33));
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    private LocalDate generateValidDateOfBirth() {
        int lastYear = LocalDate.now().getYear() - 1;

        LocalDate birthDate = JodaTimeLocalDateRandomizer.aNewJodaTimeLocalDateRandomizer().getRandomValue();

        int year = birthDate.getYear() > lastYear ? lastYear : birthDate.getYear();

        return birthDate.withYear(year);
    }

    private String getRandomAddress() {
        return StreetRandomizer.aNewStreetRandomizer().getRandomValue() + " " + RandomStringUtils.randomNumeric(1,3);
    }
}
