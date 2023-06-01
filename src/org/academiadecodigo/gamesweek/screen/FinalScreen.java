package org.academiadecodigo.gamesweek.screen;

public enum FinalScreen {
    GAME_OVER("GameOver"),
    YOU_WIN("YouWin");

    private final String path;

    FinalScreen(String path) {
        this.path = "resources/" + path + ".png";
    }

    public String getPath() {
        System.out.println(path);
        return path;
    }
}
