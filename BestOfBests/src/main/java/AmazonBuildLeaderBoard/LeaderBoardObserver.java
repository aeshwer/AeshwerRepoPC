package AmazonBuildLeaderBoard;

public interface LeaderBoardObserver {

	void onScoreUpdate(int playerId, int deltaScore, long timestamp);

}
