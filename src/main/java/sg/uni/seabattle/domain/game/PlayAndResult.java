package sg.uni.seabattle.domain.game;

import lombok.Getter;

@Getter
public class PlayAndResult {
    private final PlayAction playAction;
    private final ActionResultType result;

    public PlayAndResult(PlayAction playAction, ActionResultType result) {
        this.playAction = playAction;
        this.result = result;
    }
}
