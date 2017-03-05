package easytests.models.empty;

import easytests.entities.UserEntity;
import easytests.models.SubjectModelInterface;
import easytests.models.UserModelInterface;
import easytests.models.exceptions.CallMethodOnEmptyModelException;
import java.util.List;


/**
 * @author malinink
 */
public class UserModelEmpty extends AbstractModelEmpty implements UserModelInterface {
    @Override
    public void setId(Integer id) {
        this.throwException();
    }

    @Override
    public String getFirstName() {
        this.throwException();
        return null;
    }

    @Override
    public void setFirstName(String firstName) {
        this.throwException();
    }

    @Override
    public String getLastName() {
        this.throwException();
        return null;
    }

    @Override
    public void setLastName(String lastName) {
        this.throwException();
    }

    @Override
    public String getSurname() {
        this.throwException();
        return null;
    }

    @Override
    public void setSurname(String surname) {
        this.throwException();
    }

    @Override
    public List<SubjectModelInterface> getSubjects() {
        this.throwException();
        return null;
    }

    @Override
    public void setSubjects(List<SubjectModelInterface> subjects) {
        this.throwException();
    }

    @Override
    public void map(UserEntity userEntity) {
        this.throwException();
    }

    private void throwException() throws CallMethodOnEmptyModelException {
        throw new CallMethodOnEmptyModelException();
    }
}
