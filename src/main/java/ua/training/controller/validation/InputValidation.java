package ua.training.controller.validation;

import ua.training.model.entity.Feedback;
import ua.training.model.entity.Request;
import ua.training.model.entity.User;
import ua.training.model.utils.MessagesBinder;
import static ua.training.model.utils.RegexBinder.*;

import java.util.List;

public class InputValidation {
    private List<String> wrongInputMessages;

    //TODO it would be better to check and return login, password validation mistake separately
    public boolean isLoginAndPasswordValid(String login, String password, List<String> wrongInputMessages) {
        this.wrongInputMessages = wrongInputMessages;
        boolean isLoginValid = isParameterValid(login, getProperty("regex.login"),
                                                "input.wrong.login.format");
        boolean isPasswordValid = isParameterValid(password, getProperty("regex.password"),
                                                   "input.wrong.password.format");
        return isLoginValid && isPasswordValid;
    }

    public boolean isUserValid(User user, List<String> wrongInputMessages) {
        this.wrongInputMessages = wrongInputMessages;

        boolean isLoginValid = isParameterValid(user.getLogin(), getProperty("regex.login"),
                MessagesBinder.getProperty("input.wrong.login.format"));
        boolean isPasswordValid = isParameterValid(user.getPassword(), getProperty("regex.password"),
                MessagesBinder.getProperty("input.wrong.password.format"));
        boolean isNameValid = isParameterValid(user.getName(), getProperty("regex.name"),
                MessagesBinder.getProperty("input.wrong.name.format"));
        boolean isName_uaValid = isParameterValid(user.getName_ua(), getProperty("regex.name_ua"),
                MessagesBinder.getProperty("input.wrong.name_ua.format"));
        boolean isSurnameValid = isParameterValid(user.getSurname(), getProperty("regex.surname"),
                MessagesBinder.getProperty("input.wrong.surname.format"));
        boolean isSurname_uaValid = isParameterValid(user.getSurname_ua(), getProperty("regex.surname_ua"),
                MessagesBinder.getProperty("input.wrong.surname_ua.format"));
        boolean isEmailValid = isParameterValid(user.getEmail(), getProperty("regex.email"),
                MessagesBinder.getProperty("input.wrong.email.format"));
        boolean isPhoneNumberValid = isParameterValid(user.getPhoneNumber(), getProperty("regex.phoneNumber"),
                MessagesBinder.getProperty("input.wrong.phoneNumber.format"));

        return isLoginValid && isPasswordValid && isNameValid && isName_uaValid && isSurnameValid &&
                isSurname_uaValid && isEmailValid && isPhoneNumberValid;
    }

    private boolean isParameterValid(String parameter, String regex, String errorMessage) {
        if (parameter == null || !(parameter.matches(regex))) {
            wrongInputMessages.add(errorMessage);
            return false;
        } else {
            return true;
        }
    }

    public boolean isRequestValid(Request request, List<String> wrongInputMessages) {
        //TODO needs implementation
        return true;
    }

    public boolean isPriceAndDescriptionValid(String price, String managerComment, List<String> wrongInputMessages) {
        this.wrongInputMessages = wrongInputMessages;
        boolean isPriceValid = isParameterValid(price, getProperty("regex.price"),
                "input.wrong.request.price.format");
        boolean isDescriptionValid = isParameterValid(managerComment, getProperty("regex.description"),
                "input.wrong.request.description.format");
        return isPriceValid && isDescriptionValid;
    }

    public boolean isCommentaryValid(String managerComment, List<String> wrongInputMessages) {
        this.wrongInputMessages = wrongInputMessages;
        return isParameterValid(managerComment, getProperty("regex.description"),
                "input.wrong.request.description.format");
    }

    public boolean isFeedbackValid(Feedback feedback, List<String> wrongInputMessages) {
        this.wrongInputMessages = wrongInputMessages;
        return isParameterValid(feedback.getCommentary(), getProperty("regex.commentary"),
                "input.wrong.feedback.commentary.format");
    }





}
