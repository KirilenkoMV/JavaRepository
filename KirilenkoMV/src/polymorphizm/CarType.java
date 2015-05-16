package polymorphizm;

/**
 * Created by User on 16.05.2015.
 */
public enum CarType {
    SPORT {
        @Override
        public Car createCar() {
            return new SportCar();
        }
    }, CASUAL {
        @Override
        public Car createCar() {
            return new CasualCar();
        }
    }, LUXURY {
        @Override
        public Car createCar() {
            return new LuxuryCar();
        }
    };

    public abstract Car createCar();
}
