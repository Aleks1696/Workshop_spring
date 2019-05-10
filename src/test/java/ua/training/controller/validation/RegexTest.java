package ua.training.controller.validation;

import org.junit.Test;
import ua.training.model.utils.AttributesBinder;
import ua.training.model.utils.RegexBinder;

import javax.naming.event.ObjectChangeListener;

import static org.junit.Assert.*;

public class RegexTest {

    @Test
    public void testLoginRegexPositive() {
        assertTrue("monika".matches(RegexBinder.getProperty("regex.login")));
        assertTrue("Andy".matches(RegexBinder.getProperty("regex.login")));
        assertTrue("Lori_33".matches(RegexBinder.getProperty("regex.login")));
        assertTrue("a".matches(RegexBinder.getProperty("regex.login")));
        assertTrue("TONY".matches(RegexBinder.getProperty("regex.login")));
        assertTrue("terry smag".matches(RegexBinder.getProperty("regex.login")));
    }

    @Test
    public void testLoginRegexNegative() {
        assertFalse("43monika".matches(RegexBinder.getProperty("regex.login")));
        assertFalse("_Andy".matches(RegexBinder.getProperty("regex.login")));
        assertFalse(" Lori_33".matches(RegexBinder.getProperty("regex.login")));
        assertFalse("рон".matches(RegexBinder.getProperty("regex.login")));
        assertFalse("рон".matches(RegexBinder.getProperty("regex.login")));
        assertFalse("thisStringIsWayTooLongForLogin".matches(RegexBinder.getProperty("regex.login")));
        assertFalse("".matches(RegexBinder.getProperty("regex.login")));
    }

    @Test
    public void testPasswordRegexPositive() {
        assertTrue("monika".matches(RegexBinder.getProperty("regex.password")));
        assertTrue("12monika".matches(RegexBinder.getProperty("regex.password")));
        assertTrue("monika89".matches(RegexBinder.getProperty("regex.password")));
    }

    @Test
    public void testPasswordRegexNegative() {
        assertFalse("_monika".matches(RegexBinder.getProperty("regex.password")));
        assertFalse("m o n i k a".matches(RegexBinder.getProperty("regex.password")));
        assertFalse("monika_89".matches(RegexBinder.getProperty("regex.password")));
    }

    @Test
    public void testNameRegexPositive() {
        assertTrue("Monika".matches(RegexBinder.getProperty("regex.name")));
        assertTrue("Anna-Maria".matches(RegexBinder.getProperty("regex.name")));
    }

    @Test
    public void testNameRegexNegative() {
        assertFalse("monika".matches(RegexBinder.getProperty("regex.name")));
        assertFalse("Anna-maria".matches(RegexBinder.getProperty("regex.name")));
        assertFalse("anna-maria".matches(RegexBinder.getProperty("regex.name")));
        assertFalse("12monika".matches(RegexBinder.getProperty("regex.name")));
        assertFalse("_monika".matches(RegexBinder.getProperty("regex.name")));
        assertFalse("MONIKA".matches(RegexBinder.getProperty("regex.name")));
    }

    @Test
    public void testName_uaRegexPositive() {
        assertTrue("Моніка".matches(RegexBinder.getProperty("regex.name_ua")));
        assertTrue("Анна-Марія".matches(RegexBinder.getProperty("regex.name_ua")));
        assertTrue("Мар'яна".matches(RegexBinder.getProperty("regex.name_ua")));
    }

    @Test
    public void testName_uaRegexNegative() {
        assertFalse("_Анна".matches(RegexBinder.getProperty("regex.name_ua")));
        assertFalse("МАРІЯ".matches(RegexBinder.getProperty("regex.name_ua")));
        assertFalse("Антон89".matches(RegexBinder.getProperty("regex.name_ua")));
        assertFalse("".matches(RegexBinder.getProperty("regex.name_ua")));
    }

    @Test
    public void testSurname_uaRegexPositive() {
        assertTrue("Моніка".matches(RegexBinder.getProperty("regex.surname_ua")));
        assertTrue("Анна-Марія".matches(RegexBinder.getProperty("regex.surname_ua")));
        assertTrue("Мар'яна".matches(RegexBinder.getProperty("regex.surname_ua")));
    }

    @Test
    public void testSurname_uaRegexNegative() {
        assertFalse("_Анна".matches(RegexBinder.getProperty("regex.surname_ua")));
        assertFalse("МАРІЯ".matches(RegexBinder.getProperty("regex.surname_ua")));
        assertFalse("Антон89".matches(RegexBinder.getProperty("regex.surname_ua")));
        assertFalse("".matches(RegexBinder.getProperty("regex.surname_ua")));
    }

    @Test
    public void testEmailRegexPositive() {
        assertTrue("anna@gmail.com".matches(RegexBinder.getProperty("regex.email")));
        assertTrue("_manika@gmail.com".matches(RegexBinder.getProperty("regex.email")));
        assertTrue("Andy_Case@ibm.com".matches(RegexBinder.getProperty("regex.email")));
    }

    @Test
    public void testEmailRegexNegative() {
        assertFalse("monikagmail.com".matches(RegexBinder.getProperty("regex.email")));
        assertFalse("@gmail.com".matches(RegexBinder.getProperty("regex.email")));
        assertFalse("mokika@gmail".matches(RegexBinder.getProperty("regex.email")));
    }

    @Test
    public void testPhoneNumberRegexPositive() {
        assertTrue("3214".matches(RegexBinder.getProperty("regex.phoneNumber")));
        assertTrue("1".matches(RegexBinder.getProperty("regex.phoneNumber")));
    }

    @Test
    public void testPhoneNumberRegexNegative() {
        assertFalse("".matches(RegexBinder.getProperty("regex.phoneNumber")));
        assertFalse("symbols".matches(RegexBinder.getProperty("regex.phoneNumber")));
        assertFalse("3-234-2".matches(RegexBinder.getProperty("regex.phoneNumber")));
    }

    @Test
    public void testDeviceCategoryPositive() {
        assertTrue("APPLIANCE".matches(RegexBinder.getProperty("regex.device.category")));
        assertTrue("SMARTPHONE".matches(RegexBinder.getProperty("regex.device.category")));
    }

    @Test
    public void testPricePositive() {
        assertTrue("434".matches(RegexBinder.getProperty("regex.price")));
    }

    @Test
    public void testPriceNegative() {
        assertFalse("string".matches(RegexBinder.getProperty("regex.price")));
        assertFalse("54,32".matches(RegexBinder.getProperty("regex.price")));
        assertFalse("-".matches(RegexBinder.getProperty("regex.price")));
        assertFalse("".matches(RegexBinder.getProperty("regex.price")));
    }















}