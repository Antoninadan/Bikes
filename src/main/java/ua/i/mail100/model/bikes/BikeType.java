package ua.i.mail100.model.bikes;

public enum BikeType {
    FOLDING_BIKE {
        @Override
        public String toString() {
            return "FOLDING BIKE";
        }
    },
    SPEEDELEC {
        @Override
        public String toString() {
            return "SPEEDELEC";
        }
    },
    E_BIKE {
        @Override
        public String toString() {
            return "E-BIKE";
        }
    }
}