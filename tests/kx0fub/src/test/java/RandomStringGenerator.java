import java.util.Random;

public class RandomStringGenerator {
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int MIN_LENGTH = 6;
    private static final int MAX_LENGTH = 10;
    private Random random;

    public RandomStringGenerator() {
        random = new Random();
    }

    public String generateString() {
        int length = random.nextInt(MAX_LENGTH - MIN_LENGTH + 1) + MIN_LENGTH;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RandomStringGenerator generator = new RandomStringGenerator();
        String randomString = generator.generateString();
        System.out.println(randomString);
    }
}
