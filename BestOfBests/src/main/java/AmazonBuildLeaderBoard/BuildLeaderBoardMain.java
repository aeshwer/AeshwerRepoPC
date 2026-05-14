package AmazonBuildLeaderBoard;

public class BuildLeaderBoardMain {
	public static void main(String[] args) {

		ScoreService scoreService = new ScoreService();

		LeaderBoard daily = new LeaderBoard("DAILY");
		LeaderBoard weekly = new LeaderBoard("WEEKLY");
		LeaderBoard allTime = new LeaderBoard("ALL_TIME");

		scoreService.register(daily);
		scoreService.register(weekly);
		scoreService.register(allTime);

		scoreService.updateScore(1, 50);
		scoreService.updateScore(2, 30);
		scoreService.updateScore(1, 20);

		// Initial players
		daily.addScore(1, 50);
		daily.addScore(2, 30);
		daily.addScore(3, 40);
		daily.addScore(4, 70);
		daily.addScore(5, 60);

		System.out.println("Top 3 sum: " + daily.top(3));
		// Expected: 70 + 60 + 50 = 180

		// Update scores
		daily.addScore(2, 50); // player 2: 30 -> 80
		daily.addScore(3, 20); // player 3: 40 -> 60

		System.out.println("Top 3 sum after updates: " + daily.top(3));
		// Expected: 80 + 70 + 60 = 210

		// Reset a player
		daily.reset(4); // player 4 had 70

		System.out.println("Top 3 sum after reset player 4: " + daily.top(3));
		// Expected: 80 + 60 + 60 = 200

		// Add more updates
		daily.addScore(6, 90);
		daily.addScore(7, 20);

		System.out.println("Top 3 sum after new players: " + daily.top(3));
		// Expected: 90 + 80 + 60 = 230

		// Edge case: K > number of players
		System.out.println("Top 10 sum: " + daily.top(10));
	}
}
