package AmazonBuildLeaderBoard;

import java.util.ArrayList;
import java.util.List;

public class ScoreService {
	private List<LeaderBoardObserver> observers = new ArrayList<>();

	public void register(LeaderBoardObserver observer) {
		observers.add(observer);
	}

	public void updateScore(int playerId, int deltaScore) {
		long timestamp = System.currentTimeMillis();

		// 🔥 notify all leaderboards
		for (LeaderBoardObserver obs : observers) {
			obs.onScoreUpdate(playerId, deltaScore, timestamp);
		}
	}
}