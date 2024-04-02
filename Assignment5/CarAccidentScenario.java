public class CarAccidentScenario {
    public static void main(String[] args) {
        try {
            throw new CabDriverInjuredException("Cab driver injured!");
        } catch (CabDriverInjuredException e) {
            System.out.println("Calling emergency services for injured cab driver...");
            performEmergencyServices();
        } finally {
            contactFamily();
        }

        try {
            throw new ScootyRiderInjuredException("Scooty rider injured!");
        } catch (ScootyRiderInjuredException e) {
            System.out.println("Calling emergency services for injured scooty rider...");
            performEmergencyServices();
        } finally {
            contactFamily();
        }

        try {
            throw new PropertyDamageException("Property damage occurred!");
        } catch (PropertyDamageException e) {
            System.out.println("Handling property damage...");
            handlePropertyDamage();
        } 

        try {
            throw new EnvironmentalDamageException("Environmental damage occurred!");
        } catch (EnvironmentalDamageException e) {
            initiateEnvironmentalCleanup();
        }

        try {
            throw new OtherPeopleInjuredException("Other people injured!");
        } catch (OtherPeopleInjuredException e) {
            provideMedicalAssistance();
        } finally {
            contactFamily();
        }

        try {
            throw new OthersPropertyDamageException("Others' property damage occurred!");
        } catch (OthersPropertyDamageException e) {
            System.out.println("Contacting property owner and insurance company...");
            handlePropertyDamage();
        } finally {
            contactAuthorities();
        }

        try {
            throw new FireCausedException("Fire caused by the accident!");
        } catch (FireCausedException e) {
            initiateFirefighting();
            provideMedicalAssistance();
        } finally {
            precautionarySteps();
        }
    }

    private static void performEmergencyServices() {
        System.out.println("Emergency services dispatched. Providing medical assistance.");
    }

    private static void handlePropertyDamage() {
        System.out.println("Contacting insurance company and arranging for repair services.");
    }

    private static void initiateEnvironmentalCleanup() {
        System.out.println("Environmental cleanup initiated. Contacting relevant authorities.");
    }

    private static void provideMedicalAssistance() {
        System.out.println("Providing first aid and arranging transportation to hospital.");
    }

    private static void initiateFirefighting() {
        System.out.println("Call Fire brigade and start the fire extinguishing efforts.");
    }

    private static void  precautionarySteps() {
        System.out.println("Evacuate the nearby area and perform necessary action to stop the spread of fire");
    }

    private static void contactFamily() {
        System.out.println("Contact the injured family members.");
    }

    private static void contactAuthorities() {
        System.out.println("Contact the nearby authorities");
    }
}

class CabDriverInjuredException extends Exception {
    public CabDriverInjuredException(String message) {
        super(message);
    }
}

class ScootyRiderInjuredException extends Exception {
    public ScootyRiderInjuredException(String message) {
        super(message);
    }
}

class PropertyDamageException extends Exception {
    public PropertyDamageException(String message) {
        super(message);
    }
}

class EnvironmentalDamageException extends Exception {
    public EnvironmentalDamageException(String message) {
        super(message);
    }
}

class OtherPeopleInjuredException extends Exception {
    public OtherPeopleInjuredException(String message) {
        super(message);
    }
}

class OthersPropertyDamageException extends Exception {
    public OthersPropertyDamageException(String message) {
        super(message);
    }
}

class FireCausedException extends Exception {
    public FireCausedException(String message) {
        super(message);
    }
}
