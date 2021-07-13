package project.hrms.core.utilities.adapters;

public interface ValidationService {
    boolean validateByMernis(long identityNumber, String firstName, String lastName, int yearOfBirth);

}
