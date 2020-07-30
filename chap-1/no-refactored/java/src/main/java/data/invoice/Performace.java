package data.invoice;

import data.play.Play;

public class Performace {

    private Play play;
    private Integer audience;

    public Performace(Play play, Integer audience) {
        this.play = play;
        this.audience = audience;
    }

    public Play getPlay() {
        return play;
    }

    public void setPlay(Play play) {
        this.play = play;
    }

    public Integer getAudience() {
        return audience;
    }

    public void setAudience(Integer audience) {
        this.audience = audience;
    }
}
