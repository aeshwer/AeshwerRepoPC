package AmazonBuildLeaderBoard;

import java.util.*;

public class LeaderBoard implements LeaderBoardObserver {

	private String type; // DAILY, WEEKLY, ALL_TIME

	// playerId -> score
	private Map<Integer, Integer> playerScore;

	// score -> players (in insertion order)
	private TreeMap<Integer, LinkedHashSet<Integer>> scoreMap;

	// score -> number of players
	private TreeMap<Integer, Integer> scoreFreq;

	public LeaderBoard(String type) {
		this.playerScore = new HashMap<>();
		this.type = type;
		this.scoreMap = new TreeMap<>(Collections.reverseOrder()); // high → low
		this.scoreFreq = new TreeMap<>(Collections.reverseOrder());
	}

	@Override
	public void onScoreUpdate(int playerId, int deltaScore, long timestamp) {
		if (!isValidForBoard(timestamp))
			return;

		addScore(playerId, deltaScore);
	}

	private boolean isValidForBoard(long timestamp) {
		// Example:
		// DAILY → only today
		// WEEKLY → last 7 days
		// ALL_TIME → always true

		return true; // stub (you can expand)
	}

	// ✅ Add score
	public void addScore(int playerId, int score) {
		int oldScore = playerScore.getOrDefault(playerId, 0);
		int newScore = oldScore + score;

		playerScore.put(playerId, newScore);

		// 🔻 Remove from old score bucket
		if (oldScore != 0) {
			LinkedHashSet<Integer> oldSet = scoreMap.get(oldScore);
			oldSet.remove(playerId);

			if (oldSet.isEmpty()) {
				scoreMap.remove(oldScore);
			}

			// update freq
			int count = scoreFreq.get(oldScore);
			if (count == 1) {
				scoreFreq.remove(oldScore);
			} else {
				scoreFreq.put(oldScore, count - 1);
			}
		}

		// 🔺 Add to new score bucket
		scoreMap.putIfAbsent(newScore, new LinkedHashSet<>());
		scoreMap.get(newScore).add(playerId);

		scoreFreq.put(newScore, scoreFreq.getOrDefault(newScore, 0) + 1);
	}

	// ✅ Top K score sum
	public int top(int K) {
		int sum = 0;

		for (Map.Entry<Integer, LinkedHashSet<Integer>> entry : scoreMap.entrySet()) {
			int score = entry.getKey();
			int count = entry.getValue().size();

			int take = Math.min(K, count);
			sum += take * score;
			K -= take;

			if (K == 0)
				break;
		}

		return sum;
	}

	// ✅ Reset player
	public void reset(int playerId) {
		if (!playerScore.containsKey(playerId))
			return;

		int score = playerScore.get(playerId);

		LinkedHashSet<Integer> set = scoreMap.get(score);
		set.remove(playerId);

		if (set.isEmpty()) {
			scoreMap.remove(score);
		}

		int count = scoreFreq.get(score);
		if (count == 1) {
			scoreFreq.remove(score);
		} else {
			scoreFreq.put(score, count - 1);
		}

		playerScore.remove(playerId);
	}

	// ✅ Get Rank (1-based)
	public int getPlayerRank(int playerId) {
		if (!playerScore.containsKey(playerId))
			return -1;

		int pScore = playerScore.get(playerId);
		int rank = 1;

		// 🔥 Count players with higher score
		for (Map.Entry<Integer, Integer> entry : scoreFreq.entrySet()) {
			int score = entry.getKey();
			if (score > pScore) {
				rank += entry.getValue();
			} else {
				break;
			}
		}

		// 🔥 Tie-breaking: insertion order
		LinkedHashSet<Integer> set = scoreMap.get(pScore);
		for (int id : set) {
			if (id == playerId)
				break;
			rank++;
		}

		return rank;
	}
}