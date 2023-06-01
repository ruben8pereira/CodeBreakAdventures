package org.academiadecodigo.gamesweek;

import org.academiadecodigo.gamesweek.entity.*;
import org.academiadecodigo.gamesweek.grid.Grid;
import org.academiadecodigo.gamesweek.interfaces.Movable;
import org.academiadecodigo.gamesweek.interfaces.Shootable;

import java.util.ArrayList;

public class CollisionDetector {
    private ArrayList<Bullet> bullets;
    private ArrayList<Bullet> bulletsToBeAdded;
    private ArrayList<Bullet> bulletsToBeRemoved;
    private ArrayList<Shootable> shootablesToBeShot;
    private ArrayList<Movable> movables;
    private ArrayList<Shootable> shootables;
    private DrunkCodeCadet drunkCodeCadet;

    public CollisionDetector(ArrayList<Movable> movables, ArrayList<Shootable> shootables, DrunkCodeCadet drunkCodeCadet) {
        bullets = new ArrayList<>();
        bulletsToBeAdded = new ArrayList<>();
        bulletsToBeRemoved = new ArrayList<>();
        shootablesToBeShot = new ArrayList<>();
        this.movables = movables;
        this.shootables = shootables;
        this.drunkCodeCadet = drunkCodeCadet;
    }

    public void check() {
        for (Bullet bullet : bullets) {
            for (Shootable shootable : shootables) {
                int xMin = shootable.getGridPosition().getX();
                int yMin = shootable.getGridPosition().getY();
                int xMax = shootable.getGridPosition().getMaxX();
                int yMax = shootable.getGridPosition().getMaxY();
                int bulletX = bullet.getGridPosition().getX();
                int bulletY = bullet.getGridPosition().getY();
                int bulletMaxX = bullet.getGridPosition().getMaxX();
                int bulletMaxY = bullet.getGridPosition().getMaxY();
                if ((bulletX > xMin && bulletX < xMax) && (bulletY > yMin && bulletY < yMax) ||
                        (bulletMaxX > xMin && bulletMaxX < xMax) && (bulletMaxY > yMin && bulletMaxY < yMax) ||
                        (bulletMaxX > xMin && bulletX < xMax) && (bulletY > yMin && bulletY < yMax) ||
                        (bulletX > xMin && bulletX < xMax) && (bulletMaxY > yMin && bulletMaxY < yMax)) {
                    shootablesToBeShot.add(shootable);
                    bulletsToBeRemoved.add(bullet);
                }
            }

            if (bullet.getGridPosition().getY() == Grid.PADDING || bullet.getGridPosition().getMaxY() == bullet.getGrid().getHeight()) {
                bulletsToBeRemoved.add(bullet);
            }
        }
        removeBullets();
        addBullets();
        shootShootables();
    }

    public void addBullet(Bullet bullet) {
        bulletsToBeAdded.add(bullet);
    }

    private void addBullets() {
        for (Bullet bullet : bulletsToBeAdded) {
            bullets.add(bullet);
            movables.add(bullet);
        }
        bulletsToBeAdded.clear();
    }

    private void removeBullets() {
        for (Bullet bullet : bulletsToBeRemoved) {
            bullet.delete();
            bullets.remove(bullet);
            movables.remove(bullet);
        }
        bulletsToBeRemoved.clear();
    }

    private void shootShootables() {
        for (Shootable shootable : shootablesToBeShot) {
            shootable.getShot();
            if (shootable.isBroken()) {
                shootables.remove(shootable);
            }
        }
        shootablesToBeShot.clear();
    }

    public boolean isGameOver() {
        for (Shootable cadet : shootables) {
            if (cadet.getGridPosition().getMaxY() == drunkCodeCadet.getGridPosition().getY()) {
                return true;
            }
        }
        return false;
    }

    public boolean isLevelCompleted() {
        if (shootables.size() == 0) {
            return true;
        }
        return false;
    }
}
