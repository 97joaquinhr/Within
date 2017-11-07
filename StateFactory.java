public class StateFactory {
	private GameState s;
	private static StateFactory instance;
	
	public static synchronized StateFactory getInstance(){
		if(instance == null){
			instance = new StateFactory();
		}
		return instance;
	}
	public GameState getState(int option){
		switch(option){
			case 1://running
				s = new GameStateRunning();
				break;
			case 2://pause
				s = new GameStatePaused();
				break;
			case 3://game over
				s = new GameStateGameOver();
				break;
			default:
				break;
			
		}
		return s;
	}

}
