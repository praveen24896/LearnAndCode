public class AccidentExceptions {
    public static class CabDriverInjuredException extends Exception {
        public CabDriverInjuredException(String message) {
            super(message);
        }
    }

    public static class ScootyRiderInjuredException extends Exception {
        public ScootyRiderInjuredException(String message) {
            super(message);
        }
    }

    public static class PropertyDamageException extends Exception {
        public PropertyDamageException(String message) {
            super(message);
        }
    }

    public static class EnvironmentalDamageException extends Exception {
        public EnvironmentalDamageException(String message) {
            super(message);
        }
    }

    public static class OtherPeopleInjuredException extends Exception {
        public OtherPeopleInjuredException(String message) {
            super(message);
        }
    }

    public static class OthersPropertyDamageException extends Exception {
        public OthersPropertyDamageException(String message) {
            super(message);
        }
    }

    public static class FireCausedException extends Exception {
        public FireCausedException(String message) {
            super(message);
        }
    }

    public static class UnknownAccidentException extends Exception {
        public UnknownAccidentException(String message) {
            super(message);
        }
    }
}
