class Main {

    interface Moveable {
        void go();
    }

    private static void moveFiveTimes(Moveable moveable) {
        for (int i = 0; i < 5; i++) {
            moveable.go(i);
        }
    }

    public static void main(String[] args) {
        Moveable sasha = () -> {
            System.out.println("Саша идет бухать, потому что Саша устал");
            System.out.println("Саша идет бухать, потому что Саша устал");
        };

        Moveable longSasha = a -> System.out.println("Саша идет бухать, потому что Саша устал");
        moveFiveTimes(longSasha);
        moveFiveTimes(sasha);
        moveFiveTimes((a) -> System.out.println("короткий анонимный аноним идет взламывать пентагон"));
        moveFiveTimes(a -> System.out.println("длинный анонимный аноним идет взламывать пентагон"));
    }
}
