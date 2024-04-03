public class CarAccidentScenario {
    public static void main(String[] args) {
        try {
            handleAccident("CabDriver");
        } catch (AccidentExceptions.CabDriverInjuredException e) {
            System.out.println("Calling emergency services for injured driver...");
            provideMedicalAssistance();
            contactFamily();
        } catch (AccidentExceptions.ScootyRiderInjuredException e) {
            System.out.println("Calling emergency services for injured scooty rider...");
            provideMedicalAssistance();
            contactFamily();
        } catch (AccidentExceptions.PropertyDamageException e) {
            System.out.println("Handling property damage...");
            handlePropertyDamage();
        } catch (AccidentExceptions.EnvironmentalDamageException e) {
            initiateEnvironmentalCleanup();
        } catch (AccidentExceptions.OtherPeopleInjuredException e) {
            provideMedicalAssistance();
            contactFamily();
        } catch (AccidentExceptions.OthersPropertyDamageException e) {
            System.out.println("Contacting property owner and insurance company...");
            handlePropertyDamage();
        } catch (AccidentExceptions.FireCausedException e) {
            precautionarySteps();
            initiateFirefighting();
            provideMedicalAssistance();
        } catch (AccidentExceptions.UnknownAccidentException e) {
            System.out.println("Unknown accident occurred!");
        } finally {
            contactAuthorities();
            initiateEnvironmentalCleanup();
        }
    }

    private static void handleAccident(String type)
            throws AccidentExceptions.CabDriverInjuredException, AccidentExceptions.ScootyRiderInjuredException,
            AccidentExceptions.PropertyDamageException, AccidentExceptions.EnvironmentalDamageException,
            AccidentExceptions.OtherPeopleInjuredException,
            AccidentExceptions.OthersPropertyDamageException, AccidentExceptions.FireCausedException,
            AccidentExceptions.UnknownAccidentException {
        switch (type) {
            case "CabDriver":
                throw new AccidentExceptions.CabDriverInjuredException("Cab driver injured!");
            case "ScootyRider":
                throw new AccidentExceptions.ScootyRiderInjuredException("Scooty rider injured!");
            case "PropertyDamage":
                throw new AccidentExceptions.PropertyDamageException("Property damage occurred!");
            case "EnvironmentalDamage":
                throw new AccidentExceptions.EnvironmentalDamageException("Environmental damage occurred!");
            case "OtherPeopleInjured":
                throw new AccidentExceptions.OtherPeopleInjuredException("Other people injured!");
            case "OthersPropertyDamage":
                throw new AccidentExceptions.OthersPropertyDamageException("Others' property damage occurred!");
            case "FireCaused":
                throw new AccidentExceptions.FireCausedException("Fire caused by the accident!");
            default:
                throw new AccidentExceptions.UnknownAccidentException("Unknown accident type: " + type);
        }
    }

    private static void handlePropertyDamage() {
        System.out.println("Contacting insurance company and arranging for repair services.");
    }

    private static void initiateEnvironmentalCleanup() {
        System.out.println("Dispatch the crowd and initiate the environment cleanup.");
    }

    private static void provideMedicalAssistance() {
        System.out.println("Providing first aid and arranging transportation of injured to the nearest hospital.");
    }

    private static void precautionarySteps() {
        System.out.println("Evacuate the nearby area and perform necessary action to stop the spread of fire");
    }

    private static void initiateFirefighting() {
        System.out.println("Call Fire brigade and start the fire extinguishing efforts.");
    }

    private static void contactFamily() {
        System.out.println("Contact the injured family members.");
    }

    private static void contactAuthorities() {
        System.out.println("Contact the nearby authorities");
    }
}