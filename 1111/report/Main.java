import java.util.*;

class Player {
    private String name;
    private int favoriteNumber;
    private int matchCount;

    public Player(String name) {
        this.name = name;
        this.matchCount = 0;
    }

    public String getName() {
        return name;
    }

    public void setFavoriteNumber(int favoriteNumber) {
        this.favoriteNumber = favoriteNumber;
    }

    public int getFavoriteNumber() {
        return favoriteNumber;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public void resetMatchCount() {
        this.matchCount = 0;
    }

    public void incrementMatchCount() {
        this.matchCount++;
    }
}

class NumberExpectationGame {
    private List<Player> players;
    private Random random;

    public NumberExpectationGame() {
        players = new ArrayList<>();
        random = new Random();
    }

    public void addPlayers(String[] names) {
        for (String name : names) {
            players.add(new Player(name.trim()));
        }
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        // 각 선수에게 좋아하는 정수 입력받기
        for (Player player : players) {
            System.out.printf("[%s] 정수 선택(1~10)>>", player.getName());
            int number = Integer.parseInt(scanner.nextLine());
            player.setFavoriteNumber(number);
        }

        while (true) {
            System.out.println("Enter키 입력>>");
            scanner.nextLine(); // Enter 키 입력

            // 15개의 랜덤한 정수 생성
            List<Integer> randomNumbers = generateRandomNumbers(15);
            System.out.println(randomNumbers);

            // 각 선수의 맞춘 개수 계산
            calculateMatchCounts(randomNumbers);

            // 결과 출력
            List<Player> losers = findLosers();
            for (Player player : players) {
                System.out.printf("[%s] 맞춘 개수: %d\n", player.getName(), player.getMatchCount());
            }

            if (losers.size() == 1) {
                System.out.println("최종 패자는 " + losers.get(0).getName() + "입니다.");
                break;
            } else {
                System.out.print("현재 패자들 : ");
                for (Player loser : losers) {
                    System.out.print(loser.getName() + " ");
                }
                System.out.println();

                // 다음 라운드를 위해 패자만 남기고 초기화
                players = new ArrayList<>(losers);
                for (Player player : players) {
                    player.resetMatchCount();
                }
            }
        }
        scanner.close();
    }

    private List<Integer> generateRandomNumbers(int count) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            numbers.add(random.nextInt(10) + 1);
        }
        return numbers;
    }

    private void calculateMatchCounts(List<Integer> randomNumbers) {
        for (Player player : players) {
            for (int number : randomNumbers) {
                if (player.getFavoriteNumber() == number) {
                    player.incrementMatchCount();
                }
            }
        }
    }

    private List<Player> findLosers() {
        List<Player> losers = new ArrayList<>();
        int minCount = Integer.MAX_VALUE;

        // 최소 맞춘 개수 찾기
        for (Player player : players) {
            if (player.getMatchCount() < minCount) {
                minCount = player.getMatchCount();
            }
        }

        // 최소 맞춘 개수에 해당하는 선수 추가
        for (Player player : players) {
            if (player.getMatchCount() == minCount) {
                losers.add(player);
            }
        }

        return losers;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NumberExpectationGame game = new NumberExpectationGame();

        System.out.print("게임에 참여할 선수들 이름>>");
        String[] names = scanner.nextLine().split(" ");
        game.addPlayers(names);

        game.playGame();
    }
}
